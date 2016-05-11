package controller;

import java.util.HashMap;
import java.util.Map;

import topic.Topic;

/*
 *  Holds the topics boards and its messages
 */
public class MsgService {

	private Map<String, Topic> topicBoard;

	public MsgService() {
		this.topicBoard = new HashMap<String, Topic>();
	}

	public Map<String, Topic> getTopicBoard() {
		return this.topicBoard;
	}

	public void addTopic(String nameTopic, Topic topic) {
		this.topicBoard.put(nameTopic, topic);
	}

	public Topic getTopic(String topicName) {
		return this.topicBoard.get(topicName);
	}

	public boolean isTopicExist(String name) {
		return this.topicBoard.containsKey(name);
	}

	public String printAllBoard() {
		String key;
		Topic topic = new Topic();
		StringBuilder msg = new StringBuilder();
		for (Map.Entry<String, Topic> entry : getTopicBoard().entrySet()) {
			key = entry.getKey();
			topic = entry.getValue();

			msg.append("the key:-" + key);
			msg.append("\n");
			msg.append(topic.getAllMessages());
			msg.append("\n");
		}
		return msg.toString();
	}

	public void printBoard() {
		String key;
		Topic topic = new Topic();
		for (Map.Entry<String, Topic> entry : getTopicBoard().entrySet()) {
			key = entry.getKey();
			topic = entry.getValue();

			System.out.println("the key:-" + key);
			topic.printAllMsg();
		}

	}

	public static void main(String[] args) {

		MsgService queueMsg = new MsgService();

		for (int i = 0; i < 5; i++) {
			String numTopic = "topic " + i;
			Topic topic = new Topic(numTopic, "hello " + i);
			topic.addMsg("new + " + i);
			queueMsg.getTopicBoard().put(numTopic, topic);
		}
		queueMsg.printBoard();
	}
}
