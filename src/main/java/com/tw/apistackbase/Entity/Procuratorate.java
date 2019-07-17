package com.tw.apistackbase.Entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
public class Procuratorate {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;

    @NotNull
    @Column(unique = true, length = 50)
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Prosecutor> prosecutors;

    public Procuratorate() {
    }

    public Procuratorate(@NotNull String name) {
        this.name = name;
    }

    public Set<Prosecutor> getProsecutors() {
        return prosecutors;
    }

    public void setProsecutors(Set<Prosecutor> prosecutors) {
        this.prosecutors = prosecutors;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addProsecutor(Prosecutor prosecutor) {
        this.prosecutors.add(prosecutor);
    }
}
