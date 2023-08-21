package com.frederic.classpage.models;

public class TeachingResource {
    private String resourceName;
    private String description;
    private String resourceUrl;

    public TeachingResource(String resourceName, String description, String resourceUrl) {
        this.resourceName = resourceName;
        this.description = description;
        this.resourceUrl = resourceUrl;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }
}
