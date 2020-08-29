package br.com.facef.rabbitmqtopic.service;

import br.com.facef.rabbitmqtopic.configuration.TopicExchangeConfiguration;
import br.com.facef.rabbitmqtopic.dto.City;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {

  @Autowired private RabbitTemplate rabbitTemplate;

  public void sendToTopicExchange(City city) {
    try {
      final var messageJson = new ObjectMapper().writeValueAsString(city);

      rabbitTemplate.convertAndSend(
          TopicExchangeConfiguration.TOPIC_EXCHANGE_NAME, getRoutingKey(city), messageJson);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }

  private String getRoutingKey(City city) {
    if (city.getPopulation() <= 10000) {
      return "city.small";
    } else if (city.getPopulation() > 10000 && city.getPopulation() < 500000) {
      return "city.medium";
    } else {
      return "city.big";
    }
  }
}
