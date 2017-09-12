package org.amqp;

import org.Application;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={Application.class})
public class AMQPPublisherTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Autowired
	RabbitHelper helper;
	
	@Test
	public void publishToRabbitMQ () throws InterruptedException {
		
		helper.publish("responseQueue", "Hello Rabbit!");
	}

}
