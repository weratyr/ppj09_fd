/*
 * @(#)Message.java      			 20.04.09
 *
 * Copyright (c) 2008-2009 Project Team 4711
 * All rights reserved.
 */

package ppj09.gwt.swapweb.client.datatype;

import java.io.Serializable;

/**
 * Stellt eine Nachricht da, welche zwischen zwei Benutzern ausgetauscht wird.
 * 
 * @author Christian, André
 * @version 0.1, 17.05.09
 */
public class Message implements Serializable {
	
	private int messageId; 		// eindeutige Nachrichten Nummer
	private int articleId;		// falls sich eine Nachricht auf einen bestimmten Artikel bezieht
	private int author;
	private int receiver;
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
	public int getAuthor() {
		return author;
	}
	public void setAuthor(int author) {
		this.author = author;
	}
	public int getReceiver() {
		return receiver;
	}
	public void setReceiver(int receiver) {
		this.receiver = receiver;
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
