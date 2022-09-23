drop database if exists games_platform;

create database games_platform;
use games_platform;

create table client (
	id INT NOT NULL	auto_increment,
	name  VARCHAR(50),
    balance float,
    PRIMARY KEY(id)
);

create table publisher (
	id INT NOT NULL	auto_increment,
	name  VARCHAR(50),
    PRIMARY KEY(id)
);

create table game (
	id INT NOT NULL	auto_increment,
	name  VARCHAR(50),
    description text,
    release_date Date,
    price float,
    publisher_id int not null,
    PRIMARY KEY(id),
    FOREIGN KEY (publisher_id) REFERENCES publisher(id)
);

create table buy (
	id INT NOT NULL	auto_increment,
	client_id int,
    game_id int,
	PRIMARY KEY (id),
    CONSTRAINT FK_client FOREIGN KEY (client_id) REFERENCES client (id),
    CONSTRAINT FK_game FOREIGN KEY (game_id) REFERENCES game (id)
);

INSERT INTO publisher VALUES (1, "Editora 1");
INSERT INTO game VALUES (1, "Jogo 1", "Descrição 1", "2018-10-20", 100.00, 1);
INSERT INTO client VALUES (1, "Cliente 1", 300.0);
