package io.jontesgithub.jswish_microservice.service;

import io.jontesgithub.jswish_microservice.domain.JSwishUser;
import io.jontesgithub.jswish_microservice.repository.JswishUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JSwishService {
    private JswishUserRepository jswishUserRepository;

    @Autowired
    public JSwishService(JswishUserRepository jswishUserRepository) {
        this.jswishUserRepository = jswishUserRepository;
    }

    public void saveUser(String phoneNumber) {
        jswishUserRepository.save(new JSwishUser(phoneNumber));
    }

    public boolean findPhoneNumber(String phoneNumber) {
        return jswishUserRepository.existsByPhoneNumber(phoneNumber);
    }
}
