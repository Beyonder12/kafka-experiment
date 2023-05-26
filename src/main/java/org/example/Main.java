package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
//        Map<String, Object> mp = new HashMap<>();
//        mp.put("name", "alghi");
//        mp.put("age", 1);
//        System.out.println(mp);
//
//        ObjectMapper om = new ObjectMapper();
//        String objString = om.writeValueAsString(mp);
//        System.out.println(objString);
//
//        JSONObject jsonObject = new JSONObject(mp);
//        System.out.println(jsonObject);

        ProducerKafka.sendData("mytopic", "mykey", "fajri");
        ConsumerKafka.consume("mytopic");

    }
}