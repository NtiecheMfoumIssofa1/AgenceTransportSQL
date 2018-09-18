package org.avr;

import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan("org.avr") //to scan packages mentioned
//@EnableAutoConfiguration //to activate MongoDB repositories
public class AgenceVoyageRoutierApplication { 
  
	public static void main(String[] args) {  
		SpringApplication.run(AgenceVoyageRoutierApplication.class, args); 
	}
}
