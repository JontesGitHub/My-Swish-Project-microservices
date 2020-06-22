package io.jontesgithub.bank_microservice.service;

import io.jontesgithub.bank_microservice.domain.Login;
import io.jontesgithub.bank_microservice.domain.Person;
import io.jontesgithub.bank_microservice.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class BankIDService {
    private PersonRepository personRepository;

    @Autowired
    public BankIDService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public boolean bankIdLogin(Login login) throws NoSuchElementException {
        Person found = personRepository.findPersonByPhoneNumber(login.getPhoneNumber())
                .orElseThrow(NoSuchElementException::new);

        return found.getBankID().getPasscode().equals(login.getPasscode());

    }

}
