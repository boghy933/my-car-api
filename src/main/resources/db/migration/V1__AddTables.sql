CREATE TABLE users (
    id UUID NOT NULL PRIMARY KEY,
    username VARCHAR(30) NOT NULL,
    password VARCHAR(250) NOT NULL,
    email VARCHAR(30) NOT NULL,
    phone VARCHAR(30) NOT NULL,
    token VARCHAR(120) NOT NULL
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