CREATE SEQUENCE sw_schema.user_id_seq MINVALUE 1 START 1;
CREATE SEQUENCE sw_schema.user_stocks_id_seq MINVALUE 1 START 1;


CREATE TABLE sw_schema.user
(
    id          BIGINT DEFAULT nextval('sw_schema.user_id_seq') PRIMARY KEY,
    username    VARCHAR(255) UNIQUE NOT NULL,
    password    VARCHAR(255),
    user_status VARCHAR(255)        NOT NULL
);

CREATE TABLE sw_schema.user_stocks
(
    id           BIGINT DEFAULT nextval('sw_schema.user_stocks_id_seq') PRIMARY KEY,
    user_id      BIGINT REFERENCES sw_schema.user (id),
    symbol       VARCHAR(255)  NOT NULL,
    company_name VARCHAR(1000) NOT NULL,

    UNIQUE (user_id, symbol)
);
