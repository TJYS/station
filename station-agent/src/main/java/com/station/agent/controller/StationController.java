package com.station.agent.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/station", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class StationController {
    @GetMapping("/start")
    public String start() {
        return "start";
    }
}
