CREATE TABLE IF NOT EXISTS product ( -- Создание таблицы "product", если она не существует
    id BIGSERIAL PRIMARY KEY, -- Поле "id" типа BIGSERIAL (автоматически инкрементируемый) и первичный ключ
    name VARCHAR(255), -- Поле "name" типа VARCHAR с максимальной длиной 255 символов
    description VARCHAR(255), -- Поле "description" типа VARCHAR с максимальной длиной 255 символов
    price FLOAT NOT NULL, -- Поле "price" типа FLOAT, не может содержать значение NULL
    quantity INTEGER NOT NULL, -- Поле "quantity" типа INTEGER, не может содержать значение NULL
    RESERVED_QUANTITY INTEGER DEFAULT 0 -- Поле "RESERVED_QUANTITY" типа INTEGER со значением по умолчанию 0
);

CREATE TABLE IF NOT EXISTS competition (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255),
    start_date DATE,
    end_date DATE,
    location VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS judge (
    id BIGSERIAL PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    specialization VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS participant (
    id BIGSERIAL PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    age INTEGER,
    gender VARCHAR(10),
    country VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS protocol (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255),
    competition_id BIGINT REFERENCES competition(id),
    judge_id BIGINT REFERENCES judge(id),
    participant_id BIGINT REFERENCES participant(id),
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    score FLOAT
);

CREATE TABLE IF NOT EXISTS score (
    id BIGSERIAL PRIMARY KEY,
    comment VARCHAR(1000),
    judge_id INT,
    competition_id INT,
    participant_id BIGINT REFERENCES participant(id),
    total_score FLOAT,
    technical_score FLOAT,
    artistic_score FLOAT,
    risk_score FLOAT
);

CREATE TABLE IF NOT EXISTS secretary (
    id BIGSERIAL PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    position VARCHAR(255)
    email VARCHAR(255)
);
