create table "tournament_team" (
  id SERIAL PRIMARY KEY,
  tournament_id INTEGER references "tournament" (id),
  team_id INTEGER references "team" (id)
  tournament_position INTEGER
)