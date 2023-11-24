package com.kefas.TaskBackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.antlr.v4.runtime.misc.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@lombok.Data
public class Data {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String sectors;

    private boolean agreeTerms;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
