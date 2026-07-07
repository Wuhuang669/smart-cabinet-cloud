# 货柜项目待完成任务清单

> 本项目为全新 Spring Cloud 微服务项目，从 0 开始开发。后续所有开发必须以本文档为准，每完成一个任务就在对应位置打勾。

## 1. 项目进度

| 日期 | 模块 | 内容 | 状态 |
| --- | --- | --- | --- |
| 2026-07-07 | 项目初始化 | 新建 Spring Cloud 多模块项目结构 | 已完成 |
| 2026-07-07 | 任务规划 | 生成每个服务的开发任务清单 | 已完成 |
| 2026-07-07 | common-core | 完成统一返回、分页、基础实体、异常处理、枚举规范、工具类、接口文档配置和链路字段 | 已完成 |

## 2. 技术栈

- Java 17
- Spring Boot 3
- Spring Cloud
- Spring Cloud Gateway
- Spring Cloud OpenFeign
- Eureka / Nacos：服务注册发现，先预留，后续按实际环境确定
- Spring Cloud Config / Nacos Config：配置中心，先预留
- MyBatis-Plus
- MySQL 8
- Redis
- RocketMQ
- MQTT Broker
- Netty / Socket
- Spring Security
- JWT
- Knife4j / Swagger
- XXL-JOB / Spring Scheduler
- Lombok

## 3. 开发硬性规则

- [ ] 所有开发必须基于当前新项目 `smart-cabinet-cloud`，不沿用旧项目代码。
- [ ] 每完成一个任务，必须在本文档中打勾。
- [ ] 写 Java 代码时必须添加必要中文注释。
- [ ] 复杂业务方法必须说明业务目的、关键状态和异常处理。
- [ ] 状态值必须定义枚举，不允许到处写 `0`、`1`、`2` 这类魔法值。
- [ ] 每个服务只处理自己的业务，不允许随意跨服务直接查库。
- [ ] 服务之间同步调用优先使用 OpenFeign。
- [ ] 异步业务优先使用 RocketMQ。
- [ ] 需要接入中间件或三方平台时，先写代码骨架，加中文 `TODO`，用假代码模拟。
- [ ] 所有涉及余额、库存、优惠券扣减的逻辑必须考虑事务、幂等和并发。
- [ ] 每次完成用户布置的开发任务后，必须提交 Git 并推送到远程仓库。
- [ ] 每次提交必须写详细提交说明，明确本次具体完成了哪些模块、哪些文件、哪些业务任务和验证结果。

## 4. TODO 假代码规范

```java
// TODO 后续接入真实 RocketMQ，此处先用假代码模拟发送设备开门指令
public void sendOpenDoorCommand(String deviceUid, String gateUid) {
    log.info("模拟发送开门指令，设备UID：{}，仓门UID：{}", deviceUid, gateUid);
}
```

```java
// TODO 后续接入微信支付，此处先模拟返回预支付参数，保证订单主流程可联调
public PayResponse createWechatPayOrder(PayRequest request) {
    PayResponse response = new PayResponse();
    response.setMock(true);
    response.setPrepayId("mock_prepay_id");
    response.setMessage("微信支付模拟返回，待接入真实微信支付");
    return response;
}
```

```java
// TODO 后续接入真实 MQTT Broker，此处先模拟设备在线状态
public boolean checkDeviceOnline(String deviceUid) {
    return true;
}
```

## 5. 基础工程任务

- [x] 新建父工程 `smart-cabinet-cloud`
- [x] 新建多模块目录规划
- [x] 创建 `common-core` 公共模块
- [x] 创建统一返回对象 `Result`
- [x] 创建统一分页对象 `PageResult`
- [x] 创建基础实体 `BaseEntity`
- [x] 创建全局异常处理
- [x] 创建业务异常类
- [x] 创建状态枚举规范
- [x] 创建工具类包
- [x] 创建接口文档配置
- [x] 创建日志链路追踪字段
- [ ] 编写本地启动说明

## 6. 注册中心 registry-service

- [x] 创建注册中心模块
- [x] 添加注册中心启动类
- [x] 添加注册中心配置
- [x] 配置端口 `8761`
- [ ] 验证各服务可注册

## 7. 配置中心 config-service

