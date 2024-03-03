create table ground (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  lat VARCHAR(20) NULL,
  lon VARCHAR(20) NULL,
  address VARCHAR(500) NULL,
  created_on timestamp default CURRENT_TIMESTAMP,
  updated_on timestamp default CURRENT_TIMESTAMP
);

CREATE TRIGGER ground_upd_timestamp
    BEFORE UPDATE
    ON "ground"
    FOR EACH ROW
    EXECUTE PROCEDURE upd_timestamp();