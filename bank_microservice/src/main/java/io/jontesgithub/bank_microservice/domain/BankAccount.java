package io.jontesgithub.bank_microservice.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import java.util.UUID;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class BankAccount {
    @Id
    private UUID id;
    @NonNull
    private int balance;
    @OneToOne
    @MapsId
    private Person owner;
}
