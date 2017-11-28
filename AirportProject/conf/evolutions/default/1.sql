
# --- !Ups

create table airline (
  id                            integer auto_increment not null,
  airline_name                  varchar(255),
  airport_id                    integer,
  constraint pk_airline primary key (id),
  constraint fk_airport_id foreign key (airport_id) references airport(id)
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
  constraint pk_flight primary key (id),
  constraint fk_airline_id foreign key (airline_id) references airline(id),
  constraint fk_gate_id foreign key (gate_id) references gate(gate_id)
);

create table gate (
  gate_id                       integer auto_increment not null,
  terminal_id                   integer,
  airline_id                    integer,
  airport_id                    integer,
  constraint pk_gate primary key (gate_id),
  constraint fk_airport_id foreign key (airport_id) references airport(id),
  constraint fk_airline_id foreign key (airline_id) references airline(id)
);

create table purchase (
  purchase_id                   integer auto_increment not null,
  customer_id                   integer,
  flight_id                     integer,
  constraint pk_purchase primary key (purchase_id),
  constraint fk_flight_id foreign key (flight_id) references flight(id),
  constraint fk_customer_id foreign key (customer_id) references customer(cId)
);


# --- !Downs

drop table if exists airline;

drop table if exists airport;

drop table if exists customer;

drop table if exists flight;

drop table if exists gate;

drop table if exists purchase;

