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


/*奖品配置，award：用于配置具体可以得到的奖品*/
DROP TABLE IF EXISTS `award`;
CREATE TABLE `award`  (
                          `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
                          `award_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '奖品ID',
                          `award_type` tinyint(0) NULL DEFAULT NULL COMMENT '奖品类型（1:文字描述、2:兑换码、3:优惠券、4:实物奖品）',
                          `award_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '奖品名称',
                          `award_count` int(10) DEFAULT NULL COMMENT '奖品数量',
                          `award_content` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '奖品内容「文字描述、Key、码」',
                          `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
                          `update_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '更新时间',
                          PRIMARY KEY (`id`) USING BTREE,
                          UNIQUE INDEX `idx_award_id`(`award_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '奖品配置' ROW_FORMAT = Dynamic;

INSERT INTO `award` VALUES (26, '101', 1, '电脑', 10,'请联系活动组织者 cps', '2023-04-18 23:01:54', '2023-04-18 23:01:54');
INSERT INTO `award` VALUES (27, '102', 1, '手机', 20,'请联系活动组织者 cps', '2023-04-18 23:01:54', '2023-04-18 23:01:54');
INSERT INTO `award` VALUES (28, '103', 1, '平板', 15,'请联系活动组织者 cps', '2023-04-18 23:01:54', '2023-04-18 23:01:54');
INSERT INTO `award` VALUES (29, '104', 1, '耳机', 20,'请联系活动组织者 cps', '2023-04-18 23:01:54', '2023-04-18 23:01:54');
INSERT INTO `award` VALUES (30, '105', 1, '数据线', 50,'请联系活动组织者 cps', '2023-04-18 23:01:54', '2023-04-18 23:01:54');

/*策略配置，strategy：用于配置抽奖策略，概率、玩法、库存、奖品*/
DROP TABLE IF EXISTS `strategy`;
CREATE TABLE `strategy`  (
                             `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
                             `strategy_id` bigint(0) NOT NULL COMMENT '策略ID',
                             `strategy_desc` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '策略描述',
                             `strategy_mode` tinyint(0) NULL DEFAULT NULL COMMENT '策略方式（1:单项概率、2:总体概率）',
                             `grant_type` tinyint(0) NULL DEFAULT NULL COMMENT '发放奖品方式（1:即时、2:定时[含活动结束]、3:人工）',
                             `grant_date` datetime(0) NULL DEFAULT NULL COMMENT '发放奖品时间',
                             `ext_info` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '扩展信息',
                             `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
                             `update_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
                             PRIMARY KEY (`id`) USING BTREE,
                             UNIQUE INDEX `strategy_strategyId_uindex`(`strategy_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '策略配置' ROW_FORMAT = Dynamic;

INSERT INTO `strategy` VALUES (5, 10002, '抽奖策略', 2, 1, '2023-04-18 23:01:53', '', '2023-04-19 21:39:43', '2023-04-19 21:39:43');


/*策略明细，strategy_detail：抽奖策略的具体明细配置*/
DROP TABLE IF EXISTS `strategy_detail`;
CREATE TABLE `strategy_detail`  (
                                    `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
                                    `strategy_id` bigint(0) NOT NULL COMMENT '策略ID',
                                    `award_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '奖品ID',
                                    `award_name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '奖品描述',
                                    `award_count` int(0) NULL DEFAULT NULL COMMENT '奖品库存',
                                    `award_surplus_count` int(0) NULL DEFAULT 0 COMMENT '奖品剩余库存',
                                    `award_rate` decimal(5, 2) NULL DEFAULT NULL COMMENT '中奖概率',
                                    `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
                                    `update_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '修改时间',
                                    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '策略明细' ROW_FORMAT = Dynamic;

INSERT INTO `strategy_detail` VALUES (21, 10002, '101', '一等奖', 10, 10, 0.05, '2023-04-18 23:01:54', '2023-04-18 23:01:54');
INSERT INTO `strategy_detail` VALUES (22, 10002, '102', '二等奖', 20, 19, 0.15, '2023-04-18 23:01:54', '2023-04-18 23:01:54');
INSERT INTO `strategy_detail` VALUES (23, 10002, '103', '三等奖', 50, 46, 0.20, '2023-04-18 23:01:54', '2023-04-18 23:01:54');
INSERT INTO `strategy_detail` VALUES (24, 10002, '104', '四等奖', 100, 99, 0.25, '2023-04-18 23:01:54', '2023-04-18 23:01:54');
INSERT INTO `strategy_detail` VALUES (25, 10002, '105', '五等奖', 500, 495, 0.35, '2023-04-18 23:01:54', '2023-04-18 23:01:54');

SET FOREIGN_KEY_CHECKS = 1;


