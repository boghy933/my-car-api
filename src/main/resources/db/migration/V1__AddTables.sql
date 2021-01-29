CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE users (
    id UUID DEFAULT uuid_generate_v4 (),
    username VARCHAR(50) NOT NULL,
    password VARCHAR(250) NOT NULL,
    email VARCHAR(30),
    phone VARCHAR(30),
    token VARCHAR(120),
    enabled BOOLEAN NOT NULL DEFAULT TRUE,
    PRIMARY KEY(id)
);

CREATE TABLE cars (
    id UUID NOT NULL PRIMARY KEY,
    userId UUID NOT NULL,
    plate VARCHAR(30) NOT NULL
);

CREATE TABLE telemetries (
    id UUID NOT NULL PRIMARY KEY,
    carId UUID NOT NULL,
    timestamp TIMESTAMP NOT NULL,
    batteryLevel integer,
    latitude FLOAT,
    longitude FLOAT
);