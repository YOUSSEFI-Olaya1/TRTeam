drop database if exists TRteam;
create database if not exists TRteam;
use TRteam;
create table TRteam.horaires(
id integer primary key auto_increment,
depart varchar(50),
arrive varchar(50),
numtrain varchar(40),
Hdepart time,
Harrive time,
nombreplace integer);
insert into TRteam.horaires (depart,arrive,numtrain,Hdepart,Harrive) values ('Oud-zem','Casa','900','6:45:00','10:18:00'); 
insert into TRteam.horaires (depart,arrive,numtrain,Hdepart,Harrive) values ('Casa','Oud-zem','v15113','5:50:00','19:17:00');
insert into TRteam.horaires (depart,arrive,numtrain,Hdepart,Harrive) values ('Khouribga','Casa','v15106','13:30:00','16:15:00');
insert into TRteam.horaires (depart,arrive,numtrain,Hdepart,Harrive) values ('Casa','Khouribga','v15111','9:50:00','12:22:00');
insert into TRteam.horaires (depart,arrive,numtrain,Hdepart,Harrive) values ('Safi','Casa','v15110','9:50:00','11:53:00');
insert into TRteam.horaires (depart,arrive,numtrain,Hdepart,Harrive) values ('Casa','Safi','v15115','16:00:00','18:15:00');

insert into TRteam.horaires (depart,arrive,numtrain,Hdepart,Harrive) values ('Oujda','Sidi-slimane','202','7:50:00','15:32:00');
insert into TRteam.horaires (depart,arrive,numtrain,Hdepart,Harrive) values ('Sidi-slimane','Oujda','303','14:24:00','22:12:00');
insert into TRteam.horaires (depart,arrive,numtrain,Hdepart,Harrive) values ('Oujda','Casa','204','13:30:00','23:32:00');
insert into TRteam.horaires (depart,arrive,numtrain,Hdepart,Harrive) values ('Casa','Oujda','103','6:40:00','16:59:00');
insert into TRteam.horaires (depart,arrive,numtrain,Hdepart,Harrive) values ('Oujda','Mekness','v15098','22:30:00','5:30:00');
insert into TRteam.horaires (depart,arrive,numtrain,Hdepart,Harrive) values ('Mekness','Oujda','139','1:28:00','7:00:00');
insert into TRteam.horaires (depart,arrive,numtrain,Hdepart,Harrive) values ('Nador','Casa','503','9:36:00','20:30:00');
insert into TRteam.horaires (depart,arrive,numtrain,Hdepart,Harrive) values ('Casa','Nador','v15117','9:30:00','20:06:00');

insert into TRteam.horaires (depart,arrive,numtrain,Hdepart,Harrive) values ('Marrakech','Casa','602','5:50:00','8:21:00');
insert into TRteam.horaires (depart,arrive,numtrain,Hdepart,Harrive) values ('Casa','Marrakech','132','21:35:00','00:14:00');
insert into TRteam.horaires (depart,arrive,numtrain,Hdepart,Harrive) values ('Marrakech','Fes','606','7:50:00','14:25:00');
insert into TRteam.horaires (depart,arrive,numtrain,Hdepart,Harrive) values ('Fes','Marrakech','112','7:40:00','14:14:00');
insert into TRteam.horaires (depart,arrive,numtrain,Hdepart,Harrive) values ('Casa','Fes','103','6:40:00','10:35:00');
insert into TRteam.horaires (depart,arrive,numtrain,Hdepart,Harrive) values ('Fes','Casa','106','5:40','9:35:00');
insert into TRteam.horaires (depart,arrive,numtrain,Hdepart,Harrive) values ('Mekness','Fes','v15091','8:02:00','8:38');
insert into TRteam.horaires (depart,arrive,numtrain,Hdepart,Harrive) values ('Fes','Mekness','v15092','6:40:00','7:16:00');
insert into TRteam.horaires (depart,arrive,numtrain,Hdepart,Harrive) values ('Marrakech','Kenitra','v15108','22:00:00','2:51:00');
insert into TRteam.horaires (depart,arrive,numtrain,Hdepart,Harrive) values ('Kenitra','Marrakech','132','20:00:00','00:14:00');

