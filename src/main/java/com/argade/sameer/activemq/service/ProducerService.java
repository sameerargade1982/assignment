package com.argade.sameer.activemq.service;

import javax.jms.JMSException;

public interface ProducerService {
	//static int index = 0;
	 void sendMessage(String queueName, int intValue1, int intValue2) throws JMSException ;
}
