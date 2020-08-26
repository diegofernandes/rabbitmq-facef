package com.facef.hellemitter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

	Logger logger = LoggerFactory.getLogger(Runner.class);

	private RabbitTemplate rabbitTemplate;

	public Runner(RabbitTemplate rabbitTemplate) {
		super();
		this.rabbitTemplate = rabbitTemplate;
	}

	@Override
	public void run(String... args) throws Exception {

		for (int i = 0; i < 20; i++) {
			StringBuilder builder = new StringBuilder("Oie");
		
			builder.append("e".repeat(i));
			builder.append("-").append(i);

			rabbitTemplate.convertAndSend("fofoqueiro","foca" + i, builder.toString());

			logger.info("Mensagem '"+builder.toString()+"' enviada " + i);

			Thread.sleep(1000);
		}

	}

}
