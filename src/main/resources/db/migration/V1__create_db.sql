CREATE TABLE Client(
id IDENTITY PRIMARY KEY,
name VARCHAR(200) NOT NULL CHECK(CHAR_LENGTH(name)>=3 )
);

CREATE TABLE Planet (
   id VARCHAR(50) NOT NULL PRIMARY KEY CHECK(regexp_like(id,'\b[A-Z0-9]+\b')),
   name VARCHAR(500) NOT NULL CHECK(CHAR_LENGTH(name) >= 1)
 );

CREATE TABLE Ticket(
id IDENTITY PRIMARY KEY,
created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
client_id BIGINT,
from_planet_id VARCHAR,
to_planet_id VARCHAR,
FOREIGN KEY (client_id) REFERENCES Client(id),
FOREIGN KEY (from_planet_id) REFERENCES Planet(id),
FOREIGN KEY (to_planet_id) REFERENCES Planet(id) 
);