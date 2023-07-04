-- auto Generated on 2023-07-03
-- DROP TABLE IF EXISTS chat_message;
CREATE TABLE chat_message(
	id BIGINT (15) NOT NULL AUTO_INCREMENT COMMENT '本消息的id',
	send_id BIGINT (15) NOT NULL DEFAULT -1 COMMENT '发送人id',
	receive_id BIGINT (15) NOT NULL DEFAULT -1 COMMENT '接受人id',
	content VARCHAR (50) NOT NULL DEFAULT '' COMMENT '消息内容',
	send_time VARCHAR (50) NOT NULL DEFAULT '' COMMENT '发送时间',
	PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'chat_message';