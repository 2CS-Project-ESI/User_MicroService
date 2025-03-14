package com.project2cs.msuser.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Client extends Utilisateur {

    private String adresse;
}
