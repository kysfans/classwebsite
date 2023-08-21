package com.frederic.classpage.models;

public class ClassPhoto {
    private String photoName;
    private String description;
    private String imageUrl;

    public ClassPhoto(String photoName, String description, String imageUrl) {
        this.photoName = photoName;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
