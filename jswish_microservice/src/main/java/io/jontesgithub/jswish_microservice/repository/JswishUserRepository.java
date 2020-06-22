package io.jontesgithub.jswish_microservice.repository;

import io.jontesgithub.jswish_microservice.domain.JSwishUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JswishUserRepository extends JpaRepository<JSwishUser, UUID> {
     boolean existsByPhoneNumber(String phoneNumber);
}
