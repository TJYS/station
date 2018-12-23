package com.station.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 其他项目在引用此模块时记得添加如下配置
 * @<code>
 *     feign:
 *       hystrix:
 *         enabled: true
 * </code>
 * 且主类要配置包扫描,如下
 * {@code
 *  @EnableFeignClients(basePackages = "com.station.client")
 *  @ComponentScans(@ComponentScan("com.station.client"))
 * }
 */
@FeignClient(name = "station-server", fallback = StarionClient.StarionClientFallback.class)
public interface StarionClient {
    @GetMapping("/station/start/{id:\\d+}")
    String start(@PathVariable Integer id);

    @Component
    public static class StarionClientFallback implements StarionClient{
        @Override
        public String start(Integer id) {
            return null;
        }
    }
}
