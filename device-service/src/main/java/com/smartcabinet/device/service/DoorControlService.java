package com.smartcabinet.device.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 仓门控制业务服务，负责开门前重量缓存和开门指令下发。
 */
@Slf4j
@Service
public class DoorControlService {

    /**
     * TODO 后续接入 Redis 缓存开门前重量，并通过 RocketMQ 通知通信服务发送真实开门指令。
     */
    public void openDoor(String deviceUid, String gateUid) {
        log.info("模拟缓存开门前重量，设备UID：{}，仓门UID：{}", deviceUid, gateUid);
        log.info("模拟发送开门消息到通信服务，设备UID：{}，仓门UID：{}", deviceUid, gateUid);
    }
}
