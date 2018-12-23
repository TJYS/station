package com.station.server.service;

public interface AgentClient {
    String agentStart(String url, Object params);

    String agentStop(String url, Object params);
}
