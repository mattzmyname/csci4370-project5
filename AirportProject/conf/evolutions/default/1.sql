# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table airline (
  id                            integer auto_increment not null,
  airline_name                  varchar(255),
  airport_id                    integer,
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
  airline_id                    integer,
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
  airline_id                    integer,
  airport_id                    integer,
  constraint pk_gate primary key (gate_id)
);


# --- !Downs

drop table if exists airline;

drop table if exists airport;

drop table if exists customer;

drop table if exists flight;

drop table if exists gate;

