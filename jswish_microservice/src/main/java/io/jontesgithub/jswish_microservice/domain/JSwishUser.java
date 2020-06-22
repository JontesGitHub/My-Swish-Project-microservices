package io.jontesgithub.jswish_microservice.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
public class JSwishUser {

    @Id
    @GeneratedValue
    private UUID id;
    @NotBlank
    @Column(unique = true)
    private final String phoneNumber;

    public JSwishUser() {
        this(null);
    }
}
