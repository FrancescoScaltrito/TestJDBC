create database test_jdbc;
use test_jdbc;

create table persone(
	id_persona int not null auto_increment,
	nome varchar(50) not null,
	cognome varchar(50) not null,
	data_di_nascita date not null,
	primary key(id_persona)
	);

create table animali(
	id_animale int not null auto_increment,
	nome varchar(50) not null,
	data_di_nascita date,
	sesso varchar(2) not null,
	tipo varchar(50) not null,
	razza varchar(100),
	id_padrone int,
	primary key(id_animale),
	foreign key (id_padrone) references persone(id_persona)
	)
	
insert into persone  (nome, cognome, data_di_nascita)
	values("Massimo","Verdi","2020-12-12"),
	("Anna","Rossi","2000-06-03"),
	("Rosa","Russo","2014-04-12"),
	("Marco","Neri","2011-11-01"),
	("Andrea","Neri","2005-01-01"),
	("Giorgio","Verdi","1952-01-05"),
	("Giorgia","Russo","2000-01-01");


insert into animali (nome,data_di_nascita,sesso,tipo,razza,id_padrone)
	values("Nino","2022-1-2","M","Gatto","Siberiano",1),
			("Yuki","2025-6-14","M","Gatto",null,2),
			("Bobby","2016-1-2","M","Cane","Golden Retriever",6),
			("Minnie","2026-1-1","F","Canarino",null,1),
			("Rio","2023-4-5","M","Pappagallo","Cocorido",3);

insert into animali (nome,data_di_nascita,sesso,tipo,razza,id_padrone)
	values("Layla","2023-9-12","F","Gatto","Europeo",null);
