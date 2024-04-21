create table squad_player (
  id SERIAL PRIMARY KEY,
  team_id INTEGER references "team" (id) NOT NULL,
  match_id INTEGER references "match" (id) NOT NULL,
  player_id INTEGER references "user" (id) NOT NULL,
  created_on timestamp default CURRENT_TIMESTAMP,
  updated_on timestamp default CURRENT_TIMESTAMP
);

CREATE TRIGGER squad_player_upd_timestamp
    BEFORE UPDATE
    ON "squad_player"
    FOR EACH ROW
    EXECUTE PROCEDURE upd_timestamp();