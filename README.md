# MyRestaurant Demo

## STEPS
* 1. This is a Spring boot application. Please Run "RestaurantApplication.java"
* 2. Goto localhost:8080/home --> Click on "Click To Start Ordering" Button to get the list/Menu from DB.
* 3. Enter the quantity of each item and click "Add To Cart".
* 4. Once done enter your details and click "Place Order". To get confirmation number.
* 5. Click Clear cart to do a fresh order.  

## SQL Statements to create tables
create table tbl_items (item_id int not null, item_name VARCHAR(255) not null, item_description VARCHAR(255) not null, item_price double precision not null);
alter table tbl_items add primary key(item_id);

create table tbl_orders (order_number INT not null, amount double precision not null,
customer_address VARCHAR(255) not null,
customer_name VARCHAR(255) not null,
customer_phone VARCHAR(128) not null);

alter table tbl_orders add primary key (order_number);
alter table tbl_orders add constraint order_uk unique (order_number);

create table order_details (id int not null,
quantity INT not null, order_number int not null, item_id int not null);

alter table order_details add primary key (ID);
alter table order_details add constraint ORDER_DETAIL_ORD_FK foreign key (order_number)
references tbl_orders (order_number);
alter table order_details add constraint ORDER_DETAIL_PROD_FK foreign key (item_id)
references tbl_items (item_id);

