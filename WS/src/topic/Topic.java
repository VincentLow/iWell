package topic;

import java.util.ArrayList;

/*
 * Topic hold topic/queue name and its messages.
 */
public class Topic {
	private String topicName;
	private ArrayList<String> msgList;

	public Topic() {
		this.msgList = new ArrayList<String>();
	}

	public Topic(String name) {
		this.topicName = name;
		this.msgList = new ArrayList<String>();
	}

	public Topic(String name, String msg) {
		this.topicName = name;
		this.msgList = new ArrayList<String>();
		this.msgList.add(msg);
	}

	public String getTopicName() {
		return this.topicName;
	}

	public void addMsg(String msg) {

		this.msgList.add(msg);
	}

	public ArrayList<String> getAllMessagers() {
		return msgList;
	}

	public void getAllMsg() {
		for (int i = 0; i < msgList.size(); i++) {
			System.out.println(msgList.get(i));
		}
	}

	public String getAllMessages() {
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < msgList.size(); i++) {
			str.append(msgList.get(i));
			str.append("\n");
		}
		return str.toString();
	}

	public void printAllMsg() {

		System.out.println(getTopicName() + " --- ");
		getAllMsg();
	}
}
