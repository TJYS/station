package com.station.server.repository;

import com.station.common.domain.Station;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StationRepository extends JpaRepository<Station, Integer> {
     boolean existsByIdIsNotAndNameIs(Integer id, String name);
}
