package com.station.agent.controller;

import com.station.agent.station.Receiver;
import com.station.agent.station.ReceiverManager;
import com.station.agent.stream.DataStreamCreatorHolder;
import com.station.agent.stream.enums.NetType;
import com.station.agent.stream.propertys.NtripStreamProperty;
import com.station.agent.stream.propertys.StreamProperty;
import com.station.common.domain.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/station", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class StationController {
    @Autowired
    DataStreamCreatorHolder streamCreatorHolder;

    @PostMapping("/start")
    public String start(@RequestBody Station station) throws Exception {
        Receiver receiver = ReceiverManager.create(station);
        streamCreatorHolder.findDataStreamCreator(NetType.NtripClient).create(receiver).open();
        return "start";
    }
}
