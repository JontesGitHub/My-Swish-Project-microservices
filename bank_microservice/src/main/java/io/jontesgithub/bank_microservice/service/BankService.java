package io.jontesgithub.bank_microservice.service;

import io.jontesgithub.bank_microservice.domain.BankAccount;
import io.jontesgithub.bank_microservice.domain.BankID;
import io.jontesgithub.bank_microservice.domain.Person;
import io.jontesgithub.bank_microservice.messagebroker.BankNewRegistrationEvent;
import io.jontesgithub.bank_microservice.messagebroker.EventPublisher;
import io.jontesgithub.bank_microservice.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BankService {

    private PersonRepository personRepository;

    @Value("${bankMicroservice.bankAccountStartingBalance}")
    private int bankAccountStartingBalance;

    private EventPublisher eventPublisher;

    @Autowired
    public BankService(PersonRepository personRepository, EventPublisher eventPublisher) {
        this.personRepository = personRepository;
        this.eventPublisher = eventPublisher;
    }

    @Transactional
    public Person createNewUser(String name, String phoneNumber, String bankIDpasscode) {
            BankAccount account = new BankAccount(bankAccountStartingBalance);
            BankID bankID = new BankID(bankIDpasscode);
            Person person = new Person(name,phoneNumber,account, bankID);
            account.setOwner(person);
            bankID.setOwner(person);

            return personRepository.save(person);
    }

    public Person findPhoneNumber(String phoneNumber) throws NoSuchFieldError {
        return personRepository.findPersonByPhoneNumber(phoneNumber)
                .orElseThrow(NoSuchFieldError::new);
    }

    @Transactional
    public boolean createAndSavePerson(Person person) {
        try {
            person.setBankAccount(null);
            BankAccount account = new BankAccount(bankAccountStartingBalance);
            person.setBankAccount(account);
            account.setOwner(person);
            person.getBankID().setOwner(person);

            Person saved = personRepository.save(person);
            // EVENT: send
            eventPublisher.send(new BankNewRegistrationEvent(saved.getPhoneNumber()));
            return true;
        } catch (Exception e) {
            return false;
        }

    }
}
