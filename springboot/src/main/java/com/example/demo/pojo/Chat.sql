-- auto Generated on 2023-06-27
-- DROP TABLE IF EXISTS friend_list;
CREATE TABLE friend_list(
	`name` VARCHAR (50) NOT NULL COMMENT 'name',
	avatar VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'avatar',
	last_word VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'lastWord',
	last_time VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'lastTime',
	PRIMARY KEY (`name`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'friend_list';
