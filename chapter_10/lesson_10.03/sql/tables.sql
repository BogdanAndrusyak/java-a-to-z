create table transmissions (
	id serial primary key,
	name varchar(200)
);

create table engines (
	id serial primary key,
	name varchar(200)
);

create table gearboxes (
	id serial primary key,
	name varchar(200)
);

create table car_sales_platforms (
  id serial primary key,
  name varchar(200)
);

create table cars (
	id serial primary key,
	name varchar(200),

  -- one-to-one dependency in hiber use many-to-one(to-one actually)
	transmission_id int not null references lesson_10_02_transmissions(id),
	engine_id int not null references lesson_10_02_engines(id),
	gearbox_id int not null references lesson_10_02_gearboxes(id),
  -- 	todo can without this?
	car_sales_platform_id int not null references lesson_10_02_car_sales_platforms(id)
);