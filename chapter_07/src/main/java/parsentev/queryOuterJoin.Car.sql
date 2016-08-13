/*create table transmission (
	id serial primary key,
	name varchar(200)
);

create table engine (
	id serial primary key,
	name varchar(200)
);

create table gearbox (
	id serial primary key,
	name varchar(200)
);

create table car (
	id serial primary key,
	name varchar(200),
	transmission_id int not null references transmission(id),
	engine_id int not null references engine(id),
	gearbox_id int not null references gearbox(id)
);

insert into transmission(name) values('hydraulic');
insert into transmission(name) values('hydrostatic');
insert into transmission(name) values('electromechanical');

insert into engine(name) values('air-breathing combustion engine');
insert into engine(name) values('pneumoengine');
insert into engine(name) values('electric motor');

insert into gearbox(name) values('manual');
insert into gearbox(name) values('automatic');
*/
--insert into car(name, transmission_id, engine_id, gearbox_id) values('Tesla', 3, 3, 2);

select c.name, t.name as transmission, e.name as engine, g.name as gearbox from car as c 
inner join transmission as t on c.transmission_id = t.id
inner join engine as e on c.engine_id = e.id
inner join gearbox as g on c.gearbox_id = g.id;

select t.name as transmission from car as c right join transmission as t on c.transmission_id = t.id
where c.transmission_id is null;

select e.name as engine from car as c right join engine as e on c.engine_id = e.id
where c.engine_id is null;

select g.name as gearbox from car as c right join gearbox as g on c.gearbox_id = g.id
where c.gearbox_id is null;
