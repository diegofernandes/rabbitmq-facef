package com.facef.hellemitter;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HellEmitterApplication {
	
	static final String queueName = "hello-queue";
	
	@Bean
	Queue queue() {
		return new Queue(queueName, false);
	}

	

	public static void main(String[] args) {
		SpringApplication.run(HellEmitterApplication.class, args);
	}

}
