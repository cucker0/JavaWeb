USE bookmall;

-- 查询图书信息与作者信息
SELECT b.*, a.name 'author'
FROM t_book b
LEFT OUTER JOIN r_book_author r
ON b.id = r.book_id
LEFT OUTER JOIN t_author a
ON r.author_id = a.id
;