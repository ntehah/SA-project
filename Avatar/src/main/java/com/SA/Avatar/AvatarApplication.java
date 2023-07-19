package com.SA.Avatar;

import com.SA.Avatar.Entity.Element;
import com.SA.Avatar.Entity.ElementType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AvatarApplication {

	public static void main(String[] args) {
		SpringApplication.run(AvatarApplication.class, args);
	}

}
