package com.project2cs.msuser.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Commercant extends Utilisateur {

    private String nomBoutique;

    private String adresse;

    private String NumRC;
}
