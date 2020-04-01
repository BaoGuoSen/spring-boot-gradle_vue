/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : vue

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2019-11-18 09:28:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `sex` varchar(255) NOT NULL,
  `grade` int(11) NOT NULL,
  `school` varchar(255) DEFAULT NULL,
  `major` varchar(255) DEFAULT NULL,
  `hobby` varchar(255) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `ImgUrl` varchar(255) DEFAULT NULL,
  `FileUrl` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('111', '包国森', '男', '1334', '管理学院', '修改后的专业', '修改后的爱好', '2019-11-18', 'blob:http://localhost:8081/8ad6633c-cc02-4792-ab76-75c1f0478cfc', 'blob:http://localhost:8081/682ff520-20c6-4dff-8b4a-e524eee13562');
INSERT INTO `student` VALUES ('112', 'xxb', '女', '3344', '管理学院', '数学', '篮球', '2019-11-18', null, null);
INSERT INTO `student` VALUES ('113', 'bgs', '男', '2444', '管理学院', 'ddd', '篮球', '2019-11-25', null, null);
INSERT INTO `student` VALUES ('114', '静静', '女', '2017', '管理学院', '顶顶顶顶', '篮球', '2019-11-25', null, null);
INSERT INTO `student` VALUES ('115', 'TT', '女', '3343', '管理学院', 'dfddf', '篮球', '2019-11-24', null, null);
INSERT INTO `student` VALUES ('116', 'J林涵', '男', '3334', '管理学院', '大幅度', '足球', '2019-11-18', null, null);
