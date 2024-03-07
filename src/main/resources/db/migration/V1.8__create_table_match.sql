create table "match" (
  id SERIAL PRIMARY KEY,
  toss_win INTEGER references "team" (id) NOT NULL,
  toss_decision VARCHAR (15) NOT NULL,
  name VARCHAR(255) NULL,
  ground_id INTEGER references "ground" (id) NULL,
  overs INTEGER NULL,
  city VARCHAR(255) NULL, -- Change to cityId eventually
  country VARCHAR(255) NULL, -- Change to countryId eventually
  match_date DATE NULL,
  status VARCHAR(10) NOT NULL,
  meta json NULL,
  winner INTEGER references "team" (id) NULL,
  team1_score json NULL,
  team2_score json NULL,
  created_on timestamp default CURRENT_TIMESTAMP,
  updated_on timestamp default CURRENT_TIMESTAMP
);

CREATE TRIGGER match_upd_timestamp
    BEFORE UPDATE
    ON "match"
    FOR EACH ROW
    EXECUTE PROCEDURE upd_timestamp();