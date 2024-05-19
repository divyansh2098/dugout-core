create table "batsman_view" (
    id SERIAL PRIMARY KEY,
    inning_id INTEGER references "innings" (id) NOT NULL,
    player_id INTEGER references "user" (id) NOT NULL,
    wicket_id INTEGER references "wicket" (id),
    runs INTEGER DEFAULT 0,
    num_balls INTEGER DEFAULT 0,
    fours INTEGER DEFAULT 0,
    sixes INTEGER DEFAULT 0,
    status VARCHAR(10) NOT NULL DEFAULT 'UPCOMING',
    is_striker BOOLEAN,
    start_time timestamp,
    end_time timestamp,
    created_on timestamp default CURRENT_TIMESTAMP,
    updated_on timestamp default CURRENT_TIMESTAMP
);

CREATE TRIGGER batsman_view_upd_timestamp
    BEFORE UPDATE
    ON "batsman_view"
    FOR EACH ROW
    EXECUTE PROCEDURE upd_timestamp();