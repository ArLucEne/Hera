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

 Date: 05/06/2019 13:19:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for db_address
-- ----------------------------
DROP TABLE IF EXISTS `db_address`;
CREATE TABLE `db_address`  (
  `address_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `address_detail` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `address_city` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `customer_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `customer_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `is_default` int(11) NOT NULL,
  `phone_num` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `address_province` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`address_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of db_address
-- ----------------------------
INSERT INTO `db_address` VALUES ('cc310887fe0f420383ba2bc1e9c74c43', 'wenhuaxilu', 'qingdao', 'test', 'test', 1, '88888888', 'shandong');

-- ----------------------------
-- Table structure for db_admin
-- ----------------------------
DROP TABLE IF EXISTS `db_admin`;
CREATE TABLE `db_admin`  (
  `admin_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `admin_email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `admin_last_login_time` datetime(0) NULL DEFAULT NULL,
  `admin_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `admin_password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `admin_role` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`admin_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of db_admin
-- ----------------------------
INSERT INTO `db_admin` VALUES ('f0447b6f2af646b581263c1a09487b0b', 'awegjoaw@qq.com', '2019-06-05 05:14:24', 'testAdmin', '098F6BCD4621D373CADE4E832627B4F6', 1);

-- ----------------------------
-- Table structure for db_customer
-- ----------------------------
DROP TABLE IF EXISTS `db_customer`;
CREATE TABLE `db_customer`  (
  `customer_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `customer_email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `last_login_time` datetime(0) NULL DEFAULT NULL,
  `customer_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `customer_password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `customer_phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `customer_sex` int(11) NULL DEFAULT NULL,
  `state` int(11) NOT NULL,
  PRIMARY KEY (`customer_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of db_customer
-- ----------------------------
INSERT INTO `db_customer` VALUES ('cce520f7e4904655bd0e09f71c244f73', '2019-06-05 05:14:24', 'test@qq.com ', '2019-06-05 05:14:24', 'testCustomer', '098F6BCD4621D373CADE4E832627B4F6', '922935205', 1, 1);

-- ----------------------------
-- Table structure for db_item
-- ----------------------------
DROP TABLE IF EXISTS `db_item`;
CREATE TABLE `db_item`  (
  `item_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `item_category_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `delete_status` int(11) NOT NULL,
  `item_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `item_image_addr` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `limited_num` int(11) NULL DEFAULT NULL,
  `item_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `item_num` int(11) NULL DEFAULT NULL,
  `item_point` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `item_price` decimal(19, 2) NULL DEFAULT NULL,
  `item_sale_num` int(11) NULL DEFAULT NULL,
  `item_sort_order` int(11) NULL DEFAULT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`item_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of db_item
-- ----------------------------
INSERT INTO `db_item` VALUES ('34be81a7bb1a4a9ab6a33f94d892e39f', 'test', 0, NULL, 'testUrl', 4, 'testCategory', 5000, 'testPoint', 3.20, 234, 0, 0);
INSERT INTO `db_item` VALUES ('44ab78bcb63d4bb1b81e72afc2519d17', 'test', 0, NULL, 'testUrl', 4, 'testCategory', 5000, 'testPoint', 3.20, 234, 0, 0);
INSERT INTO `db_item` VALUES ('f0c4e6a7bd364243b98d6c7c2b05b1b2', 'test', 0, NULL, 'testUrl', 4, 'testCategory', 5000, 'testPoint', 3.20, 234, 0, 0);

-- ----------------------------
-- Table structure for db_item_cart
-- ----------------------------
DROP TABLE IF EXISTS `db_item_cart`;
CREATE TABLE `db_item_cart`  (
  `cart_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `customer_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `item_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `item_num` int(11) NOT NULL,
  `item_price` decimal(19, 2) NULL DEFAULT NULL,
  `modify_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`cart_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of db_item_cart
-- ----------------------------
INSERT INTO `db_item_cart` VALUES ('6d8f0d1771724d9f8b5734ff8f7300cc', '2019-06-05 05:14:24', 'test', 'test', 2, 346.44, '2019-06-05 05:14:24');

-- ----------------------------
-- Table structure for db_item_category
-- ----------------------------
DROP TABLE IF EXISTS `db_item_category`;
CREATE TABLE `db_item_category`  (
  `category_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `category_image_addr` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `is_parent` int(11) NOT NULL,
  `category_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `parent_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`category_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of db_item_category
-- ----------------------------
INSERT INTO `db_item_category` VALUES ('cde220934dfa4f0f9e8e939190bf48e2', '2019-06-05 05:14:24', 'testURl', 1, 'testCategory', NULL, '2019-06-05 05:14:24');

-- ----------------------------
-- Table structure for db_item_order
-- ----------------------------
DROP TABLE IF EXISTS `db_item_order`;
CREATE TABLE `db_item_order`  (
  `item_order_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `item_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `item_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `item_num` int(11) NOT NULL,
  `item_point` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `item_price` decimal(19, 2) NULL DEFAULT NULL,
  `order_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `total_price` decimal(19, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`item_order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of db_item_order
-- ----------------------------
INSERT INTO `db_item_order` VALUES ('6dfbee09b6914573b2c054a8b58d9111', 'test', 'testItem', 3, 'good item', 34.30, 'test', 43.24);

-- ----------------------------
-- Table structure for db_order
-- ----------------------------
DROP TABLE IF EXISTS `db_order`;
CREATE TABLE `db_order`  (
  `order_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `address_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `buyer_message` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `complete_time` datetime(0) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `customer_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `order_pay` decimal(19, 2) NULL DEFAULT NULL,
  `pay_time` datetime(0) NULL DEFAULT NULL,
  `order_pay_type` int(11) NULL DEFAULT NULL,
  `order_postage` decimal(19, 2) NULL DEFAULT NULL,
  `shipping_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `shipping_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `status` int(11) NOT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of db_order
-- ----------------------------
INSERT INTO `db_order` VALUES ('2f38046535ab42d3aaa5f714dba1da47', 'test', 'message', NULL, '2019-06-05 05:14:24', 'test', 43.30, NULL, 1, 23.20, 'test', NULL, 0, NULL);

-- ----------------------------
-- Table structure for db_order_shipping
-- ----------------------------
DROP TABLE IF EXISTS `db_order_shipping`;
CREATE TABLE `db_order_shipping`  (
  `shipping_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `order_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `receiver_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `receiver_city` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `receiver_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `receiver_phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `receiver_province` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`shipping_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of db_order_shipping
-- ----------------------------
INSERT INTO `db_order_shipping` VALUES ('077fc874013b41b891d49614782f15f5', '2019-06-05 05:14:24', NULL, 'test', 'eagjoa', 'xiaodd', '3333333', 'shandong', NULL);

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
INSERT INTO `hibernate_sequence` VALUES (36);
INSERT INTO `hibernate_sequence` VALUES (36);
INSERT INTO `hibernate_sequence` VALUES (36);
INSERT INTO `hibernate_sequence` VALUES (36);

SET FOREIGN_KEY_CHECKS = 1;
