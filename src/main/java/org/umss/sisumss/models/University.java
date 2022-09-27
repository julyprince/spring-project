package org.umss.sisumss.models;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@EntityListeners(AuditingEntityListener.class)//debe actuar con esa auditoria creada
public class University {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(updatable = false, nullable = false, unique = true, length = 36)
    private String uuid;
    @Column(updatable = false, length = 500)
    private String name;
    @Column(updatable = false, length = 20)
    private String code;
    @CreatedDate//inyecta la fecha de creacion
    @Column(updatable = false, nullable = false)
    private Date createDate;
    @LastModifiedDate
    @Column(updatable = true, nullable = false)
    private Date modifyDate;
    @OneToMany(mappedBy =  "university")//relacion uno muchos recordar poner el campo de la relacion igual que en la otra entidad "university"
    private List<Faculty>facultyList;
    public University() {
    }

    public University(Integer id, String uuid, String name, String code, Date createDate) {
        this.id = id;
        this.uuid = uuid;
        this.name = name;
        this.code = code;
        this.createDate = createDate;
    }

    public University(String uuid) {
        this.uuid = uuid;
    }
    public University(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public List<Faculty> getFacultyList() {
        return facultyList;
    }

    public void setFacultyList(List<Faculty> facultyList) {
        this.facultyList = facultyList;
    }


    @PrePersist
    public void inicializeUuid(){
        this.setUuid(UUID.randomUUID().toString());
    }
}
