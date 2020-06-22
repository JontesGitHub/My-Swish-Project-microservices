package io.jontesgithub.jswish_microservice.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientBean {

    @Bean
    public WebClient autowireWebClient() {
        return WebClient.builder()
                .baseUrl("http://localhost:8082")
                .build();
    }
}
