package com.station.server.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.station.server.service.AgentClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@DefaultProperties(defaultFallback = "defaultFallback")
public class AgentClientImpl implements AgentClient {
    @Autowired
    RestTemplate restTemplate;

    @Override
    @HystrixCommand(fallbackMethod = "fallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000"),
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),//设置开启熔断
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),
    })
    public String agentStart(String url, Object params) {
        return restTemplate.getForObject(url, String.class);
    }

    @Override
    @HystrixCommand
    public String agentStop(String url, Object params) {
        return restTemplate.getForObject(url, String.class);
    }

    private String fallback(String url, Object params) {
        return "start failed";
    }

    /**
     * 默认故障返回
     *
     * @param url
     * @param params
     * @return
     */
    private String defaultFallback(String url, Object params) {
        return "failed";
    }
}
