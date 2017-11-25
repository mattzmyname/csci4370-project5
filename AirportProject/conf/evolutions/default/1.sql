# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table airport (
  id                            integer auto_increment not null,
  name                          varchar(255),
  location                      varchar(255),
  constraint pk_airport primary key (id)
);


# --- !Downs

drop table if exists airport;
