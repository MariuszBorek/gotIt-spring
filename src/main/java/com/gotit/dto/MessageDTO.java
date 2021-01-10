package com.gotit.dto;

public class MessageDTO {

	private String messageBody;

	public MessageDTO(String messageBody) {
		this.messageBody = messageBody;
	}

	public String getMessageBody() {
		return messageBody;
	}

	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}

}
