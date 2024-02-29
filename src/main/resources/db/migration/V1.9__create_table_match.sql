create table 'match' (
  id SERIAL PRIMARY KEY
  squad_a INTEGER references "squad" ('id') NOT NULL,
  squad_b INTEGER references "squad" ('id') NOT NULL,
  toss_win INTEGER references "team" ('id') NOT NULL,
  toss_decision VARCHAR (15) NOT NULL,
  name VARCHAR(255) NULL,
  ground_id INTEGER references "ground" ('id') NULL,
  overs INTEGER NULL,
  city VARCHAR(255) NULL, -- Change to cityId eventually
  country VARCHAR(255) NULL, -- Change to countryId eventually
  match_date DATE NULL,
  status VARCHAR(10) NOT NULL,
  meta json NULL,
  winner INTEGER references "team" ('id') NULL,
  team1_score json NULL,
  team2_score json NULL,
)