//package io.jontesgithub.jswish_microservice.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.reactive.function.client.ClientResponse;
//import org.springframework.web.reactive.function.client.WebClient;
//
//@RestController
//public class LoginController {
//
//    private final WebClient webClient;
//
//    @Autowired
//    public LoginController(WebClient webClient) {
//        this.webClient = webClient;
//    }
//
//    @GetMapping("/user")
//    public String findPhoneNumber(@RequestParam(name = "phonenumber") String phoneNumber) {
//        HttpStatus status = webClient.get()
//                .uri(uriBuilder -> uriBuilder
//                        .path("/bank/person")
//                        .queryParam("phonenumber", phoneNumber)
//                        .build())
//                .exchange()
//                .map(ClientResponse::statusCode).block();
//        if (status == HttpStatus.OK) {
//            return "exsits"; // ...
//        } else return "not found"; // ...
//    }
//
//    // webclient to send login
//
//}
