package com.station.server.service.impl;

import com.station.common.domain.Station;
import com.station.server.repository.StationRepository;
import com.station.server.service.AgentClient;
import com.station.server.service.StationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class StationServiceImpl implements StationService {
    @Autowired
    StationRepository stationRepository;
    @Autowired
    LoadBalancerClient loadBalancerClient;
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    AgentClient agentClient;

    @Override
    public Station save(Station record) {
        checkStationNameRepeat(0, record.getName());
        return stationRepository.save(record);
    }

    @Override
    public Station modifyById(Integer id, Station record) {
        checkStationNameRepeat(id, record.getName());
        record.setId(id);
        return stationRepository.save(record);
    }

    @Override
    public void deleteById(Integer id) {
        Optional<Station> record = stationRepository.findById(id);
        Station station = record.orElseThrow(() -> new RuntimeException("测站不存在！"));
        if (station.getStatus() != 0) {
            throw new RuntimeException("测站正在运行！请先关闭测站");
        }
        stationRepository.deleteById(id);
    }

    @Override
    public List<Station> findAll() {
        return stationRepository.findAll();
    }

    @Override
    public Optional<Station> findById(Integer id) {
        return stationRepository.findById(id);
    }

    @Override
    public String startById(Integer id) {
//        ServiceInstance instance = loadBalancerClient.choose("station-agent");
//        String url = String.format("%s/station/start", instance.getUri().toString());
        String url = String.format("%s/station/start", "http://localhost:10100");
        return agentClient.agentStart(url, null);
    }

    @Override
    public void stopById(Integer id) {

    }

    private void checkStationNameRepeat(Integer id, String name) {
        boolean exists = stationRepository.existsByIdIsNotAndNameIs(id, name);
        if (exists) {
            throw new RuntimeException("测站名重复");
        }
    }
}
