package com.smartcabinet.device;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 设备服务，负责设备、仓门、货道、心跳、重量、开关门、补货和校准业务。
 */
@SpringBootApplication
public class DeviceServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeviceServiceApplication.class, args);
    }
}
