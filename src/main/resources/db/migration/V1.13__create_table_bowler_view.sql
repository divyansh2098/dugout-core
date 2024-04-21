create table "bowler_view" (
    id SERIAL PRIMARY KEY,
    inning_id INTEGER references "innings" (id) NOT NULL,
    player_id INTEGER references "user" (id) NOT NULL,
    runs INTEGER DEFAULT 0,
    num_balls INTEGER DEFAULT 0,
    fours INTEGER DEFAULT 0,
    sixes INTEGER DEFAULT 0,
    status VARCHAR(10) NOT NULL DEFAULT 'NOT_BOWLING',
    wickets INTEGER DEFAULT 0,
    created_on timestamp default CURRENT_TIMESTAMP,
    updated_on timestamp default CURRENT_TIMESTAMP
);

CREATE TRIGGER bowler_view_upd_timestamp
    BEFORE UPDATE
    ON "bowler_view"
    FOR EACH ROW
    EXECUTE PROCEDURE upd_timestamp();