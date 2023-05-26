package org.example;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class ProducerKafka {

    public static void sendData(String topic, String key, String value) {
        // Set properties
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("acks", "all");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        // Create the producer
        KafkaProducer<String, String> producer = new KafkaProducer<>(props);

        // Create a record to send
        ProducerRecord<String, String> record = new ProducerRecord<>(topic, key, value);

        // Send the record
        producer.send(record);

        // Close the producer
        producer.close();

        System.out.println("Successfully send!");
    }

}
