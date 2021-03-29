--DROP TABLE person IF EXISTS;

CREATE TABLE person (
  id BIGINT NOT NULL,
  email VARCHAR(255),
  first_name  VARCHAR(255),
  joined_date DATE,
  last_name VARCHAR (255),
  PRIMARY KEY (id)
);