package com.latam.hackday.producer.rest;

import org.springframework.cloud.gcp.pubsub.core.PubSubTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

    private final PubSubTemplate pubSubTemplate;
    private final String TOPIC_NAME = "papa-pago";

    public ProducerController(PubSubTemplate pubSubTemplate) {
        this.pubSubTemplate = pubSubTemplate;
    }

    @PostMapping("/hello")
    public ResponseEntity<?> publishMessage(@RequestBody String message) {
        this.pubSubTemplate.publish(TOPIC_NAME, message);
        return new ResponseEntity("Messages published asynchronously; status unknown.", HttpStatus.OK);
    }


}
