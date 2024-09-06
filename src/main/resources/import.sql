INSERT INTO tb_user (name, email, password) VALUES ('Maria Brown', 'maria@gmail.com', '$2a$12$.YLBMp/x.dvcKjMXDiNe6.RBw/9KsWdx/sQtKd.CSjGYUCcLO11Le');
INSERT INTO tb_user (name, email, password) VALUES ('Alex Green', 'alex@gmail.com', '$2a$12$.YLBMp/x.dvcKjMXDiNe6.RBw/9KsWdx/sQtKd.CSjGYUCcLO11Le');

INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);