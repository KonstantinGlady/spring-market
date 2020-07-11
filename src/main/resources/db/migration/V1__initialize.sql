drop table if exists products cascade ;
create table if not exists products (id bigserial, title varchar(255), description varchar(5000), price int, primary key (id));
insert into products(title, description, price) values
('bread','white bread',330),
('water','clean water',100),
('wine','red wine', 500),
('salt', 'sea salt',200),
('sugar',' ', 330),
('ice cream',' ', 800),
('paper',' ', 290),
('cat',' ',1500),
('elephant',' ', 3000),
('car', ' ',6000),
('ladder',' ',4444),
('trousers',' ',7000),
('pants',' ', 4989),
('shirt', ' ',439),
('t-shirt',' ' ,456),
('tie',' ',300),
('ring',' ',8000),
('towel',' ',298),
('salad',' ',100),
('chicken',' ',230),
('pork',' ',426),
('cheese',' ',395);

