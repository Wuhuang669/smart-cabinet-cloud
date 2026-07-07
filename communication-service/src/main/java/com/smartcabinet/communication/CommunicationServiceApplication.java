package com.smartcabinet.communication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 通信服务，负责 MQTT / Socket 设备通信、设备指令解析和指令下发。
 */
@SpringBootApplication
public class CommunicationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommunicationServiceApplication.class, args);
    }
}
