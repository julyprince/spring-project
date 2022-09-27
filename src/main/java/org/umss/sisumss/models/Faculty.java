package org.umss.sisumss.models;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Faculty { //con relacion uno a muchos univerisdad tiene muchas facultades

    @Id
    @GeneratedValue
    private Integer id;
    @Column(updatable = false, nullable = false, unique = true, length = 36)
    private String uuid;
    @Column(updatable = false, length = 500)
    private String code;
    @Column(updatable = false, length = 20)
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)//relacion uno a muchos y con (LAZY) decimos que no popule por defecto
    private University university;// solo si decimos que cargue va a cargar la universidad (EAGER va ser ciclo infinito entre busqueda universidad y facultad)
    @CreatedDate//inyecta la fecha de creacion sirve para auditorias
    @Column(updatable = false, nullable = false)
    private Date createDate;
    @LastModifiedDate
    @Column(updatable = true, nullable = false)
    private Date modifyDate;
    public Faculty() {
    }

    public Faculty(Integer id, String uuid, String code, String name) {
        this.id = id;
        this.uuid = uuid;
        this.code = code;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    @PrePersist //para que se autogenere el uuid
    public void inicializeUuid(){
        this.setUuid(UUID.randomUUID().toString());
    }
}
