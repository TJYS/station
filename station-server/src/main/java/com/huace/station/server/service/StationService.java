package com.huace.station.server.service;

import com.huace.station.common.domain.Station;

import java.util.List;
import java.util.Optional;

public interface StationService {
    /**
     * 添加一个测站
     * @param record
     * @return
     */
    Station save(Station record);

    /**
     * 修改一个测站
     * @param id
     * @param record
     * @return
     */
    Station modifyById(Integer id, Station record);

    /**
     * 删除一个测站
     * @param id
     */
    void deleteById(Integer id);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    Optional<Station> findById(Integer id);

    /**
     * 查询所有测站
     * @return
     */
    List<Station> findAll();

    /**
     * 根据id启动一个测站
     * @param id
     */
    void startById(Integer id);

    /**
     * 根据id停止一个测站
     * @param id
     */
    void stopById(Integer id);

}
