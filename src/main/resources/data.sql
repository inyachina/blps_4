CREATE TABLE IF NOT EXISTS Category
(
    id   SERIAL PRIMARY KEY,
    name TEXT UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS Essay
(
    id          SERIAL PRIMARY KEY,
    category_id INTEGER REFERENCES category ON DELETE CASCADE ON UPDATE CASCADE NOT NULL,
    title       TEXT                                                            NOT NULL,
    content     TEXT                                                            NOT NULL,
    date_load   TIMESTAMP DEFAULT current_timestamp NOT NULL,
    status      TEXT      DEFAULT 'Awaiting verification' NOT NULL
);

CREATE TABLE IF NOT EXISTS Stats
(
    id                     SERIAL PRIMARY KEY,
    essayAmount            INTEGER                   NOT NULL,
    approvedEssayAmount    INTEGER                   NOT NULL,
    notApprovedEssayAmount INTEGER                   NOT NULL,
    waitingEssayAmount     INTEGER                   NOT NULL,
    date                   Date DEFAULT current_date NOT NULL
);

insert into category (name) values ('literature');
insert into category (name) values ('philosophy');
insert into category (name) values ('movies');
insert into category (name) values ('music');

insert into essay(category_id, title, content, status) VALUES (1, 'pupupu', 'ninininin', 'Approved');
insert into essay(category_id, title, content, status) VALUES (1, 'fesf', 'ninininin', 'Approved');
insert into essay(category_id, title, content) VALUES (1, 'nnunun', 'ninininin');
insert into essay(category_id, title, content) VALUES (3, 'lallaa', 'nasdasdnin');
insert into essay(category_id, title, content) VALUES (2, 'pupupu', 'ninininin');
insert into essay(category_id, title, content) VALUES (1, 'nuwrrwe', 'ninininin');