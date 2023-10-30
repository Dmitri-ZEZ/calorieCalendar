create sequence meal_seq start with 1 increment by 50;
create sequence product_and_gramms_seq start with 1 increment by 50;
create sequence product_seq start with 1 increment by 50;
create sequence usr_seq start with 1 increment by 50;
create table meal
(
    meal_type smallint check (meal_type between 0 and 2),
    id        bigint not null,
    user_id   bigint,
    primary key (id)
);
create table meal_product_and_gramms_list
(
    meal_id                    bigint not null,
    product_and_gramms_list_id bigint not null unique
);
create table product
(
    calories integer,
    id       bigint not null,
    title    varchar(255),
    primary key (id)
);
create table product_and_gramms
(
    calories   integer,
    gramms     integer,
    id         bigint not null,
    product_id bigint,
    primary key (id)
);
create table usr
(
    id       bigint not null,
    login    varchar(255),
    password varchar(255),
    primary key (id)
);
create table usr_meals
(
    meals_id bigint not null unique,
    usr_id   bigint not null
);
alter table if exists meal add constraint FKek6lmelwvh78o86r3rabgc38d foreign key (user_id) references usr;
alter table if exists meal_product_and_gramms_list add constraint FK1fdwcykep0758noonkr6kcv3 foreign key (product_and_gramms_list_id) references product_and_gramms;
alter table if exists meal_product_and_gramms_list add constraint FKoc8y62tr23kgv9ol82b873rw6 foreign key (meal_id) references meal;
alter table if exists product_and_gramms add constraint FKba0hcbq9djewxhmtngb38ajv6 foreign key (product_id) references product;
alter table if exists usr_meals add constraint FKm0bpj6ibwmcgynujqdc9rsyr5 foreign key (meals_id) references meal;
alter table if exists usr_meals add constraint FK9eipyqhprj6pmrgk8yxugayii foreign key (usr_id) references usr;