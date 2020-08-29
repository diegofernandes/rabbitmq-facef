package br.com.facef.rabbitmqtopic.controller;

import br.com.facef.rabbitmqtopic.dto.City;
import br.com.facef.rabbitmqtopic.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/routing")
public class CityController {

  @Autowired private CityService cityService;

  @PostMapping("/topic")
  public ResponseEntity placeOrder(@RequestBody City city) {
    cityService.sendToTopicExchange(city);
    return ResponseEntity.accepted().build();
  }
}
