package com.smartcabinet.reconcile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 对账报表服务，负责支付对账、库存对账和销售报表。
 */
@SpringBootApplication
public class ReconcileServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReconcileServiceApplication.class, args);
    }
}
