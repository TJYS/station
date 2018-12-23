package com.station.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "station-server")
public interface StarionClient {
    @GetMapping("/station/start/{id:\\d+}")
    String start(@PathVariable Integer id);
}
