select * from roles
select * from user_role
select * from users
select * from refresh_token

INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_MODERATOR');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');

delete from user_role
where user_id = 2

delete from users
where id = 2

delete from refresh_token
where id = 204
