package br.com.facef.rabbitmqtopic.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicExchangeConfiguration {

  public static final String TOPIC_EXCHANGE_NAME = "city-exchange";
  public static final String SMALL_CITIES_QUEUE_NAME = "small-cities-queue";
  public static final String MEDIUM_BIG_CITIES_QUEUE_NAME = "medium-big-cities-queue";
  public static final String ALL_CITIES_QUEUE_NAME = "all-cities-queue";

  @Bean
  Queue smallCitiesQueue() {
    return new Queue(SMALL_CITIES_QUEUE_NAME);
  }

  @Bean
  Queue mediumBigCitiesQueue() {
    return new Queue(MEDIUM_BIG_CITIES_QUEUE_NAME);
  }

  @Bean
  Queue allCitiesQueue() {
    return new Queue(ALL_CITIES_QUEUE_NAME);
  }

  @Bean
  TopicExchange exchange() {
    return ExchangeBuilder.topicExchange(TOPIC_EXCHANGE_NAME).durable(true).build();
  }

  @Bean
  Binding bindingSmallCitiesQueue(
      @Qualifier("smallCitiesQueue") Queue queue, TopicExchange exchange) {
    return BindingBuilder.bind(queue).to(exchange).with("*.small");
  }

  @Bean
  Binding bindingMediumCitiesQueue(
      @Qualifier("mediumBigCitiesQueue") Queue queue, TopicExchange exchange) {
    return BindingBuilder.bind(queue).to(exchange).with("*.medium");
  }

  @Bean
  Binding bindingBigCitiesQueue(
      @Qualifier("mediumBigCitiesQueue") Queue queue, TopicExchange exchange) {
    return BindingBuilder.bind(queue).to(exchange).with("*.big");
  }

  @Bean
  Binding bindingALlCitiesQueue(@Qualifier("allCitiesQueue") Queue queue, TopicExchange exchange) {
    return BindingBuilder.bind(queue).to(exchange).with("city.#");
  }
}