/*ajouter les column  Nomdutrain,prix et datedepart + insert  */

Alter table TRteam.horaires add column Nomdutrain varchar(50);
alter table TRteam.horaires add column prix float;
alter table TRteam.horaires add column  datedepart date;
SET SQL_SAFE_UPDATES = 0;
update TRteam.horaires set Nomdutrain="AL ATLAS",prix=250 where id=1;
update TRteam.horaires set Nomdutrain="AL ATLAS" ,prix=250  where id=2;
update TRteam.horaires set Nomdutrain="AL ATLAS" ,prix=250 where id=3;
update TRteam.horaires set Nomdutrain="ONCF" ,prix=250 where id=4;
update TRteam.horaires set Nomdutrain="AL Boraq" ,prix=250 where id=5;
update TRteam.horaires set Nomdutrain="ONCF" ,prix=250 where id=6;
update TRteam.horaires set Nomdutrain="AL Boraq" ,prix=250 where id=7;
update TRteam.horaires set Nomdutrain="AL Boraq" ,prix=250 where id=8;
update TRteam.horaires set Nomdutrain="AL ATLAS" ,prix=250 where id=9;
update TRteam.horaires set Nomdutrain="AL ATLAS" ,prix=250 where id=10;
update TRteam.horaires set Nomdutrain="AL Boraq" ,prix=250 where id=11;
update TRteam.horaires set Nomdutrain="AL Boraq" ,prix=250 where id=12;
update TRteam.horaires set Nomdutrain="AL Boraq" ,prix=250 where id=13;
update TRteam.horaires set Nomdutrain="AL ATLAS" ,prix=250 where id=14;
update TRteam.horaires set Nomdutrain="AL ATLAS" ,prix=250 where id=15;
update TRteam.horaires set Nomdutrain="AL ATLAS" ,prix=250 where id=16;
update TRteam.horaires set Nomdutrain="AL Boraq" ,prix=250 where id=17;
update TRteam.horaires set Nomdutrain="AL ATLAS" ,prix=250 where id=18;
update TRteam.horaires set Nomdutrain="AL ATLAS" ,prix=250 where id=19;
update TRteam.horaires set Nomdutrain="AL Boraq" ,prix=250 where id=20;
update TRteam.horaires set Nomdutrain="AL ATLAS" ,prix=250 where id=21;
update TRteam.horaires set Nomdutrain="AL Boraq" ,prix=250 where id=22;
update TRteam.horaires set Nomdutrain="AL Boraq" ,prix=250 where id=23;
update TRteam.horaires set Nomdutrain="AL ATLAS" ,prix=250 where id=24;
update TRteam.horaires set nombreplace=500  where id=id;

update TRteam.horaires set datedepart = DATE(STR_TO_DATE('30/06/2022', '%d/%m/%Y')) where id=id;
/*select DATE_FORMAT(datedepart, '%d/%m/%Y') from TRteam.horaires ;*/


create table TRteam.login
(
id integer primary key auto_increment,
email varchar(100),
password varchar(100));
/* pour le login : */
insert into TRteam.login (email,password) values ('email@gmail.com','passwordlog');


create table TRteam.paiment(
id integer primary key auto_increment,
name varchar(50),
amount float,
nameoncard varchar(50),
cardNBR integer,
Expirydate varchar(30),
SecurityCode varchar(50)
);

alter table TRteam.paiment modify column cardNBR varchar(30);

alter table TRteam.paiment add column depart varchar(30);
alter table TRteam.paiment add column arrivee varchar(30);
alter table TRteam.paiment add column tele varchar(30);
alter table TRteam.paiment add column trainName varchar(30);
alter table TRteam.paiment add column trainNumnber varchar(30);
alter table TRteam.paiment add column datedepart varchar(30);




/*---------------------------------------------*** Annances ***------------------------------------------*/
create table TRteam.annance
(id integer primary key auto_increment,
trainName varchar(50),
trainnbr varchar(30),
depart varchar(50),
arrive varchar(50),
Hdepart varchar(30),
Harrive varchar(30),
cause varchar(100),
duration varchar(100));
