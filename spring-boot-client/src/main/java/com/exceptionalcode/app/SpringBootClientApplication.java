package com.exceptionalcode.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * This class is starting point for the spring boot application
 * <p>
 * It is responsible to start spring boot application
 * </p>
 *
 * @author ishaan solanki
 */
@RestController
@SpringBootApplication
public class SpringBootClientApplication {
    /**
     * This is a default endpoint of client application
     *
     * @return {@link String} This method will return default message from client
     */
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public ResponseEntity<String> callClient() {
        return new ResponseEntity<>("Hello from client", HttpStatus.OK);
    }

    /**
     * This is an endpoint which will internally call server application using RestTemplate
     *
     * @return {@link String} This method will return message coming from server
     */
    @RequestMapping(method = RequestMethod.GET, value = "/callServerFromClient")
    public ResponseEntity<String> callServerFromClient() {
        RestTemplate restTemplate = new RestTemplate();
        String message = restTemplate.getForObject("http://springboot-server:9002/callServer", String.class);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    /**
     * Main method from which execution will start.
     *
     * @param args {@link String[]}
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringBootClientApplication.class, args);
    }

}
