package org.example.models;

import jakarta.persistence.*;

import java.util.UUID;

@MappedSuperclass
public abstract class Base {
    @Id
    @GeneratedValue(generator = "uuid")
    @Column(name = "id")
    protected UUID id;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
