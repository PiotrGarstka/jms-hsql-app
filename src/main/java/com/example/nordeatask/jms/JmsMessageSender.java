package com.example.nordeatask.jms;

import com.example.nordeatask.model.Person;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.Queue;
import java.util.HashMap;
import java.util.Map;

public class JmsMessageSender {

    private JmsTemplate jmsTemplate;
    private Queue queue;

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void setQueue(Queue queue) {
        this.queue = queue;
    }

    public void simpleSend() {
        jmsTemplate.send(queue, s -> s.createTextMessage("message"));
    }

    public void sendMessage(final Person person) {
        this.jmsTemplate.convertAndSend(person);
    }

    public void sendTextMessage(String msg) {
        this.jmsTemplate.send(queue, s -> s.createTextMessage(msg));
    }
}
