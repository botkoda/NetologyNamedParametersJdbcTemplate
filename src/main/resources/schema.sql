DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS customers;

create table customers
(
  id           serial primary key,
  name         varchar(500),
  surname      varchar(500),
  age          varchar(500),
  phone_number varchar(500)
);

create table orders
(
  id           serial primary key,
  dates        DATE,
  product_name varchar(500),
  amount       varchar(500),
  customer_id  integer REFERENCES customers (id)

);