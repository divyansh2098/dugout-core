create table "innings" (
  id SERIAL PRIMARY KEY,
  match_id INTEGER references "match" (id) NOT NULL,
  team_id INTEGER references "team" (id) NOT NULL,
  inning_number INTEGER NOT NULL,
  start_time timestamp default CURRENT_TIMESTAMP,
  end_time timestamp default CURRENT_TIMESTAMP,
  status VARCHAR(30) NOT NULL,
  score_agg TEXT NULL,
  created_on timestamp default CURRENT_TIMESTAMP,
  updated_on timestamp default CURRENT_TIMESTAMP
);

CREATE TRIGGER match_upd_timestamp
    BEFORE UPDATE
    ON "innings"
    FOR EACH ROW
    EXECUTE PROCEDURE upd_timestamp();