package io.jontesgithub.bank_microservice.repository;

import io.jontesgithub.bank_microservice.domain.BankID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BankIDRepository extends JpaRepository<BankID, UUID> {
}
