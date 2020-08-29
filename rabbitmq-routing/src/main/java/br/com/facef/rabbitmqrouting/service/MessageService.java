package br.com.facef.rabbitmqrouting.service;

import br.com.facef.rabbitmqrouting.configuration.DirectExchangeConfiguration;
import br.com.facef.rabbitmqrouting.dto.Message;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

  @Autowired private RabbitTemplate rabbitTemplate;

  public void sendToDirectExchange(Message message) {
    try {
      final var messageJson = new ObjectMapper().writeValueAsString(message);

      rabbitTemplate.convertAndSend(
          DirectExchangeConfiguration.DIRECT_EXCHANGE_NAME, getRoutingKey(message), messageJson);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }

  private String getRoutingKey(Message message) {
    switch (message.getPaymentType()) {
      case "creditCard":
        return "creditcard";
      case "bankSlip":
        return "bankslip";
      default:
        throw new IllegalArgumentException("Invalid paymentType");
    }
  }
}
