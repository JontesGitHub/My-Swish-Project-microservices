package io.jontesgithub.bank_microservice.messagebroker;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EventPublisher {

    private RabbitTemplate rabbitTemplate;

    private String bankMicroserviceExchange;

    private String bankNewRegistrationRoutingKey;

    @Autowired
    public EventPublisher(RabbitTemplate rabbitTemplate,
                          @Value("${bankMicroservice.exchange.name}") String bankMicroserviceExchange,
                          @Value("${bank.new.registration.key}") String bankNewRegistrationRoutingKey) {
        this.rabbitTemplate = rabbitTemplate;
        this.bankMicroserviceExchange = bankMicroserviceExchange;
        this.bankNewRegistrationRoutingKey = bankNewRegistrationRoutingKey;
    }

    public void send(final BankNewRegistrationEvent event) {
        rabbitTemplate.convertAndSend(bankMicroserviceExchange, bankNewRegistrationRoutingKey, event);
    }
}
