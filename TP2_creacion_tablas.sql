begin transaction;

CREATE TABLE "tipo_de_atraccion" (
	"tipo"	TEXT NOT NULL,
	PRIMARY KEY("tipo")
);

INSERT INTO tipo_de_atraccion(tipo)
VALUES
	('PAISAJE'),
	('AVENTURA'),
	('DEGUSTACION');

------------------------------------------------------

CREATE TABLE "tipo_de_promocion" (
	"tipo"	TEXT NOT NULL,
	PRIMARY KEY("tipo")
);

INSERT INTO tipo_de_promocion(tipo)
VALUES
	('ABSOLUTA'),
	('PORCENTUAL'),
	('AXB');

------------------------------------------------------

CREATE TABLE "visitante" (
	"id"	INTEGER NOT NULL,
	"nombre"	TEXT,
	"fk_preferencia"	TEXT NOT NULL,
	"presupuesto"	REAL,
	"tiempo"	REAL,
	FOREIGN KEY("fk_preferencia") REFERENCES "tipo_de_atraccion"("tipo"),
	PRIMARY KEY("id" AUTOINCREMENT)
);

INSERT INTO visitante(nombre, fk_preferencia, presupuesto, tiempo)
VALUES
	('Luke Skywalker', 'AVENTURA', 100.0, 8.0),
	('Leia Organa', 'PAISAJE', 100.0, 8.0),
	('Han Solo', 'DEGUSTACION', 36.0, 8.0),
	('Chewbacca', 'PAISAJE', 120.0, 2.0);

------------------------------------------------------

CREATE TABLE "atraccion" (
	"id"	INTEGER NOT NULL,
	"nombre"	TEXT,
	"fk_tipo"	TEXT,
	"costo"	REAL,
	"duracion"	REAL,
	"cupo"	INTEGER,
	FOREIGN KEY("fk_tipo") REFERENCES "tipo_de_atraccion"("tipo"),
	PRIMARY KEY("id" AUTOINCREMENT)
);

INSERT INTO atraccion(nombre, fk_tipo, costo, duracion, cupo)
VALUES
	('Hoth', 'AVENTURA', 10, 2,6), --1
	('Tatooine', 'PAISAJE', 5, 2.5, 25),
	('Coruscant', 'DEGUSTACION', 3, 6.5, 150), --3
	('Estrella de la Muerte', 'AVENTURA', 25, 3, 4),
	('Kashyyk', 'PAISAJE', 5, 2, 15), --5
	('Geonosis', 'DEGUSTACION', 35, 1, 30),
	('Naboo', 'PAISAJE', 12, 3, 32), --7
	('Kamino', 'AVENTURA', 3, 4, 12);

------------------------------------------------------

CREATE TABLE "promocion" (
	"id" 	INTEGER NOT NULL,
	"fk_tipo_promo"	TEXT NOT NULL,
	"fk_tipo_atraccion"	TEXT NOT NULL,
	FOREIGN KEY("fk_tipo_promo") REFERENCES "tipo_de_promocion"("tipo"),
	FOREIGN KEY("fk_tipo_atraccion") REFERENCES "tipo_de_atraccion"("tipo_atraccion"),
	PRIMARY KEY("id" AUTOINCREMENT)
);

INSERT INTO promocion(fk_tipo_promo, fk_tipo_atraccion)
VALUES
	('PORCENTUAL', 'AVENTURA'), --1
	('ABSOLUTA', 'DEGUSTACION'), --2
	('AXB', 'PAISAJE'); --3

------------------------------------------------------

CREATE TABLE "promocion_atraccion" ( -- comprende las atracciones de las promociones, sin la gratis de 2x1
	"fk_id_promocion"	INTEGER NOT NULL,
	"fk_id_atraccion" INTEGER NOT NULL,	
	FOREIGN KEY("fk_id_promocion") REFERENCES "promocion"("id"),	
	FOREIGN KEY("fk_id_atraccion") REFERENCES "atraccion"("id"),
	PRIMARY KEY("fk_id_promocion", "fk_id_atraccion")
);

INSERT INTO promocion_atraccion(fk_id_promocion, fk_id_atraccion)
VALUES
	(1, 1), --Hoth
	(1, 4), --Estrella de la Muerte
	(2, 3), --Coruscant
	(2, 6), --Geonosis
	(3, 5), --Kashyyk
	(3, 2); --Tatooine

------------------------------------------------------

CREATE TABLE promocion_descuento (
	fk_id_promocion INTEGER,
	descuento REAL,
	FOREIGN KEY("fk_id_promocion") REFERENCES "promocion" ("id"),
	PRIMARY KEY("fk_id_promocion")
);

INSERT INTO promocion_descuento(fk_id_promocion, descuento)
VALUES
	(1, 0.2),
	(2, 3);

------------------------------------------------------

CREATE TABLE promocion_atraccion_gratis (
	fk_id_promocion INTEGER,
	fk_id_atraccion INTEGER,
	FOREIGN KEY("fk_id_promocion") REFERENCES "promocion" ("id"),
	FOREIGN KEY("fk_id_atraccion") REFERENCES "atraccion" ("id"),
	PRIMARY KEY("fk_id_promocion", "fk_id_atraccion")
);

INSERT INTO promocion_atraccion_gratis(fk_id_promocion, fk_id_atraccion)
VALUES
	(3, 7); --Naboo

------------------------------------------------------

CREATE TABLE "itinerario" ( -- esta tabla solo se agrega por satisfacer el enunciado. con la tabla visitante alcanza
	"fk_id_visitante"	INTEGER NOT NULL,
	FOREIGN KEY("fk_id_visitante") REFERENCES visitante(id),
	PRIMARY KEY("fk_id_visitante")
);

------------------------------------------------------

CREATE TABLE "itinerario_promocion" (
	"fk_id_itinerario"	INTEGER NOT NULL,
	"fk_id_promocion" INTEGER NOT NULL,	
	FOREIGN KEY("fk_id_itinerario") REFERENCES "itinerario"("fk_id_visitante"),	
	FOREIGN KEY("fk_id_promocion") REFERENCES "promocion"("id"),
	PRIMARY KEY("fk_id_itinerario", "fk_id_promocion")
);

------------------------------------------------------

CREATE TABLE "itinerario_atraccion" (
	"fk_id_itinerario"	INTEGER NOT NULL,
	"fk_id_atraccion" INTEGER NOT NULL,	
	FOREIGN KEY("fk_id_itinerario") REFERENCES "itinerario"("fk_id_visitante"),	
	FOREIGN KEY("fk_id_atraccion") REFERENCES "atraccion"("id"),
	PRIMARY KEY("fk_id_itinerario", "fk_id_atraccion")
);

commit transaction;
