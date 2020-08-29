package br.com.facef.rabbitmqrouting.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectExchangeConfiguration {

  public static final String DIRECT_EXCHANGE_NAME = "order-exchange";
  public static final String PAYMENT_CREDITCARD_QUEUE_NAME = "payment-creditcard-queue";
  public static final String PAYMENT_BANKSLIP_QUEUE_NAME = "payment-bankslip-queue";

  @Bean
  Queue paymentCreditCardQueue() {
    return new Queue(PAYMENT_CREDITCARD_QUEUE_NAME);
  }

  @Bean
  Queue paymentBankSlipQueue() {
    return new Queue(PAYMENT_BANKSLIP_QUEUE_NAME);
  }

  @Bean
  DirectExchange exchange() {
    return ExchangeBuilder.directExchange(DIRECT_EXCHANGE_NAME).durable(true).build();
  }

  @Bean
  Binding bindingPaymentCreditCardQueue(
      @Qualifier("paymentCreditCardQueue") Queue queue, DirectExchange exchange) {
    return BindingBuilder.bind(queue).to(exchange).with("creditcard");
  }

  @Bean
  Binding bindingPaymentBankSlipQueue(
      @Qualifier("paymentBankSlipQueue") Queue queue, DirectExchange exchange) {
    return BindingBuilder.bind(queue).to(exchange).with("bankslip");
  }
}
