create table users(
	id uuid default gen_random_uuid() primary key,
	email varchar(100) not null,
	password varchar(255) not null
);

create table tutor(
	id uuid default gen_random_uuid() primary key,
	name varchar(100) not null,
	phone varchar(20),
	city varchar(100),
	about varchar(255),
	photo bytea,
	user_id uuid not null,
	constraint fk_user_id foreign key(user_id) references users(id)
);