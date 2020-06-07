# 创建用户表
DROP TABLE IF EXISTS start_light_user;

CREATE TABLE start_light_user(
    id VARCHAR(32) NOT NULL PRIMARY KEY COMMENT '主键',
    username VARCHAR(32) NOT NULL COMMENT '用户名',
    password VARCHAR(32) NOT NULL COMMENT '密码',
    phone VARCHAR(11) NOT NULL COMMENT '手机号',
    create_time DATETIME NOT NULL COMMENT '创建时间',
    update_time DATETIME COMMENT '更新时间',
    delete_flag INT NOT NULL COMMENT '删除标识, 0否1是'
) COMMENT '用户表' ENGINE = InnoDB DEFAULT CHARSET = UTF8MB4;