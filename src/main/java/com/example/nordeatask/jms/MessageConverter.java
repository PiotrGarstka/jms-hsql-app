package com.example.nordeatask.jms;

import com.example.nordeatask.model.Person;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;

public class MessageConverter {

    public Message toMessage(Object object, Session session) throws JMSException, MessageConversionException {
        Person person = (Person) object;
        MapMessage message = session.createMapMessage();
        message.setString("first_name", person.getFirstName());
        message.setInt("id", person.getId());
        return message;
    }

    public Object fromMessage(Message message) throws JMSException, MessageConversionException {
        MapMessage mapMessage = (MapMessage) message;
        return new Person(mapMessage.getString("first_name"), mapMessage.getInt("id"));
    }
}
