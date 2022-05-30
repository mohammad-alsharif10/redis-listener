package com.example.redistest.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.KeyspaceEventMessageListener;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.Topic;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


//@Component
public class DeleteRedisKeyListener extends KeyspaceEventMessageListener {

    Logger logger = LoggerFactory.getLogger(DeleteRedisKeyListener.class);
    private static final Topic KEY_EVENT_INSERT_TOPIC = new PatternTopic("__keyevent@*__:del");


    public DeleteRedisKeyListener(RedisMessageListenerContainer listenerContainer) {
        super(listenerContainer);
    }

    @Override
    protected void doRegister(RedisMessageListenerContainer listenerContainer) {
        listenerContainer.addMessageListener(this, KEY_EVENT_INSERT_TOPIC);
    }

    @Override
    protected void doHandleMessage(Message message) {
        Object o;
        try {
            System.out.println(message.getBody());
            String string = new String(message.getBody());
            System.out.println(string);
            ObjectMapper mapper = new ObjectMapper();
            //Converting the Object to JSONString
            String jsonString = null;
            try {
                jsonString = mapper.writeValueAsString(message);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
            System.out.println("from delete");
            System.out.println(jsonString);
            ByteArrayInputStream in = new ByteArrayInputStream(message.getBody());

            ObjectInputStream is = new ObjectInputStream(in);
            o = is.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println(o);
    }
}
