-- SQLite
CREATE TABLE users (
  username VARCHAR(50) PRIMARY KEY,
  password VARCHAR(64)
);

INSERT INTO users(username, password) VALUES("jona", "1234");

