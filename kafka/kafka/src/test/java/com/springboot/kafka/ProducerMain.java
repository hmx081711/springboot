package com.springboot.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class ProducerMain {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Properties prop = new Properties();
        prop.setProperty("bootstrap.servers","localhost:9092");
        KafkaProducer<String,String> producer = new KafkaProducer(prop, new StringSerializer(),new StringSerializer());
        ProducerRecord record = new ProducerRecord("sf", 0, "message", "大家好");
        Future future = producer.send(record);
        RecordMetadata metadata = (RecordMetadata) future.get();
        System.out.println(metadata);
    }
}
