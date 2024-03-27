-- auto Generated on 2023-06-29
-- DROP TABLE IF EXISTS user_relate;
CREATE TABLE user_relate(
	sendId VARCHAR (50) NOT NULL COMMENT '添加好友者',
	receiveId VARCHAR (50) NOT NULL DEFAULT '' COMMENT '被添加的好友',
	PRIMARY KEY (sendId,receiveId)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT '好友表';
