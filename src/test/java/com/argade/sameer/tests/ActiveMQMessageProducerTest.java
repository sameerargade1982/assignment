package com.argade.sameer.tests;

import javax.jms.JMSException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.argade.sameer.activemq.ActiveMQMessageProducer;





public class ActiveMQMessageProducerTest {
	
	private ActiveMQMessageProducer msgQueueSender;
	@Before
	public void setup() {
		msgQueueSender = new ActiveMQMessageProducer("tcp://localhost:61616", "admin", "admin");
	}

	@After
	public void cleanup() throws JMSException {
		msgQueueSender.close();
	}
	@Test
	public void send_msg_to_no_transaction_Queue() throws JMSException {
		msgQueueSender.setup(false, false,"group1_q1");
		msgQueueSender.sendMessage("TestGroup1");
	}

	@Test
	public void send_msg_to_Group2_Queue1() throws JMSException {
		msgQueueSender.setup(false, false, "group2_q2");
		msgQueueSender.sendMessage("TestGroup2");
	}

	@Test
	public void send_msg_to_transaction_Group1_Queue2() throws JMSException {
		msgQueueSender.setup(true, false, "group1_q2");
		msgQueueSender.sendMessage("TestGroup1");
		msgQueueSender.commit(true);
	}

	@Test
	public void send_intTo_new_queue() throws JMSException{
		msgQueueSender.setup(true, false, "intQ");
		msgQueueSender.sendMessage(11);
		msgQueueSender.commit(true);
	}
	


}
