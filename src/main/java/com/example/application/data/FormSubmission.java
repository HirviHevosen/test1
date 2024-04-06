package com.example.application.data;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class FormSubmission extends AbstractEntity {

    @NotEmpty
    private String data;

    @NotEmpty
    private String user_id;

    @ManyToOne
    private CloudSchema cloud_schema;

    public FormSubmission() {
    }

    public FormSubmission(String data, String user_id, CloudSchema cloudSchema) {
        this.data = data;
        this.user_id = user_id;
        this.cloud_schema = cloudSchema;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public CloudSchema getCloudSchema() {
        return cloud_schema;
    }

    public void setCloudSchema(CloudSchema cloudSchema) {
        this.cloud_schema = cloudSchema;
    }

    public static FormSubmission from(String userId, CloudSchema cloud_schema){
        var formSubmission = new FormSubmission();
        formSubmission.user_id = userId;
        formSubmission.cloud_schema = cloud_schema;
        return formSubmission;
    }
}
