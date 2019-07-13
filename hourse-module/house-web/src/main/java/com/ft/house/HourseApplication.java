package com.ft.house;

import com.ft.hourse1.EnableHttpClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableHttpClient
public class HourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(HourseApplication.class, args);
	}

}
