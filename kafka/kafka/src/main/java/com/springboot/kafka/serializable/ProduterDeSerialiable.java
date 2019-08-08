package com.springboot.kafka.serializable;


import org.apache.kafka.common.serialization.Serializer;

import java.io.*;
import java.util.Map;

public class ProduterDeSerialiable implements Serializer<Object> {
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public byte[] serialize(String topic, Object data) {

        byte[] bytes = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(data);
            bytes = byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return bytes;
    }

    @Override
    public void close() {

    }
}
