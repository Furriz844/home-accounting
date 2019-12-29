create database homebookeeper;
CREATE USER 'admin'@'%' IDENTIFIED BY 'admin';
GRANT ALL PRIVILEGES ON homebookeeper.* TO 'admin'@'%';