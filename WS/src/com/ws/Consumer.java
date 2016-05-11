package com.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import controller.MsgService;
import topic.Topic;

@Path("/board")
public class Consumer {

	protected MsgService queueMsg;

	public  Consumer() {
		this.queueMsg = new MsgService();
		// generatePost();
		System.out.println("queue");
	}

	

	@GET
	@Path("/{name}")
	@Produces(MediaType.TEXT_PLAIN)
	public String postTopic(@PathParam("name") String name) {
		String resp = "<hello>Bye</hello> " + name;
		return resp;
	}

	protected void generatePost() {

		for (int i = 0; i < 5; i++) {
			String numTopic = "topic " + i;
			Topic topic = new Topic(numTopic, "hello " + i);
			topic.addMsg("new + " + i);
			queueMsg.getTopicBoard().put(numTopic, topic);
		}
	}

}
