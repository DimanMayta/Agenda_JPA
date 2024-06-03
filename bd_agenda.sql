/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 100425
 Source Host           : 127.0.0.1:3306
 Source Schema         : bd_agenda

 Target Server Type    : MySQL
 Target Server Version : 100425
 File Encoding         : 65001

 Date: 03/06/2024 14:43:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for contactos
-- ----------------------------
DROP TABLE IF EXISTS `contactos`;
CREATE TABLE `contactos`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `correo` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `telefono` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of contactos
-- ----------------------------
INSERT INTO `contactos` VALUES (1, 'Bruno Diaz', 'bruno@mail.com', '77712345');
INSERT INTO `contactos` VALUES (2, 'Rodrigo Mamani Mamani', 'rodri@gmail.com', '77754321');
INSERT INTO `contactos` VALUES (3, 'Elsa Capunta', 'elsa@mail.com', '77722211');
INSERT INTO `contactos` VALUES (5, 'Diman Rodrigo', 'diman@gmail.com', '78767763');
INSERT INTO `contactos` VALUES (6, 'Rodrigo', 'rodrigo@gmail.com', '111111111');

SET FOREIGN_KEY_CHECKS = 1;