- [x] 创建配置中心模块
- [x] 添加配置中心启动类
- [x] 添加配置中心配置
- [x] 配置端口 `8888`
- [ ] 统一管理 MySQL 配置
- [ ] 统一管理 Redis 配置
- [ ] 统一管理 RocketMQ 配置
- [ ] 统一管理日志配置

## 8. 网关服务 gateway-service

- [x] 创建网关模块
- [x] 添加网关启动类
- [x] 配置端口 `8080`
- [x] 配置用户服务路由
- [x] 配置设备服务路由
- [x] 配置订单服务路由
- [ ] 配置后台服务路由
- [ ] 实现 JWT 鉴权过滤器
- [ ] 实现后台权限校验 TODO
- [ ] 实现接口限流 TODO
- [ ] 实现请求日志记录

## 9. 用户认证服务 user-service

- [x] 创建用户认证模块
- [ ] 设计小程序用户表 `customer_info`
- [ ] 设计后台用户表 `admin_user`
- [ ] 设计角色表 `admin_role`
- [ ] 设计权限表 `admin_permission`
- [ ] 实现小程序登录接口，微信 / 支付宝未接入前写 TODO 假代码
- [ ] 实现后台登录接口
- [ ] 实现 JWT 生成
- [ ] 实现 JWT 校验
- [ ] 实现用户信息查询
- [ ] 实现后台用户管理
- [ ] 实现角色权限管理

## 10. 通信服务 communication-service

- [x] 创建通信服务模块
- [ ] 定义设备上报消息 DTO
- [ ] 定义设备下发指令 DTO
- [x] 编写 MQTT 接入 TODO 假代码
- [ ] 编写 Socket 接入 TODO 假代码
- [ ] 解析设备心跳消息
- [ ] 解析设备重量消息
- [ ] 解析开门结果消息
- [ ] 解析关门结果消息
- [ ] 解析设备异常消息
- [ ] 通过 RocketMQ 转发设备上报消息，未接入前写 TODO 假代码
- [ ] 监听设备服务下发指令，未接入前写 TODO 假代码
- [ ] 封装开门指令
- [ ] 封装查询重量指令
- [ ] 封装灯箱控制指令
- [ ] 使用 Redis 缓存设备连接状态，未接入前写 TODO 假代码

## 11. 设备服务 device-service

- [x] 创建设备服务模块
- [ ] 整理设备相关建表 SQL
- [ ] 实现 `device_info`
- [ ] 实现 `device_gate_info`
- [ ] 实现 `device_gate_lanes_goods`
- [ ] 实现 `device_heart_record`
- [ ] 实现 `device_weight_record`
- [ ] 实现 `replenish_order`
- [ ] 实现 `replenish_order_detail`
- [ ] 实现 `calibrate_order`
- [ ] 实现设备新增、修改、删除、查询
- [ ] 实现仓门新增、修改、删除、查询
- [ ] 实现货道新增、修改、删除、查询
- [ ] 处理设备心跳
- [ ] 更新设备在线 / 离线 / 异常状态
- [ ] 处理重量上报
- [ ] 缓存开门前重量
- [x] 调用通信服务发送开门指令，未接入前写 TODO 假代码
- [ ] 处理关门后重量
- [ ] 计算重量差
- [ ] 根据商品单重计算商品数量
- [ ] 更新货道库存
- [ ] 返回订单商品计算结果
- [ ] 实现补货流程
- [ ] 实现校准流程

## 12. 订单 / APP 服务 order-service

- [x] 创建订单服务模块
- [ ] 整理订单相关建表 SQL
- [ ] 实现 `shop_order`
- [ ] 实现 `shop_order_product_detail`
- [ ] 实现 `shop_channel_order`
- [ ] 实现扫码识别设备接口
- [ ] 实现扫码开门接口
- [ ] 创建设备开门前订单
- [x] 调用设备服务开门
- [ ] 接收设备服务商品计算结果
- [ ] 生成订单商品明细
- [ ] 计算订单金额
- [ ] 调用营销服务计算优惠
- [ ] 调用账户服务余额支付
- [ ] 调用通道服务微信 / 支付宝支付，未接入前写 TODO 假代码
- [ ] 实现订单列表
- [ ] 实现订单详情
- [ ] 实现订单取消
- [ ] 实现订单超时关闭

