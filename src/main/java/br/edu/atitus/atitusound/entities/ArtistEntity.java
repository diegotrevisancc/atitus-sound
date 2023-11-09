package br.edu.atitus.atitusound.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "artist")
public class ArtistEntity extends GenericEntity{
    private String image;

    private String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
