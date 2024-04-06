package com.example.application.services;


import com.example.application.SignedUserHelper;
import com.example.application.data.CloudSchema;
import com.example.application.data.CloudSchemaRepository;
import com.example.application.data.FormSubmission;
import com.example.application.data.FormSubmissionRepository;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import dev.hilla.BrowserCallable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.data.domain.Example;

import java.util.List;
import java.util.Optional;


@AnonymousAllowed
@BrowserCallable
public class SettingsService {

    private final CloudSchemaRepository cloudSchemaRepository;
    private final FormSubmissionRepository formSubmissionRepository;

    public SettingsService(CloudSchemaRepository cloudSchemaRepository, FormSubmissionRepository formSubmissionRepository) {
        this.cloudSchemaRepository = cloudSchemaRepository;
        this.formSubmissionRepository = formSubmissionRepository;
    }

    public record FormSubmissionRecord(
            Long id,
            @NotNull
            @Size(min = 1, max = 50)
            String data,


            @NotNull
            CloudSchemaRecord cloudSchema
    ) {
    }

    public record CloudSchemaRecord(
            @NotNull
            Long id,
            String name,

            String schema_data
    ) {
    }


    private FormSubmissionRecord toContactRecord(FormSubmission c) {
        return new FormSubmissionRecord(
                c.getId(),
                c.getData(),
                new CloudSchemaRecord(
                        c.getCloudSchema().getId(),
                        c.getCloudSchema().getName(),
                        c.getCloudSchema().getSchema_data()
                )
        );
    }

    private CloudSchemaRecord toCompanyRecord(CloudSchema c) {
        return new CloudSchemaRecord(
                c.getId(),
                c.getName(),
                c.getSchema_data()
        );
    }
    private FormSubmissionRecord toFormSubmissionRecord(FormSubmission c) {
        return new FormSubmissionRecord(
                c.getId(),
                c.getData(),
                new CloudSchemaRecord(
                        c.getCloudSchema().getId(),
                        c.getCloudSchema().getName(),
                        c.getCloudSchema().getSchema_data()
                )
        );
    }

    public List<CloudSchemaRecord> findAllSchemas() {
        return cloudSchemaRepository.findAll().stream()
                .map(this::toCompanyRecord).toList();
    }

    public Optional<FormSubmissionRecord> findFormSubmission(CloudSchemaRecord schema) {
        Example<CloudSchema> cse = Example.of(CloudSchema.from(schema.name));
        Optional<CloudSchema> cloudSchema = cloudSchemaRepository.findOne(cse);
        Example<FormSubmission> example = Example.of(FormSubmission.from(SignedUserHelper.userId(), cloudSchema.get()));

        var findExample = formSubmissionRepository.findOne(example);
        if (findExample.isPresent()){

            var record = this.toFormSubmissionRecord(findExample.get());
            return Optional.of(record);
        }else {
            return null;
        }
    }



    private FormSubmission createFormSubmission(FormSubmissionRecord contact, CloudSchema cloudSchema) {
        var formSubmission = new FormSubmission();
        formSubmission.setData(contact.data);
        formSubmission.setCloudSchema(cloudSchema);
        formSubmission.setUser_id(SignedUserHelper.userId());
        return formSubmissionRepository.save(formSubmission);
    }

    public FormSubmissionRecord save(FormSubmissionRecord contact) {
        var cloudSchema = cloudSchemaRepository.findById(contact.cloudSchema.id).orElseThrow();
        FormSubmission dbContact;
        if(contact.id == null) {

              Example<FormSubmission> example = Example.of(FormSubmission.from(SignedUserHelper.userId(), cloudSchema));

            var findExample = formSubmissionRepository.findOne(example);
            dbContact = findExample.orElseGet(() -> createFormSubmission(contact, cloudSchema));
        }else {
            Optional<FormSubmission> dbContactO = formSubmissionRepository.findById(contact.id);

            if (!dbContactO.isPresent()) {
                dbContact = createFormSubmission(contact, cloudSchema);
            } else {
                dbContact = dbContactO.get();
            }
        }



        dbContact.setData(contact.data);
        dbContact.setUser_id(SignedUserHelper.userId());
        dbContact.setCloudSchema(cloudSchema);

        var saved = formSubmissionRepository.save(dbContact);

        return toContactRecord(saved);
    }

}