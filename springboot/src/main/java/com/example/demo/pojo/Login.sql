-- auto Generated on 2023-06-27
-- DROP TABLE IF EXISTS user_login;
CREATE TABLE user_db(
    id INT NOT NULL AUTO_INCREMENT COMMENT '用户id',
	email VARCHAR (50) NOT NULL COMMENT '注册邮箱',
	PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT '在线用户表';