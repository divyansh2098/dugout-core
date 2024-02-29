create table team_player (
  id SERIAL PRIMARY KEY,
  user_id INTEGER references "user" (id),
  team_id INTEGER references "team" (id),
  team_role VARCHAR(255) NULL
)