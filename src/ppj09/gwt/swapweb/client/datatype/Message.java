/*
 * @(#)Message.java      			 20.04.09
 *
 * Copyright (c) 2008-2009 Project Team 4711
 * All rights reserved.
 */

package ppj09.gwt.swapweb.client.datatype;

import java.io.Serializable;

/**
 * Der Datentyp welcher zwischen Client und Server ausgetauscht wird, und ueber
 * den DataBanker in die DB abgelegt wird.
 * 
 * @author Christian Happ
 * @author Projekt Team 4711
 * @version 0.1, 04.05.09
 */
public class Message implements Serializable {
	
	//eindeutige Nachrichten Nummer
	private int messageId;
	//Nachricht
	private int articleId;
	private int reciever;
	private int author;
	private String topic;
	private String message;
	private boolean isRead;
	
	
	public int getMessageId() {
		return messageId;
	}
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	public int getReciever() {
		return reciever;
	}
	public void setReciever(int reciever) {
		this.reciever = reciever;
	}
	public int getAuthor() {
		return author;
	}
	public void setAuthor(int author) {
		this.author = author;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isRead() {
		return isRead;
	}
	public void setRead(boolean isRead) {
		this.isRead = isRead;
	}
}
