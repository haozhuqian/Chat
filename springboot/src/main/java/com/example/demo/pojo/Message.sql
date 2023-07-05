-- auto Generated on 2023-07-03
-- DROP TABLE IF EXISTS chat_message;
CREATE TABLE message_db(
	id INT (15) NOT NULL AUTO_INCREMENT COMMENT '本消息的id',
	sendId INT (15) NOT NULL DEFAULT -1 COMMENT '发送人id',
	receiveId INT (15) NOT NULL DEFAULT -1 COMMENT '接受人id',
	message VARCHAR (50) NOT NULL DEFAULT '' COMMENT '消息内容',
	time VARCHAR (50) NOT NULL DEFAULT '' COMMENT '发送时间',
	PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'chat_message';