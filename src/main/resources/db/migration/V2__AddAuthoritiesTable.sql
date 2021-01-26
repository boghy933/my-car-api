CREATE TABLE authorities (
  id UUID DEFAULT uuid_generate_v4 (),
  username VARCHAR(50) NOT NULL,
  authority VARCHAR(50) NOT NULL,
  PRIMARY KEY(id)
);