package com.mindmatters.CICDdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@SpringBootApplication
@EnableScheduling
public class CicDdemoApplication {

	@Value("${NAME:World}")
	String name;

	@RestController
	class HelloworldController {
		@GetMapping("/")
		String hello() throws InterruptedException {
			System.out.println("hello called.");
			Thread.sleep(1000);
			System.out.println("sleep done.");
			return "Hello " + name + "!";
		}

		@Scheduled(cron = "0 */1 * * * ?")
		public void scheduled(){
			//SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			//Date date = new Date();
			//System.out.println("Method called, time: " + formatter.format(date));
			System.out.println("Method called");
		}
	}
	public static void main(String[] args) {
		SpringApplication.run(CicDdemoApplication.class, args);
	}

}
