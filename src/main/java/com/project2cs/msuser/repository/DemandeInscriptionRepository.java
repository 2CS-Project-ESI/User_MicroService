package com.project2cs.msuser.repository;

import com.project2cs.msuser.model.DemandeInscription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DemandeInscriptionRepository extends JpaRepository<DemandeInscription, Integer> {
    List<DemandeInscription> findByStatut(String statut);
}
