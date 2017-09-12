package org.amqp.util;

import java.util.concurrent.CountDownLatch;

import org.springframework.stereotype.Component;

@Component
public class Receiver {

	private CountDownLatch latch = new CountDownLatch(1);
	
	public CountDownLatch getLatch() {
		return latch;
	}

	private String message = null;
	
	public String getMessage() {
		return message;
	}

	public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
        this.message = message;
        latch.countDown();
    }
}
