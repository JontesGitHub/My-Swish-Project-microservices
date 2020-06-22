package io.jontesgithub.bank_microservice.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class BankID {
    @Id
    private UUID id;

    @NotBlank(message = "passcode is mandatory")
    @Pattern(regexp = "^[0-9]{6,8}", message = "passcode must be 6 to 8 digits.")
    private String passcode;

    @OneToOne
    @MapsId
    private Person owner;

    public BankID(String passcode) {
        this.passcode = passcode;
    }

}
