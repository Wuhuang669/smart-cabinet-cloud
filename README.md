# smart-cabinet-cloud

智能无人货柜系统，从 0 开始搭建的 Spring Cloud 微服务项目。

## 项目目标

本项目用于实现无人货柜的设备通信、扫码开门、重量识别、订单结算、补货校准、账户余额、优惠券营销、支付通道、后台运营和对账报表。

## 当前状态

- 已新建 Spring Cloud 多模块父工程
- 已规划所有微服务模块
- 已生成开发任务清单
- 业务代码处于从 0 开始开发阶段

## 模块说明

| 模块 | 说明 |
| --- | --- |
| common-core | 公共实体、返回结果、异常、常量、枚举 |
| registry-service | 注册中心 |
| config-service | 配置中心 |
| gateway-service | 网关服务 |
| user-service | 用户认证服务 |
| communication-service | 通信服务 |
| device-service | 设备服务 |
| order-service | 订单 / APP 服务 |
| product-service | 商品库存服务 |
| account-service | 账户服务 |
| marketing-service | 营销服务 |
| channel-service | 通道服务 |
| reconcile-service | 对账报表服务 |
| admin-service | 后台管理服务 |

## 开发规则

开发前先查看 `TODO.md`，严格按照任务清单执行。完成一个任务后，必须在 `TODO.md` 中打勾。

