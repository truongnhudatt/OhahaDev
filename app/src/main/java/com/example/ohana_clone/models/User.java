package com.example.ohana_clone.models;

public class User {

    private String name;
    private String from, to;
    private String location;

    private int resourceId;
    public User(String name, String from, String to, String location, int resourceId) {
        this.name = name;
        this.from = from;
        this.to = to;
        this.location = location;
        this.resourceId = resourceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }
}
