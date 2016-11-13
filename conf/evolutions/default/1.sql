# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table user_master (
  user_id                       varchar(255) not null,
  user_name                     varchar(255),
  password                      varchar(255),
  regist_time                   datetime(6) not null,
  update_time                   datetime(6) not null,
  constraint pk_user_master primary key (user_id)
);

create table item (
  id                            bigint auto_increment not null,
  title                         varchar(255),
  detail                        varchar(255),
  money                         integer,
  image_url                     varchar(255),
  constraint pk_item primary key (id)
);


# --- !Downs

drop table if exists user_master;

drop table if exists item;

