package com.example.cronberry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import com.alcodes.cronberry.impl.SaveAudienceDataImpl;

@EnableScheduling
@ComponentScan(basePackages = "com.example.cronberry")
@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class TallyApplication {

	public static void main(String[] args) {
		SpringApplication.run(TallyApplication.class, args);
	}
	
	@Bean
	public SaveAudienceDataImpl saveAudienceData() {
		return new SaveAudienceDataImpl();
		
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
