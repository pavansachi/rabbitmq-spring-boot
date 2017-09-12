package org.amqp;

import java.util.concurrent.TimeUnit;

import org.Application;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={Application.class})
public class AMQPReceiverTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Autowired
	RabbitHelper helper;
	
	@Autowired
	Receiver receiver;
	
	@Test
	public void publishToRabbitMQ () throws InterruptedException {
		
		receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
		
		Assert.assertEquals("Hello Rabbit!", receiver.getMessage(), 
				"No message received timed out");
	}

}
