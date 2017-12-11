package com.argade.sameer.webservice;


import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import com.argade.sameer.activemq.service.ProducerService;
import com.argade.sameer.activemq.service.ProducerServiceImpl;

public class RESTFullImpl implements RESTFull {
	private  String queueName = "intValueName";
	ProducerService producerService = new ProducerServiceImpl();
	static int in = 0;
	public Response push(int i1, int i2) throws Exception {
		try {
			
			queueName += in++;
			producerService.sendMessage(queueName, i1, i2);
			return Response.status(Response.Status.OK).build();
		} catch (Exception ex) {
			ex.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Response list() throws Exception {
		List list = new ArrayList();

		try {
		//	for (int i=0; i<JmsMessageSender.getIndex(); i++) {
	//			String name = queueName+new Integer(i).toString();
			//	list.add(JmsMessageReceiver.getMessage(name));
			//}
		} catch (Exception ex) {
			ex.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}

		return Response.ok(new Gson().toJson(list)).build();
	}
}


