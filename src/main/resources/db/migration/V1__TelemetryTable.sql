CREATE TABLE telemetry (
    id UUID NOT NULL PRIMARY KEY,
    carId UUID NOT NULL,
    timestamp TIMESTAMP NOT NULL,
    batteryLevel integer,
    latitude FLOAT,
    longitude FLOAT
);