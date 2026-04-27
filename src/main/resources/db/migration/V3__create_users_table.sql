CREATE TABLE users (
    id          BIGINT          NOT NULL AUTO_INCREMENT,
    email       VARCHAR(255)    NOT NULL UNIQUE,
    password    VARCHAR(255)    NOT NULL,
    name        VARCHAR(255)    NOT NULL,
    role        VARCHAR(50)     NOT NULL DEFAULT 'USER',
    created_at  DATETIME        DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);