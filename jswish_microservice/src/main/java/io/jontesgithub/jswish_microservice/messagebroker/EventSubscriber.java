package io.jontesgithub.jswish_microservice.messagebroker;

import io.jontesgithub.jswish_microservice.service.JSwishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
class EventSubscriber {

    private final JSwishService jSwishService;

    @Autowired
    public EventSubscriber(JSwishService jSwishService) {
        this.jSwishService = jSwishService;
    }

    @RabbitListener(queues = "${bankMicroservice.queue}")
    void handleMultiplicationSolved(final BankNewRegistrationEvent event) {
        log.info("Bank New Registration Event received: {}", event.getPhoneNumber());
        try {
            jSwishService.saveUser(event.getPhoneNumber());

        } catch (final Exception e) {
            log.error("Error when trying to process Bank New Registration Event", e);
            // Avoids the event to be re-queued and reprocessed.
            throw new AmqpRejectAndDontRequeueException(e);
        }
    }
}
