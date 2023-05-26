package org.example;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;

import java.util.Collections;
import java.util.Objects;
import java.util.Properties;

public class KafkaConfig {
    public static void recreateTopic(String topic) {
        if(Objects.nonNull(topic)) {
            Properties config = new Properties();
            config.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
            AdminClient admin = AdminClient.create(config);

            // Delete the topic
            admin.deleteTopics(Collections.singletonList(topic));

            // Create the topic
            NewTopic newTopic = new NewTopic(topic, 3, (short) 2);
            admin.createTopics(Collections.singleton(newTopic));

            // Don't forget to close the AdminClient
            System.out.println("Successfully recreated topic : " + topic);
            admin.close();
        }
    }
}
