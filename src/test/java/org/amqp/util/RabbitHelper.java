package org.amqp.util;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class RabbitHelper {

	private static final String QUEUE_NAME = "responseQueue";
	
	@Autowired
	private final RabbitTemplate rabbitTemplate = null;

	@Bean
	Queue queue() {
		return new Queue(QUEUE_NAME, false);
	}

	@Bean
	TopicExchange exchange() {
		return new TopicExchange("test-exchange");
	}

	@Bean
	Binding binding(Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(QUEUE_NAME);
	}


	@Bean
	SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
			MessageListenerAdapter listenerAdapter) {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.setQueueNames(QUEUE_NAME);
		container.setMessageListener(listenerAdapter);
		return container;
	}

	@Bean
	MessageListenerAdapter listenerAdapter(Receiver receiver) {
		return new MessageListenerAdapter(receiver, "receiveMessage");
	}


	public void initListener() {

	}

	public void publish(final String queue, final String message) {

		rabbitTemplate.convertAndSend(queue, message);
	}
}
