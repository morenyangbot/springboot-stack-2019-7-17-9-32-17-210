package com.tw.apistackbase.Entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class CaseDetail {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;

    @NotNull
    private String objectiveFactor;

    @NotNull
    private String SubjectiveFactor;

    public CaseDetail(@NotNull String objectiveFactor, @NotNull String subjectiveFactor) {
        this.objectiveFactor = objectiveFactor;
        SubjectiveFactor = subjectiveFactor;
    }

    public CaseDetail() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObjectiveFactor() {
        return objectiveFactor;
    }

    public void setObjectiveFactor(String objectiveFactor) {
        this.objectiveFactor = objectiveFactor;
    }

    public String getSubjectiveFactor() {
        return SubjectiveFactor;
    }

    public void setSubjectiveFactor(String subjectiveFactor) {
        SubjectiveFactor = subjectiveFactor;
    }

}
