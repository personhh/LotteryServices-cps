# LotteryServices-cps
基于DDD架构与微服务框架的大营销抽奖系统平台（项目时间：2.26-4.17）

### 一.**项目描述**

基于**DDD 架构开发**的一套满足微服务应用的抽奖系统，作为大营销系统平台必不可少的模块之一，它满足**C端人群**实际

进行抽奖环节的大部分需求，例如对新用户的**吸引、促活、返券、发奖**等内容。该系统通过分解业务个体、聚合多个领域服务功

能完整实现了**抽奖服务领域**的开发，包含了定义规则引擎、制定不同抽奖策略和活动玩法、发放不同奖品等内容，同时采用自研

路由组件进行**分库分表、XXL-JOB开源组件进行分布式任务调度**。促使业务产品更快更容易迭代，减少研发成本，易维护，安全

系数更高



##### **系统架构**

DDD领域驱动设计开发、微服务拆分的分布式系统架构



### 二.**工程分布情况**

-分布式核心功能服务系统 [Lottery](https://gitcode.net/KnowledgePlanet/Lottery) 提供抽奖业务领域功能，以分布式部署的方式提供 RPC 服务。   Github：https://github.com/personhh/LotteryServices-cps.git

-C端用户系统 [lottery-front](https://gitcode.net/KnowledgePlanet/lottery-front) 开发中，vue 前端页面  

-B端运营系统 [Lottery-ERP](https://gitcode.net/KnowledgePlanet/Lottery-ERP) 满足运营人员对于活动的查询、配置、修改、审核等操作。 

-分库分表路由组件 [db-router-spring-boot-starter](https://gitcode.net/KnowledgePlanet/db-router-spring-boot-starter) **本项目依赖自研分库分表组件，**开发一个基于 HashMap 核心设计原理，使用哈希散列+扰动函数的方式，把数据散列到多个库表中的组件，并验证使用。  

 -测试验证系统 [Lottery-Test](https://gitcode.net/KnowledgePlanet/Lottery-Test) 用于测试验证RPC服务、系统功能调用的测试系统。



### 三.**DDD+RPC架构**介绍

DDD对工程进行分层处理，RPC接口作为接口定义

应用层（application）：逻辑包装、编排、任务、领域事件的发布和订阅

通用层（common）：定义通用返回对象、常量、枚举、异常

领域层（domain）：实现业务领域，聚合、充血

基础层（infrastructure）：提供基础的功能（数据库、Redis）

接口层 (interfaces）：实现RPC接口定义，引入应用层服务，封装具体的接口



RPC接口定义（lottery-rpc）：描述RPC接口文件，用于打包后外部引入POM配置



### 四.工程流程图

<img src="/Applications/mac_doc/Java笔记/Lottery项目/流程图+工程图/Lottery_cps工程总图.png" alt="Lottery_cps工程总图" style="zoom:50%;" />



### 五.代码管理

main：本分支，工程介绍

2024-3-6-cps-RpcCreate：系统架构基础搭建

2024-3-6-cps-franchTest：分支测试版本

2024-3-11-cps-Strategy：活动策略模块初步搭建

2024-3-12-cps-award：奖品领域开发

2024-3-14-cps-IdGenerator：策略模式生成ID

2024-3-14-cps-activity：活动领域开发

2024-3-19-cps-dbRouter：路由开发

2024-3-25-cps-rule：去中心化规则引擎开发

2024-3-27-cps-mq_kafka：kafka异步处理消息

2024-3-28-cps-AsynicDistributionAward：使用MQ解藕抽奖发货流程

2024-3-31-cps-xxl-job：处理活动状态扫描

2024-4-1-cps-MQCompenstateJob：MQ消息补偿任务处理

2024-4-6-cps-redis：redis引入滑动锁优化秒杀性能
