CREATE TABLE Category
(
    id   SERIAL PRIMARY KEY,
    name TEXT NOT NULL
);

CREATE TABLE Essay
(
    id        SERIAL PRIMARY KEY,
    category_id  INTEGER REFERENCES category ON DELETE CASCADE ON UPDATE CASCADE NOT NULL,
    content   TEXT      DEFAULT NULL,
    date_load TIMESTAMP DEFAULT current_timestamp,
    status    TEXT      DEFAULT 'Ожидает проверки'
);