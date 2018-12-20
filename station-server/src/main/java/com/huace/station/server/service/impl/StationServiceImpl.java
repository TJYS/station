package com.huace.station.server.service.impl;

import com.huace.station.common.domain.Station;
import com.huace.station.server.repository.StationRepository;
import com.huace.station.server.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationServiceImpl implements StationService {
    @Autowired
    StationRepository stationRepository;

    @Override
    public Station save(Station record) {
        return stationRepository.save(record);
    }

    @Override
    public List<Station> findAll() {
        return stationRepository.findAll();
    }
}
