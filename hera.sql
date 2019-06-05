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

 Date: 04/06/2019 13:58:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for db_address
-- ----------------------------
DROP TABLE IF EXISTS `db_address`;
CREATE TABLE `db_address`  (
  `address_id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `customer_id` int(11) NULL DEFAULT NULL,
  `is_default` int(2) NULL DEFAULT NULL,
  `address_province` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '省份',
  `phone_num` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `address_detail` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `address_city` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`address_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of db_address
-- ----------------------------
INSERT INTO `db_address` VALUES (1, 'test', 100, 1, 'shandong', '88888888', 'wenhuaxilu', 'weihai');

-- ----------------------------
-- Table structure for db_admin
-- ----------------------------
DROP TABLE IF EXISTS `db_admin`;
CREATE TABLE `db_admin`  (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `admin_email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `admin_password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `admin_role` int(255) NULL DEFAULT NULL,
  `admin_last_login_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`admin_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of db_admin
-- ----------------------------
INSERT INTO `db_admin` VALUES (5, 'testAdmin', 'awegjoaw@qq.com', '098F6BCD4621D373CADE4E832627B4F6', 1, '2019-06-04 05:36:36');
INSERT INTO `db_admin` VALUES (10, 'testAdmin', 'awegjoaw@qq.com', '098F6BCD4621D373CADE4E832627B4F6', 1, '2019-06-04 05:51:52');

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
  `create_time` datetime(0) NULL DEFAULT NULL,
  `last_login_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`customer_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of db_customer
-- ----------------------------
INSERT INTO `db_customer` VALUES (6, 'testCustomer', 'test@qq.com ', '098F6BCD4621D373CADE4E832627B4F6', '922935205', 1, NULL, 1, '2019-06-04 05:36:36', '2019-06-04 05:36:36');
INSERT INTO `db_customer` VALUES (11, 'testCustomer', 'test@qq.com ', '098F6BCD4621D373CADE4E832627B4F6', '922935205', 1, NULL, 1, '2019-06-04 05:51:52', '2019-06-04 05:51:52');

-- ----------------------------
-- Table structure for db_item
-- ----------------------------
DROP TABLE IF EXISTS `db_item`;
CREATE TABLE `db_item`  (
  `item_id` int(255) NOT NULL AUTO_INCREMENT,
  `item_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '商品名称',
  `item_category_id` int(11) NULL DEFAULT NULL COMMENT '商品所属种类',
  `item_price` decimal(10, 2) NOT NULL COMMENT '商品价格',
  `item_num` int(255) NULL DEFAULT NULL COMMENT '商品库存',
  `limited_num` int(255) NULL DEFAULT NULL COMMENT '限制购买数',
  `status` int(2) NULL DEFAULT NULL COMMENT '商品状态',
  `item_point` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品买点',
  `item_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品描述',
  `delete_status` int(2) NULL DEFAULT NULL COMMENT '商品是否删除',
  `item_image_addr` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `item_sort_order` int(255) NULL DEFAULT NULL,
  `item_sale_num` int(255) NULL DEFAULT NULL,
  PRIMARY KEY (`item_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '商品实体类' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of db_item
-- ----------------------------
INSERT INTO `db_item` VALUES (7, 'testCategory', 100, 3.00, 5000, 4, 0, 'testPoint', NULL, 0, 'testUrl', 0, 234);
INSERT INTO `db_item` VALUES (12, 'testCategory', 100, 3.20, 5000, 4, 0, 'testPoint', NULL, 0, 'testUrl', 0, 234);

-- ----------------------------
-- Table structure for db_item_cart
-- ----------------------------
DROP TABLE IF EXISTS `db_item_cart`;
CREATE TABLE `db_item_cart`  (
  `cart_id` int(255) NOT NULL AUTO_INCREMENT COMMENT '购物车id',
  `customer_id` int(255) NULL DEFAULT NULL COMMENT '顾客id',
  `item_num` int(255) NULL DEFAULT NULL COMMENT '商品数量',
  `item_id` int(255) NULL DEFAULT NULL COMMENT '商品id',
  `item_price` decimal(10, 2) NOT NULL COMMENT '商品价格',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`cart_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of db_item_cart
-- ----------------------------
INSERT INTO `db_item_cart` VALUES (14, 2, 2, 1, 346.44, '2019-06-04 05:51:53', '2019-06-04 05:51:53');

-- ----------------------------
-- Table structure for db_item_category
-- ----------------------------
DROP TABLE IF EXISTS `db_item_category`;
CREATE TABLE `db_item_category`  (
  `category_id` int(255) NOT NULL AUTO_INCREMENT COMMENT '商品种类id',
  `category_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `is_parent` int(2) NULL DEFAULT NULL COMMENT '是否是父类',
  `parent_id` int(2) NULL DEFAULT NULL COMMENT '父类id',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `category_image_addr` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`category_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of db_item_category
-- ----------------------------
INSERT INTO `db_item_category` VALUES (13, 'testCategory', 1, NULL, '2019-06-04 05:51:52', '2019-06-04 05:51:52', 'testURl');

-- ----------------------------
-- Table structure for db_item_order
-- ----------------------------
DROP TABLE IF EXISTS `db_item_order`;
CREATE TABLE `db_item_order`  (
  `item_order_id` int(255) NOT NULL AUTO_INCREMENT,
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
-- Records of db_item_order
-- ----------------------------
INSERT INTO `db_item_order` VALUES (15, 1, 2, 3, 34.30, 'testItem', 'good item', 43.24);

-- ----------------------------
-- Table structure for db_order
-- ----------------------------
DROP TABLE IF EXISTS `db_order`;
CREATE TABLE `db_order`  (
  `order_id` int(255) NOT NULL AUTO_INCREMENT,
  `customer_id` int(255) NULL DEFAULT NULL COMMENT '订单所属顾客',
  `status` int(2) NULL DEFAULT NULL COMMENT '订单状态 0-正在处理 1-成功 2-订单取消',
  `order_pay_type` int(2) NULL DEFAULT NULL COMMENT '支付方式',
  `address_id` int(255) NULL DEFAULT NULL COMMENT '地址对应id',
  `order_pay` decimal(10, 2) NULL DEFAULT NULL COMMENT '付款金额',
  `order_postage` decimal(10, 2) NULL DEFAULT NULL COMMENT '邮费',
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
-- Records of db_order
-- ----------------------------
INSERT INTO `db_order` VALUES (16, 3, 0, 1, 2, 43.00, 23.00, '2019-06-04 05:51:53', NULL, NULL, NULL, NULL, 'test', 'message');

-- ----------------------------
-- Table structure for db_order_shipping
-- ----------------------------
DROP TABLE IF EXISTS `db_order_shipping`;
CREATE TABLE `db_order_shipping`  (
  `shipping_id` int(11) NOT NULL AUTO_INCREMENT,
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

-- ----------------------------
-- Records of db_order_shipping
-- ----------------------------
INSERT INTO `db_order_shipping` VALUES (17, NULL, 'xiaodd', '3333333', 'shandong', 'eagjoa', 'test', '2019-06-04 05:51:53', NULL);

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence`  (
  `next_val` bigint(20) NULL DEFAULT NULL
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES (18);
INSERT INTO `hibernate_sequence` VALUES (18);
INSERT INTO `hibernate_sequence` VALUES (18);
INSERT INTO `hibernate_sequence` VALUES (18);

SET FOREIGN_KEY_CHECKS = 1;
