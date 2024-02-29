create table "team" (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  created_on timestamp default CURRENT_TIMESTAMP,
  updated_on timestamp default CURRENT_TIMESTAMP
);

CREATE OR REPLACE FUNCTION upd_timestamp() RETURNS TRIGGER
LANGUAGE plpgsql
AS $$
BEGIN
    NEW.updated_on = CURRENT_TIMESTAMP;
RETURN NEW;
END;
$$;

CREATE TRIGGER team_upd_timestamp
    BEFORE UPDATE
    ON "team"
    FOR EACH ROW
    EXECUTE PROCEDURE upd_timestamp();