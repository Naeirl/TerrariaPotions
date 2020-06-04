package com.example.terrariapotions.Model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ChuckNoris implements Serializable {
    private List<String> categories;
    private Date created_at;
    private String icon_url;
    private String id;
    private Date updated_at;
    private String url;
    private String value;

    public ChuckNoris(List<String> categories, Date created_at, String icon_url, String id, Date updated_at, String url, String value) {
        this.categories = categories;
        this.created_at = created_at;
        this.icon_url = icon_url;
        this.id = id;
        this.updated_at = updated_at;
        this.url = url;
        this.value = value;
    }

    public List<String> getCategories() {
        return categories;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public String getIcon_url() {
        return icon_url;
    }

    public String getId() {
        return id;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public String getUrl() {
        return url;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "ChuckNoris{" +
                "categories=" + categories +
                ", created_at=" + created_at +
                ", icon_url='" + icon_url + '\'' +
                ", id='" + id + '\'' +
                ", updated_at=" + updated_at +
                ", url='" + url + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
