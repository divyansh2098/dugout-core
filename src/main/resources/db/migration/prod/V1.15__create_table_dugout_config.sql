create table "dugout_config" (
  id SERIAL PRIMARY KEY,
  config JSON,
  created_on timestamp default CURRENT_TIMESTAMP,
  updated_on timestamp default CURRENT_TIMESTAMP
)