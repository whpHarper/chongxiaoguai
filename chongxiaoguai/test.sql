/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50524
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50524
File Encoding         : 65001

Date: 2017-05-29 19:39:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_cust_user
-- ----------------------------
DROP TABLE IF EXISTS `t_cust_user`;
CREATE TABLE `t_cust_user` (
  `id` int(19) NOT NULL AUTO_INCREMENT,
  `phone` varchar(20) NOT NULL COMMENT '手机号',
  `password` varchar(100) NOT NULL COMMENT '登录密码',
  `name` varchar(50) NOT NULL COMMENT '姓名',
  `last_company_by` bigint(255) DEFAULT '0' COMMENT '上回操作公司',
  `email` varchar(100) NOT NULL COMMENT '邮箱',
  `is_email` varchar(2) DEFAULT 'N' COMMENT '邮箱是否已认证:N-未认证,Y-已认证',
  `head_portrait` varchar(200) DEFAULT NULL,
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `is_delete` varchar(2) NOT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10057 DEFAULT CHARSET=utf8 COMMENT='用户信息表';

-- ----------------------------
-- Records of t_cust_user
-- ----------------------------

-- ----------------------------
-- Table structure for t_login
-- ----------------------------
DROP TABLE IF EXISTS `t_login`;
CREATE TABLE `t_login` (
  `id` bigint(50) NOT NULL,
  `User` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of t_login
-- ----------------------------
INSERT INTO `t_login` VALUES ('1', '王海鹏', '1');

-- ----------------------------
-- Table structure for t_logs_info
-- ----------------------------
DROP TABLE IF EXISTS `t_logs_info`;
CREATE TABLE `t_logs_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `operator` bigint(20) NOT NULL COMMENT '操作人',
  `operator_content` tinytext NOT NULL COMMENT '操作内容',
  `operator_time` datetime NOT NULL COMMENT '操作时间',
  `remark` tinytext COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1211 DEFAULT CHARSET=utf8 COMMENT='日志记录表';

-- ----------------------------
-- Records of t_logs_info
-- ----------------------------

-- ----------------------------
-- Procedure structure for BatchInsert
-- ----------------------------
DROP PROCEDURE IF EXISTS `BatchInsert`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `BatchInsert`(IN init INT, IN loop_time INT)
BEGIN  
    DECLARE Var INT;  
    DECLARE ID INT;  
    SET Var = 0;  
    SET ID = init;  
        WHILE Var < loop_time DO
				INSERT INTO `te_paperrecord`
VALUES
	(
		UUID(),
		'newysx',
		NULL,
		NULL,
		'2016-07-24 15:08:05',
		'0',
		NULL,
		'1)各大学越来越多的大学生开始参加各种志愿活动。\r\n2)在志愿活动中大学生既有付出也有收获。\r\n3)你对大学生参加志愿活动的看法。\r\n',
		UUID(),
		NULL,
		'T',
		'0',
		'未判分',
		NULL,
		NULL,
		UUID(),
		NULL,
		UUID(),
		'1)各大学越来越多的大学生开始参加各种志愿活动。\r\n2)在志愿活动中大学生既有付出也有收获。\r\n3)你对大学生参加志愿活动的看法。\r\n',
		UUID(),
		'15',
		'fdsadsfs这是我做的测试东方视点zheshiceshi',
		'11091332036',
		NULL,
		NULL,
		NULL,
		NULL,
		'Writing (15 points) fxq',
		'张琳琳',
		'0',
		'',
		UUID()
	);
        SET ID = ID + 1;  
        SET Var = Var + 1;  
        END WHILE;  
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for loadData
-- ----------------------------
DROP PROCEDURE IF EXISTS `loadData`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `loadData`()
BEGIN

DECLARE v INT DEFAULT 0;
WHILE v < 5000000 DO
	INSERT INTO `te_paperrecord`
VALUES
	(
		UUID(),
		'newysx',
		NULL,
		NULL,
		'2016-07-24 15:08:05',
		'0',
		NULL,
		'1)各大学越来越多的大学生开始参加各种志愿活动。\r\n2)在志愿活动中大学生既有付出也有收获。\r\n3)你对大学生参加志愿活动的看法。\r\n',
		UUID(),
		NULL,
		'T',
		'0',
		'未判分',
		NULL,
		NULL,
		UUID(),
		NULL,
		UUID(),
		'1)各大学越来越多的大学生开始参加各种志愿活动。\r\n2)在志愿活动中大学生既有付出也有收获。\r\n3)你对大学生参加志愿活动的看法。\r\n',
		UUID(),
		'15',
		'fdsadsfs这是我做的测试东方视点zheshiceshi',
		'11091332036',
		NULL,
		NULL,
		NULL,
		NULL,
		'Writing (15 points) fxq',
		'张琳琳',
		'0',
		'',
		UUID()
	);


SET v = v + 1;


END
WHILE;


END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for load_part_tab
-- ----------------------------
DROP PROCEDURE IF EXISTS `load_part_tab`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `load_part_tab`()
begin  
    declare v int default 0;  
    while v < 8000000  
    do  
       
         set v = v + 1;  
    end while;  
end
;;
DELIMITER ;
