CREATE TABLE user (
  id                 VARCHAR(50)  NOT NULL,
  username           VARCHAR(50)  NOT NULL,
  password           VARCHAR(100) NOT NULL,
  enabled            BOOL         NOT NULL,
  created_date       DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  last_modified_date DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
);

CREATE TABLE authority (
  id                 VARCHAR(50) NOT NULL,
  user_id            VARCHAR(50) NOT NULL,
  role               VARCHAR(50) NOT NULL,
  created_date       DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  last_modified_date DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  UNIQUE authority (user_id, role),
  PRIMARY KEY (user_id, role)
);

CREATE TABLE token (
  id                 VARCHAR(50) NOT NULL,
  user_id            VARCHAR(50) NOT NULL,
  created_date       DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  last_modified_date DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
);

INSERT INTO user (id, username, password, enabled)
VALUES ('user-id-1', 'uuau99999', '$2a$10$nJW9KYHgpI7ukX3WFTlpCOfHP4/Yl1fRdFBIAzfdP.zrMyug1Cmp2', 1);

INSERT INTO authority (id, user_id, role) VALUES ('authority-id-1', 'user-id-1', 'ROLE_ADMIN');