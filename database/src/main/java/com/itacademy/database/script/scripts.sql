SET SEARCH_PATH = rental_company;

DROP TABLE  rental_company.car;
CREATE TABLE car
(
    id BIGSERIAL PRIMARY KEY,
    supplier VARCHAR(30) NOT NULL,
    model VARCHAR(30) NOT NULL,
    max_speed INT DEFAULT 0,
    dollars_per_hour INT NOT NULL DEFAULT 0
);


DROP TABLE rental_company.address;
CREATE TABLE address (
                         id INTEGER PRIMARY KEY,
                         city VARCHAR(64) NOT NULL,
                         street VARCHAR(64) NOT NULL
);

DROP TABLE rental_company.user_;
CREATE TABLE user_ (
                       id BIGSERIAL PRIMARY KEY,
                       name VARCHAR(64) NOT NULL,
                       login VARCHAR(64) NOT NULL UNIQUE,
                       password VARCHAR(64) NOT NULL,
                       birth_date date,
                       email VARCHAR(64),
                       phone_number VARCHAR(64),
                       status CHAR(10) DEFAULT 'ACTIVE',
                       role CHAR(8) DEFAULT 'USER',
                       address_id INT REFERENCES address (id)
);

DROP TABLE rental_company.client_order;
CREATE TABLE client_order (
                              id BIGSERIAL PRIMARY KEY,
                              lease_period TIME NOT NULL,
                              passport_details VARCHAR(45) NOT NULL ,
                              admin_approval BOOLEAN DEFAULT FALSE,
                              notes VARCHAR(45) NOT NULL,
                              car_id INT,
                              client_id INT,
                              FOREIGN KEY (car_id) REFERENCES car(id) ON DELETE CASCADE,
                              FOREIGN KEY (client_id) REFERENCES user_(id) ON DELETE CASCADE
);

DROP TABLE passport;
CREATE TABLE passport (
                          id BIGSERIAL PRIMARY KEY,
                          number VARCHAR(20) NOT NULL UNIQUE,
                          user_id INT NOT NULL UNIQUE,
                          FOREIGN KEY (user_id) REFERENCES user_(id) ON DELETE CASCADE
);

create schema rental_company;

alter schema rental_company owner to postgres;

create table if not exists address
(
	id serial not null
		constraint address_pkey
			primary key,
	city varchar(255) not null,
	street varchar(255) not null
);

alter table address owner to postgres;

create table if not exists car
(
	id bigserial not null
		constraint car_pkey
			primary key,
	max_speed integer,
	model varchar(255) not null,
	dollars_per_hour integer not null,
	supplier varchar(255) not null,
	version bigint
);

alter table car owner to postgres;

create table if not exists car_user
(
	user_id bigint not null,
	car_id bigint not null
		constraint fk1k6olg9agm5y983l80o277o6x
			references car
);

alter table car_user owner to postgres;

create table if not exists client_order
(
	id bigint not null
		constraint fketip9wpid5bw05awusgpmem2h
			references client_order,
	admin_approval boolean,
	lease_period_from timestamp not null,
	lease_period_to timestamp not null,
	notes varchar(255),
	passport_details varchar(255),
	client_id bigint,
	car_id bigserial not null
		constraint client_order_pkey
			primary key
		constraint fksryba01i5dasnfapxxns8308y
			references car
);

alter table client_order owner to postgres;

create table if not exists passport
(
	id serial not null
		constraint passport_pkey
			primary key,
	number varchar(255) not null
		constraint uk_2vxpyfejufiv72wpih5uprf40
			unique,
	series varchar(255) not null
);

alter table passport owner to postgres;

create table if not exists user_
(
	id bigserial not null
		constraint user__pkey
			primary key,
	birth_date date,
	email varchar(255),
	phone_number varchar(255),
	login varchar(255) not null
		constraint uk_595avk25fuwifq27av9e3ixqn
			unique,
	name varchar(255),
	password varchar(255) not null,
	role varchar(255) default 'USER'::character varying,
	status varchar(255),
	address_id integer
		constraint fkt99kx4fa0okdr2keid6re132i
			references address,
	passport_id integer
		constraint fkl0q1nkpha7cha5txwsedfmke1
			references passport
);

alter table user_ owner to postgres;



