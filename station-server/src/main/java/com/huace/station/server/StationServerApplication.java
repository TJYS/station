package com.huace.station.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages={"com.huace.station.common"})
public class StationServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(StationServerApplication.class, args);
    }

}

