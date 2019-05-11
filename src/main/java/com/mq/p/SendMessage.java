package com.mq.p;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class SendMessage {

  @Autowired
  private JmsTemplate jmsTemplate;

  @Value("${ibm.topic.name}")
  private String topicName;
  
  @PostMapping("/send")
  public void send(@RequestBody List<Person> persons) throws JmsException {    
    System.out.println("Sending a transaction.");
    jmsTemplate.convertAndSend(topicName, persons);
  }
}
