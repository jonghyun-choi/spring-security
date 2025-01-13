-- Sample data for User entity, without specifying the id field
INSERT INTO TB_USER_MST (username, password, authority)
VALUES
    ('user1', 'password1', 'ROLE_USER'),
    ('user2', 'password2', 'ROLE_ADMIN'),
    ('user3', 'password3', 'ROLE_USER'),
    ('user4', 'password4', 'ROLE_MODERATOR');
