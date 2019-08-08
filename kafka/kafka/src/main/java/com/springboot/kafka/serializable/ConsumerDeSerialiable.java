package com.springboot.kafka.serializable;

import org.apache.kafka.common.serialization.Deserializer;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Map;

public class ConsumerDeSerialiable implements Deserializer {
    @Override
    public void configure(Map configs, boolean isKey) {

    }

    @Override
    public Object deserialize(String topic, byte[] data) {

        Object obj = null;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            obj = objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return obj;
    }

    @Override
    public void close() {

    }
}
