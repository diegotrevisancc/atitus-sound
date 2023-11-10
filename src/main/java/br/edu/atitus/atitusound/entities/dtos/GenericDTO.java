package br.edu.atitus.atitusound.entities.dtos;

import java.util.UUID;

public class GenericDTO {
    private UUID uuid;
    private String name;
    public UUID getUuid() {
        return uuid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
