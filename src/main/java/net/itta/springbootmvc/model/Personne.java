/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.itta.springbootmvc.model;


import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.validation.constraints.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;


@ToString(exclude = "voitures")
public class Personne implements Serializable {

    private Integer id;
    
    @Size( max=25,message = "nom trop long ou trop court")
    private String nom;
    
    @Size(min=1, max=40,message = "prenom trop long ou trop court")
    private String prenom;

    @PastOrPresent()
    @DateTimeFormat(pattern = "yyyy-MM-dd",iso = DateTimeFormat.ISO.DATE)
    private Date naissance;

    //@Constraint(validatedBy = ConstraintValidator.class)
    private List<Voiture> voitures;
    
    public Personne(Integer id, String nom, String prenom, Date naissance) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.naissance = naissance;
    }

    public Personne() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Personne other = (Personne) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getNaissance() {
        return naissance;
    }

    public void setNaissance(Date naissance) {
        this.naissance = naissance;
    }

    public List<Voiture> getVoitures() {
        return voitures;
    }

    public void setVoitures(List<Voiture> voitures) {
        this.voitures = voitures;
    }


    
    
}
