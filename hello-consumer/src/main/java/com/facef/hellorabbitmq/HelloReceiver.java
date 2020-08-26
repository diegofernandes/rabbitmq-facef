package com.facef.hellorabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
public class HelloReceiver {
	
	Logger logger = LoggerFactory.getLogger(HelloReceiver.class);

	public void receiveMessage(String message) throws InterruptedException {

		StopWatch watch = new StopWatch();
		watch.start();
		
		logger.info("[x] mensagem '" + message + "' recebida");
		
		doWork(message);
		
		watch.stop();
		
		logger.info("[x] mensagem '" + message + "' processada em " + watch.getTotalTimeSeconds() + "s");
		

	}
	
	
	private void doWork(String message) throws InterruptedException {
        for (char ch : message.toCharArray()) {
            if (ch == 'e') {
                Thread.sleep(1000);
            }
        }
    }

}
