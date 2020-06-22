package io.jontesgithub.bank_microservice.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@RequiredArgsConstructor
public class Login {
    @NotBlank(message = "phoneNumber is mandatory.")
    @Pattern(regexp = "^(([+]46)\\s*(7)|07)[02369]\\s*(\\d{4})\\s*(\\d{3})$", message = "phoneNumber invalid format")
    private final String phoneNumber;

    @NotBlank(message = "passcode is mandatory")
    @Pattern(regexp = "^[0-9]{6}", message = "passcode must be digits and 6 in length.")
    private final String passcode;
}
