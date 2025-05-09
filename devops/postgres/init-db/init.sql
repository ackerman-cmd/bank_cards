DROP TABLE IF EXISTS cards;
DROP TABLE IF EXISTS users;

-- Таблица пользователей
CREATE TABLE users (
                       id SERIAL PRIMARY KEY,
                       user_name VARCHAR(255) NOT NULL,
                       password_hash VARCHAR(255) NOT NULL,
                       role VARCHAR(50),
                       email VARCHAR(255) NOT NULL UNIQUE
);

-- Таблица карт
CREATE TABLE cards (
                       id SERIAL PRIMARY KEY,
                       card_number VARCHAR(255),
                       start_time DATE,
                       end_time DATE,
                       card_status VARCHAR(50),
                       balance NUMERIC(15, 2),

                       user_id BIGINT NOT NULL,
                       CONSTRAINT fk_card_user FOREIGN KEY (user_id)
                           REFERENCES users(id) ON DELETE CASCADE
);
