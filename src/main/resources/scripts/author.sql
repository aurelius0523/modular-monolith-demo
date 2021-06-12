CREATE SCHEMA IF NOT EXISTS author;

DROP TABLE IF EXISTS author.author;
CREATE TABLE author.author
(
    id   INT auto_increment primary key,
    name varchar NOT NULL
);

INSERT INTO author.author(name)
values ('Brandon Sanderson');

INSERT INTO author.author(name)
values ('Robert Kiyosaki');

