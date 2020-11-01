CREATE TABLE user (
  id            BIGINT UNSIGNED     NOT NULL COMMENT 'id' AUTO_INCREMENT PRIMARY KEY,
  name          VARCHAR(128)        NOT NULL DEFAULT '' COMMENT 'userName',
  create_time   BIGINT UNSIGNED     NOT NULL COMMENT 'createTime',
  update_time   BIGINT UNSIGNED     NOT NULL COMMENT 'updateTime'
) ENGINE = InnoDB DEFAULT CHARSET utf8mb4 COMMENT '用户信息表';