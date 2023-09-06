package za.co.cesium.functionapp;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.cloud.function.context.MessageRoutingCallback;
import org.springframework.messaging.Message;

@SpringBootApplication
public class LambdaApplication {

	Log logger = LogFactory.getLog(LambdaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LambdaApplication.class, args);
	}

	@Bean
	public MessageRoutingCallback customRouter() {
		return new MessageRoutingCallback() {
			@Override
			public String routingResult(Message<?> message) {
				logger.info("Received message: " + message);
				return (String) message.getHeaders().get("spring.cloud.function.definition");
			}
		};
	}
}
