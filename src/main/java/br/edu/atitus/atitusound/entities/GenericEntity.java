package br.edu.atitus.atitusound.entities;

import jakarta.persistence.*;

import javax.annotation.processing.Generated;
import java.util.UUID;

@MappedSuperclass
public class GenericEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @Column(nullable = false)
    private String name;

    public UUID getUuid() {
        return this.uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
