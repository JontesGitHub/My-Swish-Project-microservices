package io.jontesgithub.bank_microservice.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Person {
    @Id
    @GeneratedValue
    private UUID id;

    @NotBlank(message = "name is mandatory.")
    private String name;

    @Column(unique = true)
    @NotBlank(message = "phoneNumber is mandatory.")
    @Pattern(regexp = "^(([+]46)\\s*(7)|07)[02369]\\s*(\\d{4})\\s*(\\d{3})$", message = "phoneNumber invalid format")
    private String phoneNumber;

    @OneToOne(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private BankAccount bankAccount;

    @Valid
    @NotNull(message = "bankID is mandatory.")
    @OneToOne(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private BankID bankID;

    public Person(String name, String phoneNumber, BankAccount bankAccount, BankID bankID) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.bankAccount = bankAccount;
        this.bankID = bankID;
    }

    public Person(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
}
