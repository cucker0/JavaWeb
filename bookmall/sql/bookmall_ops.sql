SELECT * FROM t_user;



-- findUserByUsernameAndPassword(User user)
SELECT id, username, `password`, email FROM t_user WHERE username = ? AND `password` = ?;

-- saveUser(User user)
INSERT INTO t_user (username, `password`, email) VALUES (?, ?, ?);

