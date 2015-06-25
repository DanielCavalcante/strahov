#-- Created by Ebean DDL
#To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table livro (
  id                        bigint not null,
  isbn                      bigint,
  ano                       text,
  titulo                    text,
  autor                     text,
  editora                   text,
  genero                    text,
  observacao                text,
  xuxinha                   varchar(255),
  constraint pk_livro primary key (id))
;

create sequence livro_seq;




# --- !Downs

drop table if exists livro cascade;

drop sequence if exists livro_seq;

