create table users (
  id serial primary key,
  name varchar(200),
  login varchar(200),
  password varchar(200)
);

create table engines (
	id serial primary key,
	name varchar(200)
);

create table transmissions (
	id serial primary key,
	name varchar(200)
);

create table gearboxes (
	id serial primary key,
	name varchar(200)
);

create table cars (
	id serial primary key,
	description varchar(200),
	year int,
	photo bytea,
	sold boolean,
	price int,
	brand text,
	model text,
	type_body text,

  -- one-to-one dependency in hiber use many-to-one(to-one actually)
	engine_id int not null references engines(id),
	transmission_id int not null references transmissions(id),
	gearbox_id int not null references gearboxes(id),
	owner_id int not null references users(id)
);