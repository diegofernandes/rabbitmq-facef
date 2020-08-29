package br.com.facef.rabbitmqrouting.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Message {

  private String orderId;
  private String paymentType;
}
