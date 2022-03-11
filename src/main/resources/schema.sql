DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS customers;

create table customers
(
  id           serial primary key,
  name         varchar(100),
  surname      varchar(100),
  age          integer,
  phone_number varchar(11)
);

create table orders
(
  id           serial primary key,
  dates        DATE,
  product_name varchar(500),
  amount       integer,
  customer_id  integer REFERENCES customers (id)

);