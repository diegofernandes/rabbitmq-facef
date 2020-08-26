package com.facef.hellorabbitmq;

import org.springframework.stereotype.Component;

@Component
public class HelloReceiver {
	

	  public void receiveMessage(String message) {
	    System.out.println("Received <" + message + ">");
	    
	  }

	  
}
