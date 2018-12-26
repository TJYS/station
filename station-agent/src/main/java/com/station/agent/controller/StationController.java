package com.station.agent.controller;

import com.station.agent.stream.DataStreamCreatorHolder;
import com.station.agent.stream.enums.NetType;
import com.station.agent.stream.propertys.NtripStreamProperty;
import com.station.agent.stream.propertys.StreamProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/station", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class StationController {
    @Autowired
    DataStreamCreatorHolder streamCreatorHolder;

    @GetMapping("/start")
    public String start() throws Exception {
        NtripStreamProperty property = new NtripStreamProperty();
        property.setOwner("dd");
        property.setIp("47.75.61.24");
        property.setPort(2102);
        property.setUser("chcnav");
        property.setPwd("chchnav");
        property.setSource("WTZR0");
        streamCreatorHolder.findDataStreamCreator(NetType.NtripClient).create(property).open();
        return "start";
    }
}
