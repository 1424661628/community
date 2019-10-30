CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `account_id` varchar(100) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL COMMENT '用户姓名',
  `token` varchar(100) DEFAULT NULL COMMENT '令牌',
  `gmt_create` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` bigint(20) DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8