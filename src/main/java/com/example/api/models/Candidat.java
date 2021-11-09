package com.example.api.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
@Table(name = "candidat")
public class Candidat {
    @Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nom")
    @NotNull(message="Le champ nom ne peut pas être null")
    @NotBlank(message="Le champ nom ne peut pas être vide")
    private String nom;

    @Column(name="prenom")
    @NotNull(message="Le champ prénom ne peut pas être null")
    @NotBlank(message="Le champ prénom ne peut pas être vide")
    private String prenom;

    @Column(name="dateNaissance")
    @NotNull(message="Le champ naissance ne peut pas être null")
    @DateTimeFormat(pattern="dd-mm-yyyy")
    @JsonFormat(pattern="yyyy-mm-dd")
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;

    @Column(name="adresse")
    @NotNull(message="Le champ adresse ne peut pas être null")
    @NotBlank(message="Le champ adresse ne peut pas être vide")
    private String adresse;

    @Column(name="ville")
    @NotNull(message="Le champ ville ne peut pas être null")
    @NotBlank(message="Le champ ville ne peut pas être vide")
    private String ville;

    @Column(name="codePostal")
    @NotNull(message="Le champ code postal ne peut pas être null")
    @NotBlank(message="Le champ code postal ne peut pas être vide")
    private String codePostal;

    public Candidat () {

    }

    public Candidat(String nom, String prenom, Date dateNaissance, String adresse, String ville, String codePostal) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.adresse = adresse;
        this.ville = ville;
        this.codePostal = codePostal;
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getVille() {
        return ville;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }
}
