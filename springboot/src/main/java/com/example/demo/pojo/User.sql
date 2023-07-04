-- auto Generated on 2023-06-27
-- DROP TABLE IF EXISTS user_info;

CREATE TABLE user_db(
	id INT NOT NULL AUTO_INCREMENT COMMENT '用户id',
    email VARCHAR (50) NOT NULL DEFAULT '' COMMENT '邮箱',
    password VARCHAR (50) NOT NULL DEFAULT '' COMMENT '密码',
    `name` VARCHAR (50) NOT NULL DEFAULT '' COMMENT '用户名',
	gender VARCHAR (50) NOT NULL DEFAULT '' COMMENT '性别',
	region VARCHAR (50) NOT NULL DEFAULT '' COMMENT '地区',
	avatar VARCHAR (50) NOT NULL DEFAULT '' COMMENT '头像',

	PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT '注册用户表';
