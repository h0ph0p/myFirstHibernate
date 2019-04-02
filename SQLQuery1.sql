--create database internet_shop

-- select * from goods
-- set DATEFORMAT dmy

-- DROP TABLE GOODS;
-- DROP TABLE PRODUCER;
-- DROP TABLE CHARACTERISTICS;
-- DROP TABLE ORDERS;
-- DROP TABLE TOTAL_ORDERS
-- DROP TABLE RECEIVE_T
-- DROP TABLE CUSTOMERS

CREATE TABLE PRODUCER (
	producer_id	serial PRIMARY KEY,
	producer_name	varchar(50),
	rating	float,
	logo varchar(50)
);



CREATE TABLE GOODS (
  	id serial PRIMARY KEY,
	type_id	smallint,
	producer_id	smallint,
	image	varchar(50),
	dimensions	varchar(50),
	description	varchar(1000),
	characteristic_1	float,
	characteristic_2	float,
	characteristic_3	varchar(50),
	characteristic_4	varchar(50),
	characteristic_5	varchar(50),
	characteristic_6	varchar(50),
	Availability	nchar(3),
	FOREIGN KEY (producer_id) REFERENCES PRODUCER(producer_id),
	FOREIGN KEY (type_id) REFERENCES CHARACTERISTICS(type_id)
);

CREATE TABLE CHARACTERISTICS (
  	type_id	smallint PRIMARY KEY,
  	type_name	varchar(50),
	characteristic_1 float,
	characteristic_2 float,
	characteristic_3 varchar(50),
	characteristic_4 varchar(50),
	characteristic_5 varchar(50),
	characteristic_6 varchar(50)
);

CREATE TABLE ORDERS (
  	order_id serial,
	id smallint PRIMARY KEY,
	quantity int,
	cost float,
	FOREIGN KEY (order_id) REFERENCES TOTAL_ORDERS(order_id)
);


CREATE TABLE TOTAL_ORDERS (
  	order_id serial PRIMARY KEY,
	total_cost float,
	date_of_order timestamp,
	receiving_id smallint,
	customer_id smallint,
	FOREIGN KEY (customer_id) REFERENCES CUSTOMERS(customer_id),
	FOREIGN KEY (receiving_id) REFERENCES RECEIVE_T(receiving_id)
);


CREATE TABLE RECEIVE_T (
 	receiving_id smallint PRIMARY KEY,
	receiving_type varchar(15),
	date_of_receiving timestamp,
	express varchar(3),
	adress varchar(50)
);


CREATE TABLE CUSTOMERS (
  	customer_id	smallint PRIMARY KEY,
	login	varchar(50),
	pasword	varchar(50),
	FIO	varchar(1000)
);
