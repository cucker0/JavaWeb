-- bookmall

CREATE DATABASE bookmall CHARSET 'utf8';

USE bookmall;

-- 创建用户表
CREATE TABLE t_user (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    `password` VARCHAR(32) NOT NULL,
    email VARCHAR(50)
);


-- 创建一个管理用户
INSERT INTO t_user(username, `password`, email) VALUES
('admin', 'py123456', 'admin@bookmall.com');

SELECT * FROM t_user;



-- findUserByUsernameAndPassword(User user)
SELECT id, username, `password`, email FROM t_user WHERE username = ? AND `password` = ?;

-- saveUser(User user)
INSERT INTO t_user (username, `password`, email) VALUES (?, ?, ?);

