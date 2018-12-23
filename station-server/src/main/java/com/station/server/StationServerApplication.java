package com.station.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EntityScan(basePackages = {"com.station.common"})
@EnableEurekaClient
@EnableCircuitBreaker
public class StationServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(StationServerApplication.class, args);
    }

}

