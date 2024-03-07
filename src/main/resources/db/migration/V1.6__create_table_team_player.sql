create table team_player (
  id SERIAL PRIMARY KEY,
  user_id INTEGER references "user" (id),
  team_id INTEGER references "team" (id),
  team_role VARCHAR(255) NULL,
  created_on timestamp default CURRENT_TIMESTAMP,
  updated_on timestamp default CURRENT_TIMESTAMP
);

CREATE TRIGGER team_player_upd_timestamp
    BEFORE UPDATE
    ON "team_player"
    FOR EACH ROW
    EXECUTE PROCEDURE upd_timestamp();