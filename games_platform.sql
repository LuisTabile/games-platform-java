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

create table removedGames (
id INT NOT NULL auto_increment,
name VARCHAR(50),
id_game int,
PRIMARY KEY (id),
CONSTRAINT fk FOREIGN KEY (id_game) REFERENCES game (id)
);

INSERT INTO client (id, name, balance)
VALUES
  (1,"Meghan Howell",1476),
  (2,"Tucker Chan",1229),
  (3,"Uriel Guthrie",3165),
  (4,"Yuli Dale",112),
  (5,"Kyla Bentley",1259),
  (6,"September Glover",1582),
  (7,"Kevyn Donaldson",3167),
  (8,"Patrick Sims",2754),
  (9,"Hammett Patton",878),
  (10,"Kermit Melendez",2399),
  (11,"Sacha Saunders",3053),
  (12,"Avram Reyes",4826),
  (13,"Allegra Lott",4809),
  (14,"Alden Estes",3671),
  (15,"Quinlan Hall",3120),
  (16,"Denise Turner",156),
  (17,"Sharon Willis",702),
  (18,"Fitzgerald Flores",1848),
  (19,"Gary Mejia",4979),
  (20,"Kane Jennings",873);

INSERT INTO publisher (id,name)
VALUES
  (1,"Et Lacinia Foundation"),
  (2,"Urna Nullam Foundation"),
  (3,"Imperdiet Ullamcorper Duis PC"),
  (4,"Commodo Hendrerit Industries"),
  (5,"Augue Eu Tellus Associates");
  
INSERT INTO game (id,name,description,release_date,price,publisher_id)
VALUES
  (1,"Blandit Viverra Corp.","lacinia vitae, sodales at, velit. Pellentesque ultricies","2022-03-04",135,4),
  (2,"Justo Faucibus Lectus Incorporated","arcu. Sed eu nibh vulputate mauris sagittis","2022-08-22",258,2),
  (3,"Vehicula Et Company","vel, faucibus id, libero. Donec consectetuer mauris id sapien.","2016-12-26",80,4),
  (4,"Et Eros Proin Limited","Nunc laoreet lectus quis massa. Mauris vestibulum, neque","2014-05-11",122,2),
  (5,"Sit Amet Dapibus Corp.","purus sapien, gravida non, sollicitudin a, malesuada","2015-01-24",36,2),
  (6,"Proin Vel Corporation","lacinia vitae, sodales at, velit. Pellentesque","2017-06-21",269,3),
  (7,"Molestie Associates","quam a felis ullamcorper viverra. Maecenas iaculis aliquet diam. Sed","2017-05-08",192,2),
  (8,"Integer Tincidunt Consulting","aliquet, sem ut cursus luctus,","2016-02-21",69,3),
  (9,"Natoque Penatibus LLC","non, dapibus rutrum, justo. Praesent","2016-01-11",248,1),
  (10,"Lectus Justo Eu PC","tortor at risus. Nunc ac sem ut","2018-05-28",229,3),
  (11,"Maecenas Libero Est Inc.","magna a neque. Nullam ut nisi a odio","2022-04-05",190,3),
  (12,"Dapibus Quam Corp.","enim, condimentum eget, volutpat ornare, facilisis eget,","2016-04-12",26,4),
  (13,"Ipsum Curabitur LLP","mauris. Suspendisse aliquet molestie tellus. Aenean egestas hendrerit neque.","2019-06-29",234,4),
  (14,"Et Risus Foundation","Integer aliquam adipiscing lacus. Ut nec urna et","2017-04-25",300,1),
  (15,"Sem Magna Incorporated","senectus et netus et malesuada fames ac turpis","2019-04-13",241,4),
  (16,"Et Magnis Dis Ltd","Donec egestas. Duis ac arcu. Nunc mauris.","2021-04-29",80,1),
  (17,"A LLP","est ac facilisis facilisis, magna tellus faucibus leo,","2022-09-10",276,3),
  (18,"Neque Corporation","mollis. Integer tincidunt aliquam arcu. Aliquam","2021-03-07",271,3),
  (19,"Mauris Nulla Integer LLC","augue malesuada malesuada. Integer id magna et ipsum cursus","2020-01-17",266,1),
  (20,"Nisl LLC","Ut sagittis lobortis mauris. Suspendisse aliquet molestie","2018-09-24",162,3),
  (21,"Diam Associates","porttitor scelerisque neque. Nullam nisl. Maecenas malesuada fringilla est.","2020-09-25",250,2),
  (22,"Non LLC","consectetuer rhoncus. Nullam velit dui, semper et,","2022-06-14",53,4),
  (23,"Hendrerit Industries","feugiat. Sed nec metus facilisis lorem tristique aliquet. Phasellus","2018-03-09",267,3),
  (24,"Iaculis Quis LLP","orci lacus vestibulum lorem, sit amet","2018-03-20",115,3),
  (25,"Interdum Enim Non Corp.","Integer aliquam adipiscing lacus. Ut nec urna et","2022-01-09",44,4);
INSERT INTO removedGames (id,name, id_game)
VALUES
  (1,"Et Lacinia Foundation", 1),
  (2,"Urna Nullam Foundation", 2),
  (3,"Imperdiet Ullamcorper Duis PC", 3),
  (4,"Commodo Hendrerit Industries", 4),
  (5,"Augue Eu Tellus Associates", 5);
