package com.ws;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import topic.Topic;

@Path("/topic")
public class Producer extends Consumer {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String printAll() {
		System.out.println("in print all");

		if (this.queueMsg == null) {
			System.out.println("queus i null");
		} else {
			System.out.println("not null");
		}
		System.out.println(queueMsg.printAllBoard());

		return queueMsg.printAllBoard();
	}

	@POST
	public String addMessage() {
		String topicTitle = "TRY";
		String msg = "let see";
		System.out.println("in post");
		postMessage(topicTitle, msg);
		return "post wokrs";
	}

	@POST
	@Path("/{name}")
	@Produces(MediaType.TEXT_PLAIN)
	public String addMessage(@PathParam("name") String name) {
		String newMsg = "new Msg";
		postMessage(name, newMsg);
		System.out.println("in post " + name);
		return "post works11 " + name;
	}

	private void postMessage(String topicTitle, String msg) {
		Topic topic;
		if (!this.queueMsg.isTopicExist(topicTitle)) {
			topic = new Topic(topicTitle, msg);
			this.queueMsg.addTopic(topicTitle, topic);
		} else {
			this.queueMsg.getTopicBoard().get(topicTitle).addMsg(msg);
		}
	}
}
