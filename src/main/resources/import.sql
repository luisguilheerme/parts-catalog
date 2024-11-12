INSERT INTO tb_user (name, email, password) VALUES ('Maria Brown', 'maria@gmail.com', '$2a$12$.YLBMp/x.dvcKjMXDiNe6.RBw/9KsWdx/sQtKd.CSjGYUCcLO11Le');
INSERT INTO tb_user (name, email, password) VALUES ('Alex Green', 'alex@gmail.com', '$2a$12$.YLBMp/x.dvcKjMXDiNe6.RBw/9KsWdx/sQtKd.CSjGYUCcLO11Le');


INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');


INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);


INSERT INTO tb_group (name) VALUES ('Motor de Partida');
INSERT INTO tb_group (name) VALUES ('Alternador');


INSERT INTO tb_manufacturer (name) VALUES ('Bosch');
INSERT INTO tb_manufacturer (name) VALUES ('Valeo');
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


INSERT INTO tb_model (name, brand_id) VALUES ('Gol', 1);
INSERT INTO tb_model (name, brand_id) VALUES ('Fox', 1);
INSERT INTO tb_model (name, brand_id) VALUES ('Saveiro', 1);
INSERT INTO tb_model (name, brand_id) VALUES ('Parati', 1);
INSERT INTO tb_model (name, brand_id) VALUES ('Polo', 1);
INSERT INTO tb_model (name, brand_id) VALUES ('Voyage', 1);
INSERT INTO tb_model (name, brand_id) VALUES ('Golf', 1);


INSERT INTO tb_model (name, brand_id) VALUES ('Monza', 2);
INSERT INTO tb_model (name, brand_id) VALUES ('Astra', 2);
INSERT INTO tb_model (name, brand_id) VALUES ('Vectra', 2);
INSERT INTO tb_model (name, brand_id) VALUES ('S-10', 2);
INSERT INTO tb_model (name, brand_id) VALUES ('Montana', 2);
INSERT INTO tb_model (name, brand_id) VALUES ('Cruze', 2);
INSERT INTO tb_model (name, brand_id) VALUES ('Spin', 2);
INSERT INTO tb_model (name, brand_id) VALUES ('Onix', 2);


INSERT INTO tb_model (name, brand_id) VALUES ('Palio', 3);
INSERT INTO tb_model (name, brand_id) VALUES ('Siena', 3);
INSERT INTO tb_model (name, brand_id) VALUES ('Strada', 3);
INSERT INTO tb_model (name, brand_id) VALUES ('Fiorino', 3);
INSERT INTO tb_model (name, brand_id) VALUES ('Mobi', 3);
INSERT INTO tb_model (name, brand_id) VALUES ('Toro', 3);
INSERT INTO tb_model (name, brand_id) VALUES ('Uno', 3);


INSERT INTO tb_model (name, brand_id) VALUES ('Ka', 4);
INSERT INTO tb_model (name, brand_id) VALUES ('Fiesta', 4);
INSERT INTO tb_model (name, brand_id) VALUES ('Focus', 4);
INSERT INTO tb_model (name, brand_id) VALUES ('Ecosport', 4);


INSERT INTO tb_part (MANUFACTURER_ID, SUBGROUP_ID) VALUES (1, 1);
INSERT INTO part_code (PART_ID, CODE) VALUES (1, 'BZM1666');
INSERT INTO part_code (PART_ID, CODE) VALUES (1, 'ZEN1666');
INSERT INTO part_original_code (PART_ID, ORIGINAL_CODE) VALUES (1, 'F000CD1009');
INSERT INTO part_original_code (PART_ID, ORIGINAL_CODE) VALUES (1, 'F000CD1444');
INSERT INTO PART_STARTER_ALTERNATOR (PART_ID, STARTER_ALTERNATOR) VALUES (1, 'F000CD0900');
INSERT INTO PART_STARTER_ALTERNATOR (PART_ID, STARTER_ALTERNATOR) VALUES (1, 'F000CD0903');
INSERT INTO PART_STARTER_ALTERNATOR (PART_ID, STARTER_ALTERNATOR) VALUES (1, 'F000CD0001');


INSERT INTO tb_application(PART_ID, model_id) VALUES (1, 16);
INSERT INTO tb_application(PART_ID, model_id) VALUES (1, 17);
INSERT INTO tb_application(PART_ID, model_id) VALUES (1, 18);
INSERT INTO tb_application(PART_ID, model_id) VALUES (1, 19);
INSERT INTO tb_application(PART_ID, model_id) VALUES (1, 22);


