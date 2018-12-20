package com.huace.station.server.service;

import com.huace.station.common.domain.Station;

import java.util.List;

public interface StationService {
    Station save(Station record);
    List<Station> findAll();
}
