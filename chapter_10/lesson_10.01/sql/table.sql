create table lesson_10_01_items (
	id serial primary key,
	description text,
	create_date timestamp default now(),
	done boolean default false
);