package com.careerdrill.radis.config;

import com.careerdrill.radis.publish.EmployeePublisher;
import com.careerdrill.radis.subscribe.EmployeeHRSubscriber;
import com.careerdrill.radis.subscribe.EmployeeITSubscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@Configuration
@EnableRedisRepositories
public class EmployeeConfiguration {

    @Autowired
    RedisTemplate<?, ?> redisTemplate;

    @Autowired
    RedisConnectionFactory redisConnectionFactory;

    @Bean
    EmployeePublisher redisPublisher() {
        return new EmployeePublisher(redisTemplate, topic());
    }

    @Bean
    ChannelTopic topic() {
        return new ChannelTopic("trips");
    }

    @Bean
    RedisMessageListenerContainer container() {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.addMessageListener(messageListenerHR(), topic());
        container.addMessageListener(messageListenerIT(), topic());
        container.setConnectionFactory(redisConnectionFactory);
        return container;
    }

    @Bean
    MessageListenerAdapter messageListenerHR() {
        return new MessageListenerAdapter(new EmployeeHRSubscriber());
    }

    @Bean
    MessageListenerAdapter messageListenerIT() {
        return new MessageListenerAdapter(new EmployeeITSubscriber());
    }

}