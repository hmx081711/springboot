package com.springboot.kafka.consumerListener;

import com.springboot.kafka.pojo.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class ConsumerListener {

    @KafkaListener(topics = "sf")
    public void messageListener(String meg) {
        System.out.println(meg);
    }

    @KafkaListener(topics = "sf-user")
    public void messageListener(User user) {
        System.out.println(user);
    }
}
