create table "wicket" (
    id SERIAL PRIMARY KEY,
    inning_id INTEGER references "innings" (id) NOT NULL,
    ball_id INTEGER references "ball" (id) NOT NULL,
    out_player_id INTEGER references "user" (id) NOT NULL,
    fielder_id INTEGER references "user" (id) NOT NULL,
    type VARCHAR(30) NOT NULL,
    created_on timestamp default CURRENT_TIMESTAMP,
    updated_on timestamp default CURRENT_TIMESTAMP
);

CREATE TRIGGER wicket_upd_timestamp
    BEFORE UPDATE
    ON "wicket"
    FOR EACH ROW
    EXECUTE PROCEDURE upd_timestamp();