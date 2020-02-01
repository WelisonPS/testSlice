create database baseSpark;
use baseSpark;

create table entidade (id INT auto_increment primary key, modelo VARCHAR(32), marca VARCHAR(32));

insert into entidade (modelo, marca) values("Fiesta", "FORD");
insert into entidade (modelo, marca) values("UNO", "FIAT");
insert into entidade (modelo, marca) values("CRUZE", "Chevrolet");
insert into entidade (modelo, marca) values("FIT", "Honda");

select * from entidade;