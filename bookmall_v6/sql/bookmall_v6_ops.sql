USER bookmall;

-- 保存订单
INSERT INTO t_order (id, user_id, total_amount, `status`, create_time) VALUES
('id', 'user_id', 'total_amount', 'status', 'create_time');

INSERT INTO t_order (id, user_id, total_amount, `status`, create_time) VALUES
(?, ?, ?, ?, ?);

-- 通过订单id查询订单
SELECT id, user_id userId, total_amount totalAmount, `status`, create_time sqlCreateTime FROM t_order WHERE id = ?;

-- 查询指定用户id的所有订单
SELECT id, user_id userId, total_amount totalAmount, `status`, create_time sqlCreateTime FROM t_order WHERE user_id = ?;


--
-- 保存订单项
INSERT INTO t_order_item (id, order_id, `name`, price, `count`) VALUES
('id', 'order_id', 'name', 'price', 'count');

INSERT INTO t_order_item (id, order_id, `name`, price, `count`) VALUES (?, ?, ?, ?, ?);

-- 根据订单id，查询所有与此订单关联的订单项
SELECT id, order_id orderId, `name`, price, `count` FROM t_order_item WHERE order_id = ?;

