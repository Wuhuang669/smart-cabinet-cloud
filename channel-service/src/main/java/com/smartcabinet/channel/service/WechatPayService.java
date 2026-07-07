package com.smartcabinet.channel.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 微信支付通道服务，当前先用假代码占位，后续替换为真实微信支付 SDK。
 */
@Slf4j
@Service
public class WechatPayService {

    /**
     * TODO 后续接入真实微信支付下单接口，此处先模拟返回预支付 ID。
     */
    public String createPrepayOrder(String orderCode) {
        log.info("模拟创建微信支付预支付订单，订单号：{}", orderCode);
        return "mock_wechat_prepay_id";
    }
}
