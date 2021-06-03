package com.careerdrill.radis.subscribe;

import com.careerdrill.radis.entity.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

import java.io.IOException;

public class EmployeeITSubscriber implements MessageListener {
    private final Logger LOGGER = LoggerFactory.getLogger(EmployeeITSubscriber.class);

    ObjectMapper mapper = new ObjectMapper();

    @Override
    public void onMessage(Message message, byte[] bytes) {
        try {
            Employee trip = mapper.readValue(message.getBody(), Employee.class);
            LOGGER.info("Message received from EmployeeITSubscriber: {}", trip.toString());

        } catch (IOException e) {
            LOGGER.error("Error reading message", e);
        }
    }
}