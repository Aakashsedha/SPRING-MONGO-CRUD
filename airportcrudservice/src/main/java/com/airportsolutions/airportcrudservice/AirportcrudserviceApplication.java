package com.airportsolutions.airportcrudservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages ="com.airportsolutions.airportcrudservice")

public class AirportcrudserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirportcrudserviceApplication.class, args);
	}

}
