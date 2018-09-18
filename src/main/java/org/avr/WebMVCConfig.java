package org.avr;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@Configuration
public class WebMVCConfig extends WebMvcConfigurerAdapter{
	//c'est ici qu'on relis les url et les vues
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		//association vue et page
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/logout").setViewName("login");//if logout click retour vers login.html
	}
	 
   
}
