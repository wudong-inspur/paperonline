

CREATE DATABASE  `questionnaire` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

#用户
CREATE TABLE  `user` (
 `id` VARCHAR( 64 ) NOT NULL ,
 `username` VARCHAR( 64 ) NOT NULL ,
 `password` VARCHAR( 64 ) NOT NULL ,
 `email` VARCHAR( 64 ) NOT NULL ,
 `create_time` DATETIME NOT NULL ,
 `last_login_time` DATETIME NULL ,
 `status` INT NOT NULL DEFAULT  '0',
 `random_code` VARCHAR( 64 ) NOT NULL ,
PRIMARY KEY (  `id` ) ,
UNIQUE (
`random_code`
)
) ENGINE = INNODB CHARACTER SET utf8 COLLATE utf8_general_ci;

-- ----------------------------
-- Table structure for pointman
-- ----------------------------
DROP TABLE IF EXISTS `pointman`;
CREATE TABLE `pointman` (
  `id` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '主键ID',
  `addr` varchar(300) COLLATE utf8_bin DEFAULT NULL COMMENT '地址',
  `input_user` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '录入者名称',
  `input_date` datetime DEFAULT NULL COMMENT '录入日期',
  `pointman_no` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '指示者编号',
  `name` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '指示者名称',
  `sex` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '性别',
  `healthy` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '健康状态',
  `in_current_country` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '是否迁出当前村',
  `birthdate` date DEFAULT NULL COMMENT '出生日期',
  `current_addr` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '当前住址',
  `idcard_no` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '身份证号码',
  `mobilephone` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '电话号码',
  `is_other_pointman_rel` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '是否和其他指示者有亲属关系',
  `other_pointman_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '其他指示者名称',
  `other_pointman_rel` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '与其他指示者具体关系',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for kinship
-- ----------------------------
DROP TABLE IF EXISTS `kinship`;
CREATE TABLE `kinship` (
  `id` varchar(64) COLLATE utf8_bin NOT NULL COMMENT 'ID',
  `pointman_no` varchar(4) COLLATE utf8_bin DEFAULT NULL COMMENT '指示者编号',
  `kinship_code` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '关系代码',
  `kinship_inputcode` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '录入关系代码',
  `name` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '名称',
  `sex` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '性别',
  `birthdate` date DEFAULT NULL COMMENT '出生日期',
  `idcard_no` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '身份证号码',
  `remark` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  `inCountry` char(1) COLLATE utf8_bin DEFAULT NULL COMMENT '是否在本村',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;