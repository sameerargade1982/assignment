package com.argade.sameer.activemq.service;

import java.util.Random;

import javax.jms.JMSException;

import com.argade.sameer.activemq.ActiveMQMessageProducer;

public class ProducerServiceImpl implements ProducerService {
	//private static int index = 0;
	private static String propertyName = "intValue";
	@Override
	public void sendMessage(String queueName, int intValue1, int intValue2) throws JMSException {
		
		ActiveMQMessageProducer activeMQMessageProducer = new ActiveMQMessageProducer("tcp://localhost:61616", "admin","admin");
		
		activeMQMessageProducer.setup(false, false, queueName);
		activeMQMessageProducer.sendMessage(intValue1);
		activeMQMessageProducer.sendMessage(intValue2);
		activeMQMessageProducer.close();
	}
	
//	public static int getIndex() {
//		return index;
//	}

	public static void main(String [] args){
		ProducerService producerService = new ProducerServiceImpl();
		try {
			int mainIndex = 0; //getIndex();
			String queueName = "" + new Integer(mainIndex++).toString();
			Random rand = new Random();
			//int value = rand.nextInt(100);
			for(int i =1; i<=10; i++){
				
				producerService.sendMessage(queueName+ new Integer(mainIndex++).toString(), mainIndex + 1, mainIndex + 2);	
			}
			
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
