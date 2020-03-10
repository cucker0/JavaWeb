USE bookmall;

-- 创建图书作者表
CREATE TABLE t_author (
    id INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(64) NOT NULL COMMENT '作者姓名',
    brief VARCHAR(256) COMMENT '作者简介'
)

-- 创建图书表
CREATE TABLE t_book (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(64) NOT NULL COMMENT '书名',
    `authors` VARCHAR(64) NOT NULL COMMENT '作者',
    `price` DECIMAL(11, 2) NOT NULL COMMENT '价格',
    `sales` INT NOT NULL DEFAULT 0 COMMENT '销量',
    `stock` INT NOT NULL DEFAULT 0 COMMENT '库存',    
    `img_path` VARCHAR(512) COMMENT '书的图片路径',
    publisher VARCHAR(128) COMMENT '出版社',
    `time` DATE DEFAULT COMMENT '出版时间',
    
    CONSTRAINT t_book__author_fk_t_author__id FOREIGN KEY (author) REFERENCES t_author (id) ON DELETE SET NULL
);

SHOW CREATE TABLE t_book;

-- 插入数据
INSERT INTO bookmall.t_book (id, `name`, author, price, sales, stock, img_path) VALUES
(NULL, '贫穷的本质：我们为什么摆脱不了贫穷', 'author', 'price', 'sales', 'stock', 'img_path'),
(NULL, 'name', 'author', 'price', 'sales', 'stock', 'img_path'),
;

