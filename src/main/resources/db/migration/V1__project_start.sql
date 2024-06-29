CREATE TABLE roles
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(20) UNIQUE NOT NULL
);

CREATE TABLE users
(
    id        SERIAL PRIMARY KEY,
    username  VARCHAR(50) UNIQUE  NOT NULL,
    password  VARCHAR(60)         NOT NULL,
    role_name VARCHAR(20) REFERENCES roles (name),
    email     VARCHAR(100) UNIQUE NOT NULL
);


CREATE TABLE jobs
(
    id          SERIAL PRIMARY KEY,
    title       VARCHAR(100) NOT NULL,
    description TEXT         NOT NULL,
    created_by  INTEGER REFERENCES users (id)
);

CREATE TABLE job_requirements
(
    id          SERIAL PRIMARY KEY,
    job_id      INTEGER REFERENCES jobs (id),
    requirement TEXT NOT NULL
);

CREATE TABLE application_status
(
    id     SERIAL PRIMARY KEY,
    status VARCHAR(20) UNIQUE NOT NULL
);

CREATE TABLE applications
(
    id         SERIAL PRIMARY KEY,
    user_id    INTEGER REFERENCES users (id),
    job_id     INTEGER REFERENCES jobs (id),
    status_id  INTEGER REFERENCES application_status (id),
    feedback   TEXT,
    applied_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE notification_types
(
    id   SERIAL PRIMARY KEY,
    type VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE notifications
(
    id      SERIAL PRIMARY KEY,
    user_id INTEGER REFERENCES users (id),
    job_id  INTEGER REFERENCES jobs (id),
    type_id INTEGER REFERENCES notification_types (id),
    message TEXT      NOT NULL,
    read    BOOLEAN   NOT NULL DEFAULT FALSE,
    sent_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO roles (name)
VALUES ('ADMIN'),
       ('CANDIDATE');

INSERT INTO notification_types (type)
VALUES ('EMAIL'),
       ('WHATSAPP');
