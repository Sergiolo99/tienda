DROP SCHEMA IF EXISTS tiendabd;
DROP USER IF EXISTS 'spq'@'localhost';

CREATE SCHEMA tiendabd;
CREATE USER IF NOT EXISTS 'spq'@'localhost' IDENTIFIED BY 'spq';

GRANT ALL ON tiendabd.* TO 'spq'@'localhost';