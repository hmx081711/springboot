package com.springboot.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.LinkedList;
import java.util.Properties;

public class CustomerMain {

    public static void main(String[] args) {
        Properties prop = new Properties();
        prop.setProperty("bootstrap.servers","localhost:9092");
        prop.setProperty("group.id","0");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(prop, new StringDeserializer(),new StringDeserializer());
        LinkedList<String> topics = new LinkedList<>();
        topics.add("sf");
        consumer.subscribe(topics);
        while (true) {
            Duration duration = Duration.ofMillis(1000);
            ConsumerRecords<String, String> records = consumer.poll(duration);
            for (ConsumerRecord<String,String> record:records) {
                System.out.println(record.key() + ":" + record.value());
            }
        }
    }
}
