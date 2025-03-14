package com.project2cs.msuser.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Livreur extends Utilisateur {

    private String vehicule;

    private float noteMoyenne;

    private boolean disponibilite;
}
