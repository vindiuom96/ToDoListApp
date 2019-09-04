package com.example.demo;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableOAuth2Sso
@SpringBootApplication
@EnableSwagger2
@RestController



public class DemoApplication {
	
	@RequestMapping("/user")
	  public Principal user(Principal principal) {
	    return principal;
	  }

	public static void main(String[] args) {
	
		SpringApplication.run(DemoApplication.class, args);
	}

}
