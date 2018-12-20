package com.huace.station.server.controller;

import com.huace.station.common.domain.Station;
import com.huace.station.server.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/station", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class StationController {
    @Autowired
    StationService stationService;

    @GetMapping("/findAll")
    public List<Station> findAll(){
        return stationService.findAll();
    }
}
