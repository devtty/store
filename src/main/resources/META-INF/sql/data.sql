INSERT INTO ST_CLIENT (ID, NAME, ADDRESS) VALUES (-1, 'Cargo Spec. Ltd.', 'Berlin');
INSERT INTO ST_CLIENT (ID, NAME, ADDRESS) VALUES (-2, 'The Transporter', 'Paris');
INSERT INTO ST_CLIENT (ID, NAME, ADDRESS) VALUES (-3, 'Transport und Mehr', 'Moskau');

INSERT INTO ST_STORE (ID, NAME, ADDRESS) VALUES (-1, 'Store #1', '16348 Wandlitz');
INSERT INTO ST_STORE (ID, NAME, ADDRESS) VALUES (-2, 'Store #2', '10117 Berlin');

INSERT INTO ST_USER (ID, NAME, LOGIN, PASS, EMAIL, ROLE, ACCOUNTING) VALUES (-1, 'admin', 'admin', 'admin', 'admin@devtty.de', 'Admin', 1);
INSERT INTO ST_USER (ID, NAME, LOGIN, PASS, EMAIL, ROLE, ACCOUNTING) VALUES (-2, 'user', 'user', 'user', 'user@devtty.de', 'User', 1);
INSERT INTO ST_USER (ID, NAME, LOGIN, PASS, EMAIL, ROLE, ACCOUNTING, CLIENT_ID) VALUES (-3, 'client', 'client', 'client', 'client@devtty.de', 'Client', 0, -1);
INSERT INTO ST_USER (ID, NAME, LOGIN, PASS, EMAIL, ROLE, ACCOUNTING, STORE_ID) VALUES (-4, 'store', 'store', 'store', 'store@devtty.de', 'Store', 0, -1);