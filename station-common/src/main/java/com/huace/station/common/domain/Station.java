package com.huace.station.common.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "t_station")
@Entity
public class Station {
    @Id
    @Column(name = "`station_id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "`station_name`")
    private String name;

    @Column(name = "`station_status`")
    private Short status;
}
