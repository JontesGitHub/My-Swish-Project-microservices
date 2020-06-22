package io.jontesgithub.bank_microservice.messagebroker;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class BankNewRegistrationEvent implements Serializable {
    private String phoneNumber;
}
