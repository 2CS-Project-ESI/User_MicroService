package com.project2cs.msuser.repository;

import com.project2cs.msuser.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
