package com.smartcabinet.communication.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 设备指令发送服务，后续负责把业务指令转换成设备协议指令。
 */
@Slf4j
@Service
public class DeviceCommandSender {

    /**
     * TODO 后续接入真实 MQTT / Socket 通道，此处先用假代码模拟发送开门指令。
     */
    public void sendOpenDoorCommand(String deviceUid, String gateUid) {
        log.info("模拟发送开门指令，设备UID：{}，仓门UID：{}", deviceUid, gateUid);
    }
}
