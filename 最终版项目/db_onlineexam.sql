/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50619
 Source Host           : localhost:3306
 Source Schema         : db_onlineexam

 Target Server Type    : MySQL
 Target Server Version : 50619
 File Encoding         : 65001

 Date: 10/06/2019 21:04:42
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_answer
-- ----------------------------
DROP TABLE IF EXISTS `t_answer`;
CREATE TABLE `t_answer`  (
  `aid` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `uid` int(11) NOT NULL COMMENT '用户编号',
  `pdid` int(11) NOT NULL COMMENT '试卷详细编号',
  `value` int(255) NOT NULL COMMENT '分值',
  `checked` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '选择的答案',
  PRIMARY KEY (`aid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_notice
-- ----------------------------
DROP TABLE IF EXISTS `t_notice`;
CREATE TABLE `t_notice`  (
  `nid` int(11) NOT NULL AUTO_INCREMENT COMMENT '公告编号',
  `uid` int(11) NOT NULL COMMENT '用户编号',
  `title` varchar(2550) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标题',
  `content` varchar(2550) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '内容',
  `time` varchar(2550) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '发布时间',
  PRIMARY KEY (`nid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_notice
-- ----------------------------
INSERT INTO `t_notice` VALUES (1, 3, '超级大消息', '我呵呵呵没啥事', 'Sun Jun 09 23:12:52 CST 2019');
INSERT INTO `t_notice` VALUES (2, 3, '特大消息', '明天期中考试！', 'Tue May 28 21:23:25 CST 2019');
INSERT INTO `t_notice` VALUES (3, 3, '特大消息', '明天周练！', 'Tue May 28 21:23:55 CST 2019');
INSERT INTO `t_notice` VALUES (4, 3, '特大消息', '明天月考！', 'Tue May 28 21:24:22 CST 2019');
INSERT INTO `t_notice` VALUES (7, 3, '特大消息', '请梁莉莉同学联系一下孔一言老师', 'Sun Jun 09 23:12:52 CST 2019');

-- ----------------------------
-- Table structure for t_paper
-- ----------------------------
DROP TABLE IF EXISTS `t_paper`;
CREATE TABLE `t_paper`  (
  `pid` int(11) NOT NULL AUTO_INCREMENT COMMENT '试卷编号',
  `pname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '试卷名称',
  `duration` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '时长',
  PRIMARY KEY (`pid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_paper
-- ----------------------------
INSERT INTO `t_paper` VALUES (1, '2018郑州外国语月考数学试卷', NULL);
INSERT INTO `t_paper` VALUES (4, '2019年郑州外国语周练语文试题', NULL);

-- ----------------------------
-- Table structure for t_paperdetail
-- ----------------------------
DROP TABLE IF EXISTS `t_paperdetail`;
CREATE TABLE `t_paperdetail`  (
  `pdid` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `pid` int(11) NOT NULL COMMENT '试卷编号',
  `qid` int(255) NOT NULL COMMENT '题目编号',
  PRIMARY KEY (`pdid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_paperdetail
-- ----------------------------
INSERT INTO `t_paperdetail` VALUES (1, 1, 3);
INSERT INTO `t_paperdetail` VALUES (2, 1, 2);
INSERT INTO `t_paperdetail` VALUES (4, 1, 4);
INSERT INTO `t_paperdetail` VALUES (5, 1, 7);
INSERT INTO `t_paperdetail` VALUES (6, 1, 7);
INSERT INTO `t_paperdetail` VALUES (7, 1, 7);

-- ----------------------------
-- Table structure for t_question
-- ----------------------------
DROP TABLE IF EXISTS `t_question`;
CREATE TABLE `t_question`  (
  `qid` int(11) NOT NULL AUTO_INCREMENT COMMENT '问题id',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '题目内容',
  `typeA` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'A选项',
  `typeB` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'B选项',
  `typeC` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'C选项',
  `typeD` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'D选项',
  `types` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '类型',
  `right` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '正确答案',
  `value` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '分值',
  PRIMARY KEY (`qid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_question
-- ----------------------------
INSERT INTO `t_question` VALUES (2, '你猜猜今天星期几', '1', '2', '3', '4', '单选题', 'D', '3');
INSERT INTO `t_question` VALUES (3, '你猜猜今天星期几', '1', '2', '3', '7', '单选题', 'D', '3');
INSERT INTO `t_question` VALUES (4, '你说哈哈哈哈哈哈', '1', '2', '3', '4', '多选题', 'BD', '3');
INSERT INTO `t_question` VALUES (5, '你猜猜今天星期几', '1', '2', '3', '7', '单选题', 'D', '3');

-- ----------------------------
-- Table structure for t_score
-- ----------------------------
DROP TABLE IF EXISTS `t_score`;
CREATE TABLE `t_score`  (
  `sid` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `uid` bigint(20) NOT NULL COMMENT '用户编号',
  `pid` bigint(20) NOT NULL COMMENT '试卷编号',
  `mark` int(255) NOT NULL COMMENT '成绩',
  PRIMARY KEY (`sid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_score
-- ----------------------------
INSERT INTO `t_score` VALUES (1, 1, 2, 97);
INSERT INTO `t_score` VALUES (2, 4, 2, 97);
INSERT INTO `t_score` VALUES (3, 6, 2, 100);
INSERT INTO `t_score` VALUES (4, 1, 1, 88);
INSERT INTO `t_score` VALUES (5, 3, 2, 54);
INSERT INTO `t_score` VALUES (6, 5, 2, 89);
INSERT INTO `t_score` VALUES (7, 5, 2, 89);

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `uid` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '密码',
  `birthday` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '生日',
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '性别',
  `addr` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '地址',
  `power` int(255) DEFAULT NULL COMMENT '权限',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '手机号码',
  `hpic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '头像',
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'sadasd', 'sdfsdf', 'aaaaaa', 'nv', '长春', 1, '12312312312', 'qweqwrqr');
INSERT INTO `t_user` VALUES (3, '二位', '二位', '而', '玩儿', '玩儿', 0, '123', '都十分');
INSERT INTO `t_user` VALUES (4, 'qwewq', 'qweqw', 'qwe', 'qwe', 'qwe', 0, 'qwe', 'qwe');
INSERT INTO `t_user` VALUES (5, 'sdfsd', 'qwdsg', 'vcbfghg', 'hgj', 'ghk', 0, 'fdg', 'fdh');
INSERT INTO `t_user` VALUES (6, 'hgjhgj', 'gfh', 'vcbvc', 'fdg', 'gfhfg', 0, 'jhk', 'omhgm');
INSERT INTO `t_user` VALUES (7, 'admin', '123', '123', '123', '123', 1, '123', '123');
INSERT INTO `t_user` VALUES (8, 'aha', '123123', NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for t_wrong
-- ----------------------------
DROP TABLE IF EXISTS `t_wrong`;
CREATE TABLE `t_wrong`  (
  `wid` int(11) NOT NULL AUTO_INCREMENT COMMENT '错误题目的id',
  `uid` int(11) DEFAULT NULL COMMENT '用户id',
  `pid` int(11) DEFAULT NULL COMMENT '试卷id',
  `pdid` int(11) DEFAULT NULL COMMENT '题目id',
  `answer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '学生答案',
  `right` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '正确答案',
  PRIMARY KEY (`wid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_wrong
-- ----------------------------
INSERT INTO `t_wrong` VALUES (1, 1, 2, 1, 'A', 'B');
INSERT INTO `t_wrong` VALUES (2, 1, 2, 2, 'A', 'C');
INSERT INTO `t_wrong` VALUES (3, 2, 2, 2, 'B', 'C');
INSERT INTO `t_wrong` VALUES (4, 1, 2, 3, 'A', 'B');

SET FOREIGN_KEY_CHECKS = 1;
