create table "tournament_team" (
  id SERIAL PRIMARY KEY,
  tournament_id INTEGER references "tournament" (id),
  team_id INTEGER references "team" (id),
  tournament_position INTEGER,
  created_on timestamp default CURRENT_TIMESTAMP,
  updated_on timestamp default CURRENT_TIMESTAMP
);

CREATE TRIGGER tournament_team_upd_timestamp
    BEFORE UPDATE
    ON "tournament_team"
    FOR EACH ROW
    EXECUTE PROCEDURE upd_timestamp();