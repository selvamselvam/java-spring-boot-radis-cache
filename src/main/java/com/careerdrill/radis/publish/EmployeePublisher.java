package com.careerdrill.radis.publish;

import com.careerdrill.radis.entity.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

public class EmployeePublisher {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeePublisher.class);

    RedisTemplate<?, ?> redisTemplate;
    ChannelTopic topic;

    public EmployeePublisher(RedisTemplate<?, ?> redisTemplate, ChannelTopic topic) {
        this.redisTemplate = redisTemplate;
        this.redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Employee.class));
        this.topic = topic;
    }

    public void publish(Employee trip) throws JsonProcessingException {
        LOGGER.info("Sending: {}", trip);
        redisTemplate.convertAndSend(topic.getTopic(), trip);
    }
}

