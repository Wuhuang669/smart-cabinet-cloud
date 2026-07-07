package com.smartcabinet.channel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 通道服务，负责微信、支付宝、短信、地图等第三方平台对接。
 */
@SpringBootApplication
public class ChannelServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChannelServiceApplication.class, args);
    }
}
