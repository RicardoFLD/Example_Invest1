create database players

use players


create table players(
Name varchar(50),
Race varchar(50),
Age int,
Lore varchar(200)
)


insert into players (Name, Race, Age, Lore)
values ("Isildur", "elfo", 560, "Fundador de la blanca via")

delete from products where Name = $Name


select * from players