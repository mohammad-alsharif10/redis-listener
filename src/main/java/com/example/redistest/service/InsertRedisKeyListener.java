package com.example.redistest.service;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.listener.KeyspaceEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@Component
public class InsertRedisKeyListener extends KeyspaceEventMessageListener {
//    private static final Topic KEY_EVENT_INSERT_TOPIC = new PatternTopic("__keyevent@*__:set");

    public InsertRedisKeyListener(RedisMessageListenerContainer listenerContainer) {
        super(listenerContainer);
    }

    /**
     * Creates new {@link MessageListener} for {@code __keyevent@*__:expired} messages.
     */


    /*
     * (non-Javadoc)
     * @see org.springframework.data.redis.listener.KeyspaceEventMessageListener#doRegister(org.springframework.data.redis.listener.RedisMessageListenerContainer)
     */
//    @Override
//    protected void doRegister(RedisMessageListenerContainer listenerContainer) {
//        listenerContainer.addMessageListener(this, KEY_EVENT_INSERT_TOPIC);
//    }

    /*
     * (non-Javadoc)
     * @see org.springframework.data.redis.listener.KeyspaceEventMessageListener#doHandleMessage(org.springframework.data.redis.connection.Message)
     */
    @Override
    protected void doHandleMessage(Message message) {
//        Object o;
//        try {
//            ByteArrayInputStream in = new ByteArrayInputStream(message.getBody());
//
//            ObjectInputStream is = new ObjectInputStream(in);
//            o = is.readObject();
//        } catch (IOException | ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
        System.out.println(new String(message.getBody(),StandardCharsets.UTF_8));
        System.out.println(new String(message.getChannel(), StandardCharsets.UTF_8));
    }
}
