# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table airline (
  id                            integer auto_increment not null,
  airline_name                  varchar(255),
  airportid                     integer not null,
  constraint pk_airline primary key (id)
);

create table airport (
  id                            integer auto_increment not null,
  name                          varchar(255),
  location                      varchar(255),
  constraint pk_airport primary key (id)
);

create table customer (
  c_id                          integer auto_increment not null,
  f_name                        varchar(255),
  l_name                        varchar(255),
  c_city                        varchar(255),
  flight_no                     integer,
  constraint pk_customer primary key (c_id)
);

create table flight (
  id                            integer auto_increment not null,
  airlineid                     integer not null,
  departure_time                datetime(6),
  arrival_time                  datetime(6),
  departure_city                varchar(255),
  arrival_city                  varchar(255),
  gate_id                       integer,
  constraint pk_flight primary key (id)
);

create table gate (
  gate_id                       integer auto_increment not null,
  terminal_id                   integer,
  airlineid                     integer not null,
  airport_id                    integer,
  constraint pk_gate primary key (gate_id)
);

create table purchase (
  purchase_id                   integer auto_increment not null,
  customer_id                   integer,
  flight_id                     integer,
  constraint pk_purchase primary key (purchase_id)
);

create table user_info (
  email                         varchar(255) not null,
  name                          varchar(255),
  password                      varchar(255),
  constraint pk_user_info primary key (email)
);

alter table airline add constraint fk_airline_airportid foreign key (airportid) references airport (id) on delete restrict on update restrict;
create index ix_airline_airportid on airline (airportid);

alter table flight add constraint fk_flight_airlineid foreign key (airlineid) references airline (id) on delete restrict on update restrict;
create index ix_flight_airlineid on flight (airlineid);

alter table gate add constraint fk_gate_airlineid foreign key (airlineid) references airline (id) on delete restrict on update restrict;
create index ix_gate_airlineid on gate (airlineid);


# --- !Downs

alter table airline drop foreign key fk_airline_airportid;
drop index ix_airline_airportid on airline;

alter table flight drop foreign key fk_flight_airlineid;
drop index ix_flight_airlineid on flight;

alter table gate drop foreign key fk_gate_airlineid;
drop index ix_gate_airlineid on gate;

drop table if exists airline;

drop table if exists airport;

drop table if exists customer;

drop table if exists flight;

drop table if exists gate;

drop table if exists purchase;

drop table if exists user_info;

