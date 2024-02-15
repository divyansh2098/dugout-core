create table "user"(
    id SERIAL PRIMARY KEY,
    firstname VARCHAR(255) NULL,
    lastname VARCHAR(255) NULL,
    username VARCHAR(255) NULL UNIQUE,
    email VARCHAR(255) NULL UNIQUE,
    phone VARCHAR(255) NULL UNIQUE,
    gender VARCHAR(16) NULL,
    date_of_birth VARCHAR(255) NULL,
    country VARCHAR(255) NULL,
    city VARCHAR(255) NULL,
    specialisation VARCHAR(255) NULL,
    batting_style VARCHAR(255) NULL,
    bowling_style VARCHAR(255) NULL,
    created_on timestamp default current_timestamp,
    updated_on timestamp default current_timestamp
);

CREATE INDEX idx_user_lower_concat_firstname_lastname ON "user" (lower((firstname || ' ' || lastname)));

CREATE OR REPLACE FUNCTION upd_timestamp() RETURNS TRIGGER
LANGUAGE plpgsql
AS $$
BEGIN
    NEW.updated_on = CURRENT_TIMESTAMP;
RETURN NEW;
END;
$$;

CREATE TRIGGER user_upd_timestamp
    BEFORE UPDATE
    ON "user"
    FOR EACH ROW
    EXECUTE PROCEDURE upd_timestamp();