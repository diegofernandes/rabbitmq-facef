package br.com.facef.rabbitmqdlq;

import br.com.facef.rabbitmqdlq.producer.MessageProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@Slf4j
public class RabbitmqDlqApplication {

  @Autowired private MessageProducer messageProducer;

  public static void main(String[] args) {
    SpringApplication.run(RabbitmqDlqApplication.class, args);
  }

  @EventListener(ApplicationReadyEvent.class)
  public void runningAfterStartup() {
    log.info("Running method after startup to send messages!");
    messageProducer.sendFakeMessage();
  }
}
