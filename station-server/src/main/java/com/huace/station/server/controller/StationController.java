package com.huace.station.server.controller;

import com.huace.station.common.domain.Station;
import com.huace.station.server.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

//todo: 所有放回数据统一结构化

@RestController
@RequestMapping(value = "/station", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class StationController {
    @Autowired
    StationService stationService;

    @PostMapping("/add")
    public Station add(@RequestBody Station record){
        return stationService.save(record);
    }

    @PostMapping("/modify/{id:\\d+}")
    public Station modify(@PathVariable Integer id, @RequestBody Station record){
        return stationService.modifyById(id, record);
    }

    @GetMapping("/start/{id:\\d+}")
    public void start(@PathVariable Integer id){
        stationService.startById(id);
    }

    @GetMapping("/start/{id:\\d+}")
    public void stop(@PathVariable Integer id){
        stationService.stopById(id);
    }
}
