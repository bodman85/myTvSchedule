package com.example.myTvSchedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan("com.example.myTvSchedule.model")
@SpringBootApplication
public class MyTvScheduleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyTvScheduleApplication.class, args);
	}

}
