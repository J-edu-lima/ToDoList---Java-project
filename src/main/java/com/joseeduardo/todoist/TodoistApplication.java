package com.joseeduardo.todoist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class TodoistApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoistApplication.class, args);
	}

}
