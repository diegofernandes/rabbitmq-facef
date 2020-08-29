package br.com.facef.rabbitmqtopic.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class City {

  private String name;
  private Long population;
}
