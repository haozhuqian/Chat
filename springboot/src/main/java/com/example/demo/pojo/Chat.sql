-- auto Generated on 2023-06-27
-- DROP TABLE IF EXISTS friend_list;
CREATE TABLE Chat_db(
    sendId INT NOT NULL COMMENT '用户id',
    receiveId INT NOT NULL COMMENT '对话者id',
	word VARCHAR (50) NOT NULL DEFAULT '' COMMENT '最后一句',
	time VARCHAR (50) NOT NULL DEFAULT '' COMMENT '最后时刻',
	PRIMARY KEY (sendId,receiveId)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT '会话表';
