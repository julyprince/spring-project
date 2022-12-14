package org.umss.sisumss.dtos;

public class SubjectDTO {

    private String uuid;
    private  String code;
    private  String name;

    public SubjectDTO() {
    }

    public SubjectDTO(String uuid, String name, String code) {
        this.uuid = uuid;
        this.code = code;
        this.name = name;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
