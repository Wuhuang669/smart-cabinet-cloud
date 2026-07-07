/*
 智能无人货柜系统数据库脚本

 维护规则：
 1. 后续所有创建数据库、创建表、索引、初始化字典数据的 SQL 必须统一写在本文件中。
 2. 每个微服务使用独立数据库，禁止跨服务直接查询其他服务数据库。
 3. 每张业务表必须包含 uid 业务唯一标识，并为 uid 添加唯一索引。
 4. 每张业务表默认包含 create_by、create_date、update_by、update_date、del_flag、remarks 等基础字段。
 5. 状态字段必须在 Java 代码中定义枚举，SQL 注释中同步说明状态含义。
 6. 修改本文件后，必须同步更新 TODO.md 的进度，并提交 Git 后推送远程仓库。
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- 1. 创建数据库
-- ----------------------------

CREATE DATABASE IF NOT EXISTS `smart_cabinet_user`
    DEFAULT CHARACTER SET utf8mb4
    COLLATE utf8mb4_0900_ai_ci
    COMMENT '用户认证服务数据库';

CREATE DATABASE IF NOT EXISTS `smart_cabinet_communication`
    DEFAULT CHARACTER SET utf8mb4
    COLLATE utf8mb4_0900_ai_ci
    COMMENT '通信服务数据库';

CREATE DATABASE IF NOT EXISTS `smart_cabinet_device`
    DEFAULT CHARACTER SET utf8mb4
    COLLATE utf8mb4_0900_ai_ci
    COMMENT '设备服务数据库';

CREATE DATABASE IF NOT EXISTS `smart_cabinet_order`
    DEFAULT CHARACTER SET utf8mb4
    COLLATE utf8mb4_0900_ai_ci
    COMMENT '订单 APP 服务数据库';

CREATE DATABASE IF NOT EXISTS `smart_cabinet_product`
    DEFAULT CHARACTER SET utf8mb4
    COLLATE utf8mb4_0900_ai_ci
    COMMENT '商品库存服务数据库';

CREATE DATABASE IF NOT EXISTS `smart_cabinet_account`
    DEFAULT CHARACTER SET utf8mb4
    COLLATE utf8mb4_0900_ai_ci
    COMMENT '账户服务数据库';

CREATE DATABASE IF NOT EXISTS `smart_cabinet_marketing`
    DEFAULT CHARACTER SET utf8mb4
    COLLATE utf8mb4_0900_ai_ci
    COMMENT '营销服务数据库';

CREATE DATABASE IF NOT EXISTS `smart_cabinet_channel`
    DEFAULT CHARACTER SET utf8mb4
    COLLATE utf8mb4_0900_ai_ci
    COMMENT '通道服务数据库';

CREATE DATABASE IF NOT EXISTS `smart_cabinet_reconcile`
    DEFAULT CHARACTER SET utf8mb4
    COLLATE utf8mb4_0900_ai_ci
    COMMENT '对账报表服务数据库';

CREATE DATABASE IF NOT EXISTS `smart_cabinet_admin`
    DEFAULT CHARACTER SET utf8mb4
    COLLATE utf8mb4_0900_ai_ci
    COMMENT '后台管理服务数据库';

-- ----------------------------
-- 2. 用户认证服务 user-service
-- ----------------------------
-- TODO 后续在此维护 customer_info、admin_user、admin_role、admin_permission 等建表语句。

-- ----------------------------
-- 3. 通信服务 communication-service
-- ----------------------------
-- TODO 后续在此维护设备连接日志、设备原始消息日志等建表语句。

-- ----------------------------
-- 4. 设备服务 device-service
-- ----------------------------
-- TODO 后续在此维护 device_info、device_gate_info、device_gate_lanes_goods、
-- device_heart_record、device_weight_record、replenish_order、
-- replenish_order_detail、calibrate_order 等建表语句。

-- ----------------------------
-- 5. 订单 APP 服务 order-service
-- ----------------------------
-- TODO 后续在此维护 shop_order、shop_order_product_detail、shop_channel_order 等建表语句。

-- ----------------------------
-- 6. 商品库存服务 product-service
-- ----------------------------
-- TODO 后续在此维护 shop_product_type、shop_product_info、inventory_flow 等建表语句。

-- ----------------------------
-- 7. 账户服务 account-service
-- ----------------------------
-- TODO 后续在此维护 account_info、account_detail、active_recharge_order 等建表语句。

-- ----------------------------
-- 8. 营销服务 marketing-service
-- ----------------------------
-- TODO 后续在此维护 coupon_config、coupon_customer、coupon_issuing_record、
-- coupon_use_detail、active_info、active_recharge_info 等建表语句。

-- ----------------------------
-- 9. 通道服务 channel-service
-- ----------------------------
-- TODO 后续在此维护第三方请求日志、支付回调日志、短信发送记录等建表语句。

-- ----------------------------
-- 10. 对账报表服务 reconcile-service
-- ----------------------------
-- TODO 后续在此维护 reconcile_record、reconcile_detail、payment_bill_record、
-- device_sale_report、product_sale_report、inventory_check_record 等建表语句。

-- ----------------------------
-- 11. 后台管理服务 admin-service
-- ----------------------------
-- TODO 后续在此维护后台操作日志、菜单权限等运营后台相关建表语句。

SET FOREIGN_KEY_CHECKS = 1;
