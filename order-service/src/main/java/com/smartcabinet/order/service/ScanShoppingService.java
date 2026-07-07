package com.smartcabinet.order.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 扫码购物业务服务，负责串联扫码、开门、商品计算和支付流程。
 */
@Slf4j
@Service
public class ScanShoppingService {

    /**
     * TODO 后续调用设备服务检查设备状态并发送开门指令，此处先用假代码保证流程可联调。
     */
    public String scanAndOpenDoor(String customerUid, String deviceUid, String gateUid) {
        log.info("模拟用户扫码开门，用户UID：{}，设备UID：{}，仓门UID：{}", customerUid, deviceUid, gateUid);
        return "mock_order_code";
    }
}
