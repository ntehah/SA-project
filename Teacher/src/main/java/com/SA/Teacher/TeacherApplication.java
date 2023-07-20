package com.SA.Teacher;

import com.SA.Teacher.Service.KafkaProducer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class TeacherApplication implements CommandLineRunner {
	@Autowired
	private KafkaProducer kafkaProducer;

	public static void main(String[] args) {
		SpringApplication.run(TeacherApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		kafkaProducer.sendMessage("emails","test message");
	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
}
