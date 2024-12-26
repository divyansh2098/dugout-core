create table "dugout_config" (
  id SERIAL PRIMARY KEY,
  config JSON,
  name VARCHAR(255) not null,
  created_on timestamp default CURRENT_TIMESTAMP,
  updated_on timestamp default CURRENT_TIMESTAMP
)