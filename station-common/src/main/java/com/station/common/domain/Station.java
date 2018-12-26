package com.station.common.domain;

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

    @Column(name = "`station_net_type`")
    private Short netType;

    @Column(name = "`station_ip`")
    private String ip;

    @Column(name = "`station_port`")
    private Integer port;

    @Column(name = "`station_ntrip_user`")
    private String ntripUser;

    @Column(name = "station_ntrip_pwd")
    private String ntripPwd;

    @Column(name = "`station_net_source`")
    private String ntripSource;
}
