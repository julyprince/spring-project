package org.umss.sisumss.models;

import java.util.Date;
import java.util.UUID;

public class University {
    private int id;
    private String uuid;
    private String name;
    private String code;
    private Date date;

    public University() {
    }

    public University(int id, String uuid, String name, String code, Date date) {
        this.id = id;
        this.uuid = uuid;
        this.name = name;
        this.code = code;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
