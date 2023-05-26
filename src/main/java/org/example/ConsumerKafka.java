package org.example;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Properties;

public class ConsumerKafka {
    public static void consume(String topic) {
        // Set properties used to configure the consumer
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", "test");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("auto.offset.reset", "earliest");

        // Define the Kafka consumer
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);

        // Subscribe to the topic
        consumer.subscribe(Collections.singletonList(topic));

        int count = 0;
        // Continuously read from the topic
        while (count < 1) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(10000));
            for (ConsumerRecord<String, String> record : records) {
                HashMap<String, String> hm = new HashMap<>();
//                System.out.println(hm.get("key").length());
                System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
                count++;
            }
        }

    }
}
