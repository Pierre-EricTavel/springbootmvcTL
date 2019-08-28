/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.itta.springbootmvc.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import lombok.*;
import java.util.Objects;
import javax.validation.constraints.*;




@Setter
@Getter
@ToString(exclude = "proprietaire")
public class Voiture implements Serializable{

    @NotNull
    @Min(1)
    Integer id;
    
    @Size(min=1, max=25)
    String name;
    
    Personne proprietaire;

    public Voiture(Integer id, String name, Personne proprietaire) {
        this.id = id;
        this.name = name;
        this.proprietaire = proprietaire;
    }

    public Voiture(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Voiture() {
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Voiture other = (Voiture) obj;
        return Objects.equals(this.id, other.id);
    }
    
}
