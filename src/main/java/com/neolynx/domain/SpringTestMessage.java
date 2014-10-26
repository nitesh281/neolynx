package com.neolynx.domain;

public class SpringTestMessage {

	private String message;

	public void setMessage(String message) {
		this.message = message;
	}

	public String sayHello() {
		return "Hello Then... Spring-3 is in the house. Say " + message;
	}

}
