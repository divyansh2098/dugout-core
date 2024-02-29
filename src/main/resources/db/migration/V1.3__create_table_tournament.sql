create table "tournament" (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NULL,
  city VARCHAR(255) NULL,
  country VARCHAR(255) NULL,
  created_on timestamp default current_timestamp,
  updated_on timestamp default current_timestamp
);

CREATE OR REPLACE FUNCTION upd_timestamp() RETURNS TRIGGER
LANGUAGE plpgsql
AS $$
BEGIN
    NEW.updated_on = CURRENT_TIMESTAMP;
RETURN NEW;
END;
$$;

CREATE TRIGGER tournament_upd_timestamp
    BEFORE UPDATE
    ON "tournament"
    FOR EACH ROW
    EXECUTE PROCEDURE upd_timestamp();