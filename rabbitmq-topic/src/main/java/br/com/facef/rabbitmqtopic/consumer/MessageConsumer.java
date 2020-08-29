package br.com.facef.rabbitmqtopic.consumer;

import br.com.facef.rabbitmqtopic.configuration.TopicExchangeConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MessageConsumer {

  @RabbitListener(queues = TopicExchangeConfiguration.SMALL_CITIES_QUEUE_NAME)
  public void consumeSmallCitiesQueue(Message message) {
    log.info("Message processed from small-cities-queue {}", new String(message.getBody()));
  }

  @RabbitListener(queues = TopicExchangeConfiguration.MEDIUM_BIG_CITIES_QUEUE_NAME)
  public void consumeMediumBigCitiesQueue(Message message) {
    log.info("Message processed from medium-big-cities-queue {}", new String(message.getBody()));
  }

  @RabbitListener(queues = TopicExchangeConfiguration.ALL_CITIES_QUEUE_NAME)
  public void consumeAllCitiesQueue(Message message) {
    log.info("Message processed from all-cities-queue {}", new String(message.getBody()));
  }
}
