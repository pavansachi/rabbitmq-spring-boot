package org;

import org.amqp.RabbitHelper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * Main boot application
 * @author pavansachi
 *
 */

@SpringBootApplication
@ComponentScan(basePackages={"org.amqp"})
public class Application {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(Application.class, args);	
	
		RabbitHelper conn = context.getBean(RabbitHelper.class);
		
		System.out.println(conn);
		
	}

}