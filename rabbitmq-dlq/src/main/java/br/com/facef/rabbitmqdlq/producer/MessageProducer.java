package br.com.facef.rabbitmqdlq.producer;

import static br.com.facef.rabbitmqdlq.configuration.DirectExchangeConfiguration.DIRECT_EXCHANGE_NAME;
import static br.com.facef.rabbitmqdlq.configuration.DirectExchangeConfiguration.ORDER_MESSAGES_QUEUE_NAME;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MessageProducer {

  @Autowired private RabbitTemplate rabbitTemplate;

  public void sendFakeMessage() {
    log.info("Sending a fake message...");
    this.rabbitTemplate.convertAndSend(
        DIRECT_EXCHANGE_NAME,
        ORDER_MESSAGES_QUEUE_NAME,
        "FAKE-MESSAGE-"
            .concat(LocalDateTime.now().toString())
            .concat(UUID.randomUUID().toString()));
  }
}