## 13. 商品库存服务 product-service

- [x] 创建商品库存服务模块
- [ ] 整理商品分类表 `shop_product_type`
- [ ] 整理商品表 `shop_product_info`
- [ ] 实现商品分类管理
- [ ] 实现商品管理
- [ ] 实现商品上下架
- [ ] 实现小程序商品查询
- [ ] 实现货道绑定商品
- [ ] 实现库存扣减
- [ ] 实现库存回滚
- [ ] 新增库存流水表
- [ ] 记录订单扣减库存流水
- [ ] 记录补货增加库存流水
- [ ] 记录校准修正库存流水

## 14. 账户服务 account-service

- [x] 创建账户服务模块
- [ ] 整理 `account_info`
- [ ] 整理 `account_detail`
- [ ] 整理 `active_recharge_order`
- [ ] 实现账户初始化
- [ ] 实现余额查询
- [ ] 实现余额支付扣款
- [ ] 实现余额退款
- [ ] 实现充值下单
- [ ] 调用通道服务创建支付单，未接入前写 TODO 假代码
- [ ] 处理充值支付成功
- [ ] 记录充值流水
- [ ] 记录消费流水
- [ ] 记录退款流水
- [x] 使用 Redis 分布式锁保护余额扣减，未接入前写 TODO 假代码

## 15. 营销服务 marketing-service

- [x] 创建营销服务模块
- [ ] 整理 `coupon_config`
- [ ] 整理 `coupon_customer`
- [ ] 整理 `coupon_issuing_record`
- [ ] 整理 `coupon_use_detail`
- [ ] 整理 `active_info`
- [ ] 整理 `active_recharge_info`
- [ ] 实现优惠券配置
- [ ] 实现优惠券发放
- [ ] 实现用户领券
- [ ] 实现可用优惠券查询
- [ ] 实现订单优惠计算
- [ ] 实现优惠券核销
- [ ] 实现优惠券退回
- [ ] 实现优惠券过期任务
- [ ] 实现活动配置
- [ ] 实现充值活动配置

## 16. 通道服务 channel-service

- [x] 创建通道服务模块
- [ ] 定义统一支付请求 DTO
- [ ] 定义统一支付响应 DTO
- [x] 实现微信支付下单，先写 TODO 假代码
- [ ] 实现微信支付回调，先写 TODO 假代码
- [ ] 实现微信退款，先写 TODO 假代码
- [ ] 实现支付宝支付下单，先写 TODO 假代码
- [ ] 实现支付宝支付回调，先写 TODO 假代码
- [ ] 实现支付宝退款，先写 TODO 假代码
- [ ] 实现短信发送，先写 TODO 假代码
- [ ] 实现高德地图解析，先写 TODO 假代码
- [ ] 实现腾讯地图解析，先写 TODO 假代码
- [ ] 记录第三方请求日志

## 17. 对账报表服务 reconcile-service

- [x] 创建对账报表服务模块
- [ ] 设计对账记录表
- [ ] 设计对账明细表
- [ ] 设计支付账单表
- [ ] 设计设备销售报表表
- [ ] 设计商品销售报表表
- [ ] 设计库存对账表
- [ ] 实现微信账单下载，先写 TODO 假代码
- [ ] 实现支付宝账单下载，先写 TODO 假代码
- [ ] 实现订单支付对账
- [ ] 实现账户流水对账
- [ ] 实现库存变化对账
- [ ] 实现设备销售日报
- [ ] 实现商品销售日报
- [ ] 实现后台报表查询

## 18. 后台管理服务 admin-service

- [x] 创建后台管理服务模块
- [ ] 实现后台设备列表
- [ ] 实现后台设备详情
- [ ] 实现后台远程开门
- [ ] 实现后台仓门管理
- [ ] 实现后台货道管理
- [ ] 实现后台商品管理
- [ ] 实现后台订单查询
- [ ] 实现后台订单详情
- [ ] 实现后台退款，未接入前写 TODO 假代码
- [ ] 实现后台补货单管理
- [ ] 实现后台校准单管理
- [ ] 实现后台优惠券管理
- [ ] 实现后台活动管理
- [ ] 实现后台账户流水查询
- [ ] 实现后台用户管理
- [ ] 实现后台报表查询
- [ ] 实现后台操作日志
