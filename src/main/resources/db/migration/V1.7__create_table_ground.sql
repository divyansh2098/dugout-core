create table ground (
  id SERIAL PRIMARY KEY,
  lat VARCHAR(20) NULL,
  lon VARCHAR(20) NULL,
  address VARCHAR(500) NULL,
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

CREATE TRIGGER ground_upd_timestamp
    BEFORE UPDATE
    ON "ground"
    FOR EACH ROW
    EXECUTE PROCEDURE upd_timestamp();