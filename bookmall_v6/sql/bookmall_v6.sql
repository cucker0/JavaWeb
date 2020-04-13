USE bookmall;

-- 创建订单表
CREATE TABLE t_order (
    id VARCHAR(50) PRIMARY KEY,
    user_id INT NOT NULL COMMENT '关联用户id',
    total_amount DECIMAL(11, 2) NOT NULL COMMENT '总金额',
    `status` TINYINT NOT NULL DEFAULT 0 COMMENT '物流状态', -- 0:为发货  1:一发货  2:用户已签收 
    create_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '订单创建时间'
) COMMENT='订单表';

-- 订单项
CREATE TABLE t_order_item (
    id INT PRIMARY KEY AUTO_INCREMENT,
    order_id VARCHAR(50) NOT NULL COMMENT '关联的订单',
    `name` VARCHAR(64) NOT NULL COMMENT '商品名称',
    price DECIMAL(11, 2) NOT NULL COMMENT '商品单价',
    `count` INT NOT NULL COMMENT '数量',
    -- 同一订单中的同一商品是唯一的
    UNIQUE KEY t_order_item__order_id__uniq__name (order_id, `name`)
) COMMENT='订单项表';