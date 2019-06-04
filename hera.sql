/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : localhost:3306
 Source Schema         : hera

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 03/06/2019 16:49:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for db_admin
-- ----------------------------
DROP TABLE IF EXISTS `db_admin`;
CREATE TABLE `db_admin`  (
  `admin_id` int(11) NOT NULL,
  `admin_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `admin_email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `admin_password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `admin_role` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `admin_last_login_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`admin_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for db_adress
-- ----------------------------
DROP TABLE IF EXISTS `db_adress`;
CREATE TABLE `db_adress`  (
  `adress_id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `customer_id` int(11) NULL DEFAULT NULL,
  `is_default` int(2) NULL DEFAULT NULL,
  `address_province` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '省份',
  `adress_city` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '城市',
  `adress_detail` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '详细地址',
  `phone_num` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`adress_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for db_customer
-- ----------------------------
DROP TABLE IF EXISTS `db_customer`;
CREATE TABLE `db_customer`  (
  `customer_id` int(255) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `customer_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `customer_email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `customer_password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `customer_phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `customer_sex` int(2) NULL DEFAULT NULL,
  `create_date` datetime(6) NULL DEFAULT NULL,
  `state` int(255) NULL DEFAULT NULL,
  PRIMARY KEY (`customer_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for db_item
-- ----------------------------
DROP TABLE IF EXISTS `db_item`;
CREATE TABLE `db_item`  (
  `item_id` int(255) NOT NULL AUTO_INCREMENT COMMENT 'item_id',
  `item_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '商品名称',
  `item_category_id` int(11) NULL DEFAULT NULL COMMENT '商品所属种类',
  `item_price` decimal(10, 0) NOT NULL COMMENT '商品价格',
  `item_num` int(255) NULL DEFAULT NULL COMMENT '商品库存',
  `limited_num` int(255) NULL DEFAULT NULL COMMENT '限制购买数',
  `status` int(2) NULL DEFAULT NULL COMMENT '商品状态',
  `item_point` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品买点',
  `item_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品描述',
  `delete_status` int(2) NULL DEFAULT NULL COMMENT '商品是否删除',
  `recommend_status` int(2) NULL DEFAULT NULL COMMENT '推荐状态',
  PRIMARY KEY (`item_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '商品实体类' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for db_item_cart
-- ----------------------------
DROP TABLE IF EXISTS `db_item_cart`;
CREATE TABLE `db_item_cart`  (
  `cart_id` int(255) NOT NULL COMMENT '购物车id',
  `customer_id` int(255) NULL DEFAULT NULL COMMENT '顾客id',
  `item_num` int(255) NULL DEFAULT NULL COMMENT '商品数量',
  `item_id` int(255) NULL DEFAULT NULL COMMENT '商品id',
  `item_price` decimal(10, 2) NOT NULL COMMENT '商品价格',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`cart_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for db_item_category
-- ----------------------------
DROP TABLE IF EXISTS `db_item_category`;
CREATE TABLE `db_item_category`  (
  `category_id` int(255) NOT NULL COMMENT '商品种类id',
  `category_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `category_icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '种类图标uri',
  `is_parent` int(2) NULL DEFAULT NULL COMMENT '是否是父类',
  `parent_id` int(2) NULL DEFAULT NULL COMMENT '父类id',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`category_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for db_item_order
-- ----------------------------
DROP TABLE IF EXISTS `db_item_order`;
CREATE TABLE `db_item_order`  (
  `item_order_id` int(255) NOT NULL,
  `item_id` int(255) NULL DEFAULT NULL,
  `order_id` int(11) NULL DEFAULT NULL,
  `item_num` int(11) NULL DEFAULT NULL,
  `item_price` decimal(10, 2) NULL DEFAULT NULL,
  `item_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `item_point` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `total_price` decimal(10, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`item_order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for db_order
-- ----------------------------
DROP TABLE IF EXISTS `db_order`;
CREATE TABLE `db_order`  (
  `order_id` int(255) NOT NULL,
  `customer_id` int(255) NULL DEFAULT NULL COMMENT '订单所属顾客',
  `status` int(2) NULL DEFAULT NULL COMMENT '订单状态 0-正在处理 1-成功 2-订单取消',
  `order_pay_type` int(2) NULL DEFAULT NULL COMMENT '支付方式',
  `address_id` int(255) NULL DEFAULT NULL COMMENT '地址对应id',
  `order_pay` decimal(10, 0) NULL DEFAULT NULL COMMENT '付款金额',
  `order_postage` decimal(10, 0) NULL DEFAULT NULL COMMENT '邮费',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '订单创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '订单修改时间',
  `pay_time` datetime(0) NULL DEFAULT NULL COMMENT '订单支付时间',
  `complete_time` datetime(0) NULL DEFAULT NULL COMMENT '订单完成时间',
  `shipping_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '物流名称',
  `shipping_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '物流单号',
  `buyer_message` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '买家留言',
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for db_order_shipping
-- ----------------------------
DROP TABLE IF EXISTS `db_order_shipping`;
CREATE TABLE `db_order_shipping`  (
  `shipping_id` int(11) NOT NULL,
  `order_id` int(11) NULL DEFAULT NULL,
  `receiver_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `receiver_phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `receiver_province` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '所在省份',
  `receiver_city` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `receiver_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`shipping_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
