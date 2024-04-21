create table "ball" (
    id SERIAL PRIMARY KEY,
    inning_id INTEGER references "innings" (id) NOT NULL,
    striker INTEGER references "user" (id) NOT NULL,
    non_striker INTEGER references "user" (id) NOT NULL,
    bowler INTEGER references "user" (id) NOT NULL,
    wicket_keeper INTEGER references "user" (id) NOT NULL,
    is_valid BOOLEAN default TRUE,
    runs INTEGER NOT NULL,
    type VARCHAR(30) NOT NULL,
    ball_number INTEGER NOT NULL,
    batsman_run INTEGER NOT NULL,
    is_free_hit BOOLEAN DEFAULT FALSE,
    comment TEXT NULL,
    deleted_on timestamp,
    deleted_by VARCHAR(255),
    created_on timestamp default CURRENT_TIMESTAMP,
    updated_on timestamp default CURRENT_TIMESTAMP
);

CREATE TRIGGER ball_upd_timestamp
    BEFORE UPDATE
    ON "ball"
    FOR EACH ROW
    EXECUTE PROCEDURE upd_timestamp();