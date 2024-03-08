DROP DATABASE IF EXISTS `lottery`;
create database `lottery`  DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin;

use `lottery`;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

/*活动表：是一个用于配置抽奖活动的总表，用于存放活动信息，包括：ID、名称、描述、时间、库存、参与次数等。*/
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity` (
                            `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
                            `activity_id` bigint(20) NOT NULL COMMENT '活动ID',
                            `activity_name` varchar(64) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '活动名称',
                            `activity_desc` varchar(128) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '活动描述',
                            `begin_date_time` datetime DEFAULT NULL COMMENT '开始时间',
                            `end_date_time` datetime DEFAULT NULL COMMENT '结束时间',
                            `stock_count` int(11) DEFAULT NULL COMMENT '库存',
                            `stock_surplus_count` int(0) NULL DEFAULT NULL COMMENT '库存剩余',
                            `take_count` int(11) DEFAULT NULL COMMENT '每人可参与次数',
                            `strategy_id` bigint(0) NULL DEFAULT NULL COMMENT '抽奖策略ID',
                            `state` tinyint(2) DEFAULT NULL COMMENT '活动状态：1编辑、2提审、3撤审、4通过、5运行(审核通过后worker扫描状态)、6拒绝、7关闭、8开启',
                            `creator` varchar(64) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '创建人',
                            `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                            `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
                            PRIMARY KEY (`id`),
                            UNIQUE KEY `unique_activity_id` (`activity_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='活动配置';
INSERT INTO `activity` VALUES (5, 120981321, '测试活动1', '测试活动描述1', '2024-03-07 23:01:53', '2025-06-19 23:01:53', 100, 93, 5, 10002, 5, 'cps', '2023-04-18 23:01:54', '2023-04-18 23:01:54');
INSERT INTO `activity` VALUES (6, 120981322, '测试活动2', '测试活动描述2', '2024-03-07 23:01:53', '2025-06-19 23:01:53', 100, 93, 4, 10002, 5, 'cps', '2023-04-18 23:01:54', '2023-04-18 23:01:54');