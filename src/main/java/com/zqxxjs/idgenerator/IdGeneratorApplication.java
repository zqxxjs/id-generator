package com.zqxxjs.idgenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class IdGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(IdGeneratorApplication.class, args);
	}

}
