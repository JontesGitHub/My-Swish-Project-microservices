package io.jontesgithub.bank_microservice.controller;

import io.jontesgithub.bank_microservice.domain.Login;
import io.jontesgithub.bank_microservice.domain.Person;
import io.jontesgithub.bank_microservice.service.BankIDService;
import io.jontesgithub.bank_microservice.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class BankController {

    private BankService bankService;
    private BankIDService bankIDService;

    @Autowired
    public BankController(BankService bankService, BankIDService bankIDService) {
        this.bankService = bankService;
        this.bankIDService = bankIDService;
    }

    @PostMapping("/bank/person/bankid/login")
    public ResponseEntity<String> bankIdLogin(@RequestBody Login bankIdLogin) {
        if(bankIDService.bankIdLogin(bankIdLogin)) return ResponseEntity.ok("Login successful");
        else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Login failed.");
    }

    @PostMapping("/bank/person")
    public ResponseEntity<String> createPerson(@Valid @RequestBody Person person) throws MethodArgumentNotValidException {
        if(bankService.createAndSavePerson(person)) return ResponseEntity.ok("Person created successfully");
        else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Person failed to be created.");
    }
}

