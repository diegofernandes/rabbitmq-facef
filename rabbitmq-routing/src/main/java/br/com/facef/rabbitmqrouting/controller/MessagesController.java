package br.com.facef.rabbitmqrouting.controller;

import br.com.facef.rabbitmqrouting.dto.Message;
import br.com.facef.rabbitmqrouting.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/routing")
public class MessagesController {

  @Autowired private MessageService messageService;

  @PostMapping("/direct")
  public ResponseEntity placeOrder(@RequestBody Message message) {
    messageService.sendToDirectExchange(message);
    return ResponseEntity.accepted().build();
  }
}
