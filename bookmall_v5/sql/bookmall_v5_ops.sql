USE bookmall;

-- 查询图书信息与作者信息
SELECT b.*, a.name 'author'
FROM t_book b
LEFT OUTER JOIN r_book_author r
ON b.id = r.book_id
LEFT OUTER JOIN t_author a
ON r.author_id = a.id
;

SELECT * FROM t_author;

-- 插入图书与作者关联
INSERT INTO r_book_author (book_id, author_id) VALUES (?, ?);

-- 删除所有关联指定图书ID的作者关联记录
DELETE FROM r_book_author WHERE book_id = ?;


-- 删除指定图书ID、作者ID的关系关联记录
DELETE FROM r_book_author WHERE book_id = ? AND author_id = ?;

-- 查询指定ID图书与作者的所有关联记录
SELECT id, book_id bookId, author_id authorId FROM r_book_author WHERE book_id = ? LIMIT 0, 100;

-- 查看指定作者ID与图书的所有关联记录
SELECT id, book_id bookId, author_id authorId FROM r_book_author WHERE author_id = ? LIMIT 0, 100;

-- 检查指定id的图书与指定id的作者关联记录是否存在
SELECT id, book_id bookId, author_id authorId FROM r_book_author WHERE book_id = ? AND author_id = ? LIMIT 0, 100;

-- 查询指定ID的图书、作者关联记录是否存在
SELECT COUNT(*) FROM r_book_author WHERE book_id = ? AND author_id = ?;


--
-- 保存的author
INSERT INTO t_author (`name`, brief) VALUES (?, ?);

-- 删除指定ID的作者
DELETE FROM t_author WHERE id = ? ;

-- 更新作者信息
UPDATE t_author SET `name` = ?, brief = ? WHERE id = ?;

-- 查询所有的作者
SELECT DISTINCT id, `name`, brief FROM t_author;

-- 查询指定ID的作者
SELECT id, `name`, brief FROM t_author WHERE id = ?;

-- 检查用户ID是否有效
SELECT COUNT(id) FROM t_author WHERE id = ?;

-- 查找作者名中包含指定关键字的作者
SELECT id, `name`, brief FROM t_author WHERE `name` LIKE '%?%';
SELECT id, `name`, brief FROM t_author WHERE `name` LIKE '%科夫%';

-- 通过作者ID集合查询作者信息
SELECT id, `name`, brief FROM t_author WHERE id IN (?, ?);

--
-- 检查图书ID的有效性
SELECT COUNT(id) FROM t_book WHERE id = ?;

-- 添加图书
INSERT INTO t_book (`name`, price, sales, stock, img_path, publisher_id, `time`) VALUES
(?, ?, ?, ?, ?, ?, ?);

-- 删除指定ID的图书
DELETE FROM t_book WHERE id = ?;

-- 更新图书信息
UPDATE t_book SET `name` = ?, price = ?, sales = ?, stock = ?, img_path = ?, publisher_id = ?, `time` = ?
WHERE id = ?;

-- 查询所有图书
SELECT id, `name`, price, sales, stock, img_path imgPath, publisher_id, `time`
FROM  t_book
LIMIT 0, 1000;

-- 查询指定ID的图书信息
SELECT id, `name`, price, sales, stock, img_path imgPath, publisher_id, `time` FROM  t_book WHERE id = ?;

-- 通过图书名关键字查找图书
SELECT id, `name`, price, sales, stock, img_path imgPath, publisher_id, `time` FROM  t_book WHERE `name` LIKE ?;

-- 通过图书ID集合查询图书信息
SELECT id, `name`, price, sales, stock, img_path imgPath, publisher_id, `time` FROM  t_book WHERE id IN (?, ?);


--
-- 新增出版社
INSERT INTO t_publisher (`name`) VALUES (?);

-- 删除指定ID的出版社
DELETE FROM t_publisher WHERE id = ?;

-- 更新出版社信息
UPDATE t_publisher SET `name` = ? WHERE id = ?;

-- 查询所有的出版社
SELECT id, `name` FROM t_publisher;

-- 查询指定ID的出版社
SELECT id, `name` FROM t_publisher WHERE id = ?;

-- 按出版社名字关键字查找出版社
SELECT id, `name` FROM t_publisher WHERE `name` LIKE ?;

