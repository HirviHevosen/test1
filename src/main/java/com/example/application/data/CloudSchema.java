package com.example.application.data;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;

import java.util.LinkedList;
import java.util.List;

@Entity
public class CloudSchema extends AbstractEntity {
    @NotBlank
    private String name;

    @NotBlank
    @Column(columnDefinition="TEXT")
    private String schema_data;

    @OneToMany(mappedBy = "cloud_schema")
    @Nullable
    private List<FormSubmission> formSubmissions = new LinkedList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FormSubmission> getFormSubmissions() {
        return formSubmissions;
    }

    public void setFormSubmissions(List<FormSubmission> employees) {
        this.formSubmissions = employees;
    }

    public String getSchema_data() {
        return schema_data;
    }

    public void setSchema_data(String schema_data) {
        this.schema_data = schema_data;
    }
    public static CloudSchema from(String schema_name){
        var schema = new CloudSchema();
        schema.name = schema_name;
        schema.formSubmissions= null;
        return schema;
    }
}
