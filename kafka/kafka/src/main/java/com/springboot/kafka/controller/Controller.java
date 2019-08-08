package com.springboot.kafka.controller;

import com.springboot.kafka.pojo.User;
import org.apache.kafka.clients.consumer.Consumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.ConsumerAwareRebalanceListener;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/kafka")
public class Controller {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Autowired
    private ConsumerFactory kafkaConsumerFactory;

    @RequestMapping("/send")
    public String sendMessage(@RequestParam(name = "meg") String meg) {

        kafkaTemplate.send("sf","message",meg);
        return meg;
    }

    @PostMapping("/save")
    public User saveUser(@RequestBody User user) {
        kafkaTemplate.send("sf-user",user);
        return user;
    }
}
