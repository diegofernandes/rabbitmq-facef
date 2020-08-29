package br.com.facef.rabbitmqrouting.consumer;

import br.com.facef.rabbitmqrouting.configuration.DirectExchangeConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MessageConsumer {

  @RabbitListener(queues = DirectExchangeConfiguration.PAYMENT_CREDITCARD_QUEUE_NAME)
  public void consumeCreditCardQueue(Message message) {
    log.info("Message processed from CreditCard Queue {}", new String(message.getBody()));
  }

  @RabbitListener(queues = DirectExchangeConfiguration.PAYMENT_BANKSLIP_QUEUE_NAME)
  public void consumeBankSlipQueue(Message message) {
    log.info("Message processed from BankSlip Queue {}", new String(message.getBody()));
  }
}
