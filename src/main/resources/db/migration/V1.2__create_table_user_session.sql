create table "user_session"(
    id SERIAL PRIMARY KEY,
    user_id integer REFERENCES "user" (id),
    auth_token VARCHAR(255) NULL,
    device_id VARCHAR(255) NULL,
    device_model VARCHAR(255) NULL,
    device_ip VARCHAR(255) NULL,
    device_os VARCHAR(255) NULL,
    device_os_version VARCHAR(255) NULL,
    created_on timestamp default current_timestamp,
    updated_on timestamp default current_timestamp
);

CREATE INDEX idx_user_session_auth_token ON "user_session" (auth_token);
CREATE INDEX idx_user_session_device_id ON "user_session" (device_id);

CREATE TRIGGER user_session_upd_timestamp
    BEFORE UPDATE
    ON "user_session"
    FOR EACH ROW
    EXECUTE PROCEDURE upd_timestamp();