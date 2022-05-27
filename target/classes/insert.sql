insert  TABLE Category
(
    id   SERIAL PRIMARY KEY,
    name TEXT NOT NULL
);

CREATE TABLE Essay
(
    id        SERIAL PRIMARY KEY,
    author    INTEGER,
    content   TEXT      DEFAULT NULL,
    date_load TIMESTAMP DEFAULT current_timestamp,
    status    TEXT      DEFAULT 'Ожидает проверки'
);