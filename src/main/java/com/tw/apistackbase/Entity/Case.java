package com.tw.apistackbase.Entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Case {

    public Case() {
    }

    public Case(@NotNull Long time, @NotNull String name) {
        this.time = time;
        this.name = name;
    }

    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;

    @NotNull
    private Long time;

    @NotNull
    private String name;
}
