package com.exceptionalcode.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
public class SpringBootServerApplication {

    /**
     * This is a default endpoint of server application
     *
     * @return {@link String} This method will return default message from server
     */
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public ResponseEntity<String> callServer() {
        return new ResponseEntity<>("Hi!!!", HttpStatus.OK);
    }


    /**
     * This is an endpoint which will internally called by client application using RestTemplate
     *
     * @return {@link String} This method will return message coming from server to client
     */
    @RequestMapping(method = RequestMethod.GET, value = "/callServer")
    public ResponseEntity<String> hello() {
        return new ResponseEntity<>("Hello from server", HttpStatus.OK);
    }

    /**
     * Main method from which execution will start.
     *
     * @param args {@link String[]}
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringBootServerApplication.class, args);
    }

}
