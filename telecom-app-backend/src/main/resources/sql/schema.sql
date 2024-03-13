create database telecom;

use telecom;

drop table `user`;

CREATE TABLE user (
    user_id VARCHAR(255) PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255),
    mobile_number VARCHAR(255),
    pwd VARCHAR(255),
    role VARCHAR(255),
    createdAt DATETIME,
    createdBy VARCHAR(255),
    updatedAt DATETIME,
    updatedBy VARCHAR(255)
);

CREATE TABLE call_details (
    call_details_id VARCHAR(255) PRIMARY KEY,
    customer_email VARCHAR(255),
    support_ticket_id BIGINT,
    wav_file_id VARCHAR(255),
    createdAt DATETIME,
    createdBy VARCHAR(255),
    updatedAt DATETIME,
    updatedBy VARCHAR(255)
);
