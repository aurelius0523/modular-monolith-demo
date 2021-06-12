CREATE SCHEMA IF NOT EXISTS book;

CREATE SCHEMA IF NOT EXISTS author;

DROP TABLE IF EXISTS author.author;
CREATE TABLE author.author
(
    id   INT auto_increment primary key,
    name varchar NOT NULL
);

DROP TABLE IF EXISTS book.book;
CREATE TABLE book.book
(
    id        INT auto_increment primary key,
    name      varchar NOT NULL,
    author_id INT
);

INSERT INTO author.author(name)
values ('Brandon Sanderson');

INSERT INTO author.author(name)
values ('Robert Kiyosaki');

INSERT INTO book.book(name, author_id)
values ('The Final Empire', 1);

INSERT INTO book.book(name, author_id)
values ('The Well of Ascension', 1);

INSERT INTO book.book(name, author_id)
values ('Hero of Ages', 1);

INSERT INTO book.book(name, author_id)
values ('Rich Dad Poor Dad', 2);
