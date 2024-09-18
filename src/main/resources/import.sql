INSERT INTO tb_user (name, email, password) VALUES ('Maria Brown', 'maria@gmail.com', '$2a$12$.YLBMp/x.dvcKjMXDiNe6.RBw/9KsWdx/sQtKd.CSjGYUCcLO11Le');
INSERT INTO tb_user (name, email, password) VALUES ('Alex Green', 'alex@gmail.com', '$2a$12$.YLBMp/x.dvcKjMXDiNe6.RBw/9KsWdx/sQtKd.CSjGYUCcLO11Le');


INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');


INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);


INSERT INTO tb_group (name) VALUES ('Motor de Partida');
INSERT INTO tb_group (name) VALUES ('Alternador');


INSERT INTO tb_manufacturer (name) VALUES ('Bosch');
INSERT INTO tb_manufacturer (name) VALUES ('Delco');
INSERT INTO tb_manufacturer (name) VALUES ('Denso');
INSERT INTO tb_manufacturer (name) VALUES ('Iskra');
INSERT INTO tb_manufacturer (name) VALUES ('Mitsubishi');
INSERT INTO tb_manufacturer (name) VALUES ('Motorcraft');
INSERT INTO tb_manufacturer (name) VALUES ('Hitachi');
INSERT INTO tb_manufacturer (name) VALUES ('Prestolite');


INSERT INTO tb_subgroup (name, group_id) VALUES ('Impulsor de Partida', 1);
INSERT INTO tb_subgroup (name, group_id) VALUES ('Porta Escovas', 1);
INSERT INTO tb_subgroup (name, group_id) VALUES ('Planetária', 1);
INSERT INTO tb_subgroup (name, group_id) VALUES ('Kit de Buchas', 1);


INSERT INTO tb_subgroup (name, group_id) VALUES ('Regulador de Voltagem', 2);
INSERT INTO tb_subgroup (name, group_id) VALUES ('Placa Retificadora', 2);


INSERT INTO tb_brand (name) VALUES ('Volkswagen');
INSERT INTO tb_brand (name) VALUES ('Chevrolet');
INSERT INTO tb_brand (name) VALUES ('Fiat');
INSERT INTO tb_brand (name) VALUES ('Ford');
INSERT INTO tb_brand (name) VALUES ('Peugeot');
INSERT INTO tb_brand (name) VALUES ('Renault');


INSERT INTO tb_model (name, brand_id) VALUES ('Gol', 1);
INSERT INTO tb_model (name, brand_id) VALUES ('Polo', 1);
INSERT INTO tb_model (name, brand_id) VALUES ('Virtus', 1);
INSERT INTO tb_model (name, brand_id) VALUES ('T-Cross', 1);
INSERT INTO tb_model (name, brand_id) VALUES ('Nivus', 1);
INSERT INTO tb_model (name, brand_id) VALUES ('Jetta', 1);
INSERT INTO tb_model (name, brand_id) VALUES ('Passat', 1);
INSERT INTO tb_model (name, brand_id) VALUES ('Tiguan', 1);
INSERT INTO tb_model (name, brand_id) VALUES ('Amarok', 1);
INSERT INTO tb_model (name, brand_id) VALUES ('Saveiro', 1);


INSERT INTO tb_model (name, brand_id) VALUES ('Onix', 2);
INSERT INTO tb_model (name, brand_id) VALUES ('Prisma', 2);
INSERT INTO tb_model (name, brand_id) VALUES ('Cruze', 2);
INSERT INTO tb_model (name, brand_id) VALUES ('Spin', 2);
INSERT INTO tb_model (name, brand_id) VALUES ('Tracker', 2);
INSERT INTO tb_model (name, brand_id) VALUES ('S10', 2);
INSERT INTO tb_model (name, brand_id) VALUES ('Montana', 2);
INSERT INTO tb_model (name, brand_id) VALUES ('Camaro', 2);
INSERT INTO tb_model (name, brand_id) VALUES ('Equinox', 2);
INSERT INTO tb_model (name, brand_id) VALUES ('Trailblazer', 2);


INSERT INTO tb_model (name, brand_id) VALUES ('Uno', 3);
INSERT INTO tb_model (name, brand_id) VALUES ('Mobi', 3);
INSERT INTO tb_model (name, brand_id) VALUES ('Argo', 3);
INSERT INTO tb_model (name, brand_id) VALUES ('Cronos', 3);
INSERT INTO tb_model (name, brand_id) VALUES ('Toro', 3);
INSERT INTO tb_model (name, brand_id) VALUES ('Strada', 3);
INSERT INTO tb_model (name, brand_id) VALUES ('Pulse', 3);
INSERT INTO tb_model (name, brand_id) VALUES ('Fiorino', 3);
INSERT INTO tb_model (name, brand_id) VALUES ('Ducato', 3);
INSERT INTO tb_model (name, brand_id) VALUES ('Siena', 3);


INSERT INTO tb_model (name, brand_id) VALUES ('Ka', 4);
INSERT INTO tb_model (name, brand_id) VALUES ('Fiesta', 4);
INSERT INTO tb_model (name, brand_id) VALUES ('Focus', 4);
INSERT INTO tb_model (name, brand_id) VALUES ('Ecosport', 4);
INSERT INTO tb_model (name, brand_id) VALUES ('Fusion', 4);
INSERT INTO tb_model (name, brand_id) VALUES ('Ranger', 4);
INSERT INTO tb_model (name, brand_id) VALUES ('Mustang', 4);
INSERT INTO tb_model (name, brand_id) VALUES ('Courier', 4);
INSERT INTO tb_model (name, brand_id) VALUES ('Edge', 4);
INSERT INTO tb_model (name, brand_id) VALUES ('Maverick', 4);


INSERT INTO tb_model (name, brand_id) VALUES ('208', 5);
INSERT INTO tb_model (name, brand_id) VALUES ('2008', 5);
INSERT INTO tb_model (name, brand_id) VALUES ('3008', 5);
INSERT INTO tb_model (name, brand_id) VALUES ('308', 5);
INSERT INTO tb_model (name, brand_id) VALUES ('408', 5);
INSERT INTO tb_model (name, brand_id) VALUES ('Partner', 5);
INSERT INTO tb_model (name, brand_id) VALUES ('Hoggar', 5);
INSERT INTO tb_model (name, brand_id) VALUES ('Expert', 5);
INSERT INTO tb_model (name, brand_id) VALUES ('207', 5);
INSERT INTO tb_model (name, brand_id) VALUES ('307', 5);


INSERT INTO tb_model (name, brand_id) VALUES ('Kwid', 6);
INSERT INTO tb_model (name, brand_id) VALUES ('Sandero', 6);
INSERT INTO tb_model (name, brand_id) VALUES ('Logan', 6);
INSERT INTO tb_model (name, brand_id) VALUES ('Duster', 6);
INSERT INTO tb_model (name, brand_id) VALUES ('Captur', 6);
INSERT INTO tb_model (name, brand_id) VALUES ('Oroch', 6);
INSERT INTO tb_model (name, brand_id) VALUES ('Master', 6);
INSERT INTO tb_model (name, brand_id) VALUES ('Kangoo', 6);
INSERT INTO tb_model (name, brand_id) VALUES ('Megane', 6);
INSERT INTO tb_model (name, brand_id) VALUES ('Fluence', 6);