INSERT INTO tb_part (MANUFACTURER_ID, SUBGROUP_ID) VALUES (1, 2);
INSERT INTO part_code (PART_ID, CODE) VALUES (2, 'UNIFAP 1.210/4');
INSERT INTO part_code (PART_ID, CODE) VALUES (2, 'SULCARBON A210');
INSERT INTO part_original_code (PART_ID, ORIGINAL_CODE) VALUES (2, 'F000CD1203');
INSERT INTO part_original_code (PART_ID, ORIGINAL_CODE) VALUES (2, 'F000CD1441');
INSERT INTO PART_STARTER_ALTERNATOR (PART_ID, STARTER_ALTERNATOR) VALUES (2, 'F000CD0900');
INSERT INTO PART_STARTER_ALTERNATOR (PART_ID, STARTER_ALTERNATOR) VALUES (2, 'F000CD0903');
INSERT INTO PART_STARTER_ALTERNATOR (PART_ID, STARTER_ALTERNATOR) VALUES (2, 'F000CD0001');


INSERT INTO tb_application(PART_ID, model_id) VALUES (1, 16);
INSERT INTO tb_application(PART_ID, model_id) VALUES (1, 17);
INSERT INTO tb_application(PART_ID, model_id) VALUES (1, 18);
INSERT INTO tb_application(PART_ID, model_id) VALUES (1, 19);
INSERT INTO tb_application(PART_ID, model_id) VALUES (1, 22);


INSERT INTO tb_part (MANUFACTURER_ID, SUBGROUP_ID) VALUES (2, 2);
INSERT INTO part_code (PART_ID, CODE) VALUES (3, 'UNIFAP 1.203/4');
INSERT INTO part_code (PART_ID, CODE) VALUES (3, 'SULCARBON A203');
INSERT INTO part_original_code (PART_ID, ORIGINAL_CODE) VALUES (3, '555649');
INSERT INTO part_original_code (PART_ID, ORIGINAL_CODE) VALUES (3, '594381');
INSERT INTO PART_STARTER_ALTERNATOR (PART_ID, STARTER_ALTERNATOR) VALUES (3, 'D7E56');
INSERT INTO PART_STARTER_ALTERNATOR (PART_ID, STARTER_ALTERNATOR) VALUES (3, '438179');
INSERT INTO PART_STARTER_ALTERNATOR (PART_ID, STARTER_ALTERNATOR) VALUES (3, 'D7ES6');
INSERT INTO PART_STARTER_ALTERNATOR (PART_ID, STARTER_ALTERNATOR) VALUES (3, 'TS10E26');


INSERT INTO tb_application(PART_ID, model_id, obs) VALUES (3, 1, 'G5');
INSERT INTO tb_application(PART_ID, model_id) VALUES (3, 2);
INSERT INTO tb_application(PART_ID, model_id, obs) VALUES (3, 3, 'G5');
INSERT INTO tb_application(PART_ID, model_id, obs) VALUES (3, 6, 'G5');
INSERT INTO tb_application(PART_ID, model_id) VALUES (3, 7);


INSERT INTO tb_part (MANUFACTURER_ID, SUBGROUP_ID) VALUES (2, 1);
INSERT INTO part_code (PART_ID, CODE) VALUES (4, 'ZEN1534');
INSERT INTO part_code (PART_ID, CODE) VALUES (4, 'BZM1534');
INSERT INTO part_original_code (PART_ID, ORIGINAL_CODE) VALUES (4, '494831');
INSERT INTO PART_STARTER_ALTERNATOR (PART_ID, STARTER_ALTERNATOR) VALUES (4, 'D7E56');
INSERT INTO PART_STARTER_ALTERNATOR (PART_ID, STARTER_ALTERNATOR) VALUES (4, 'D7ES6');


INSERT INTO tb_application(PART_ID, model_id, obs) VALUES (4, 1, 'G5');
INSERT INTO tb_application(PART_ID, model_id) VALUES (4, 2);
INSERT INTO tb_application(PART_ID, model_id, obs) VALUES (4, 3, 'G5');
INSERT INTO tb_application(PART_ID, model_id, obs) VALUES (4, 6, 'G5');
INSERT INTO tb_application(PART_ID, model_id) VALUES (4, 7);
