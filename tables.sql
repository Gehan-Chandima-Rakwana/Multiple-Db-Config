--Postgres Tables
CREATE SEQUENCE  IF NOT EXISTS m_member_details_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE  IF NOT EXISTS r_status_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE m_member_details (
  member_id INTEGER NOT NULL,
   member_code VARCHAR(10) NOT NULL,
   contact_number VARCHAR(15),
   date_of_birth date,
   date_of_join date,
   name_with_initials VARCHAR(200),
   first_name VARCHAR(100),
   middle_name VARCHAR(100),
   last_name VARCHAR(100),
   gender VARCHAR(10),
   identity_no VARCHAR(20),
   is_active BOOLEAN,
   email VARCHAR(100),
   status_id INTEGER NOT NULL,
   CONSTRAINT pk_m_member_details PRIMARY KEY (member_id)
);

CREATE TABLE ld_r_status (
  status_id INTEGER NOT NULL,
   status_code VARCHAR(10) NOT NULL,
   description VARCHAR(150),
   is_active BOOLEAN,
   CONSTRAINT pk_ld_r_status PRIMARY KEY (status_id)
);

ALTER TABLE m_member_details ADD CONSTRAINT FK_M_MEMBER_DETAILS_ON_STATUS FOREIGN KEY (status_id) REFERENCES ld_r_status (status_id);

CREATE INDEX M_MEMBER_DETAILS_LD_R_STATUS1_idx ON m_member_details(status_id);




--MySql

CREATE TABLE user_details (
  user_id INT NOT NULL,
   user_code VARCHAR(10) NOT NULL,
   contact_number VARCHAR(15) NULL,
   date_of_birth date NULL,
   date_of_join date NULL,
   name_with_initials VARCHAR(200) NULL,
   first_name VARCHAR(100) NULL,
   middle_name VARCHAR(100) NULL,
   last_name VARCHAR(100) NULL,
   gender VARCHAR(10) NULL,
   identity_no VARCHAR(20) NULL,
   is_active BIT(1) NULL,
   email VARCHAR(100) NULL,
   CONSTRAINT pk_user_details PRIMARY KEY (user_id)
);


