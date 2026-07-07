package com.smartcabinet.account.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * 余额业务服务，后续需要保证扣款幂等和并发安全。
 */
@Slf4j
@Service
public class BalanceService {

    /**
     * TODO 后续接入 Redis 分布式锁和数据库事务，此处先模拟余额扣款成功。
     */
    public boolean deductBalance(String customerUid, BigDecimal amount, String orderCode) {
        log.info("模拟余额扣款，用户UID：{}，金额：{}，订单号：{}", customerUid, amount, orderCode);
        return true;
    }
}
