create table squad_player (
  id SERIAL PRIMARY KEY,
  team_id INTEGER references "team" (id) NOT NULL,
  match_id INTEGER references "match" (id) NOT NULL,
  player_id INTEGER references "user" (id) NOT NULL
)