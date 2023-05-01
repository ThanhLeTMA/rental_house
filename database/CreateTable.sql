use
rental_house;

CREATE TABLE user
(
    id       bigint       NOT NULL PRIMARY KEY auto_increment,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    role     VARCHAR(255) NOT NULL
);

CREATE TABLE room
(
    id             bigint       NOT NULL PRIMARY KEY auto_increment,
    house_id       bigint       NOT NULL,
    floor          int          NOT NULL,
    area           VARCHAR(255) NOT NULL,
    currenttenants int          NOT NULL,
    currentmax     int          NOT NULL,
    status         int          NOT NULL,
    service_id     bigint       NOT NULL,
    rents          VARCHAR(255) NOT NULL,
    description    VARCHAR(255) NULL,
    createddate    TIMESTAMP NULL,
    modifieddate   TIMESTAMP NULL,
    createdby      VARCHAR(255) NULL,
    modifiedby     VARCHAR(255) NULL
);

CREATE TABLE service
(
    id   bigint       NOT NULL PRIMARY KEY auto_increment,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE tenant
(
    id           bigint       NOT NULL PRIMARY KEY auto_increment,
    name         VARCHAR(255) NOT NULL,
    birthdate    date NULL,
    gender       int          NOT NULL,
    phone        bigint       NOT NULL,
    email        VARCHAR(255) NOT NULL,
    idnumber     int          NOT NULL,
    address      VARCHAR(255) NOT NULL,
    house_id     bigint       NOT NULL,
    room_id      bigint       NOT NULL,
    rentdate     date NULL,
    status       int          NOT NULL,
    description  VARCHAR(255) NULL,
    createddate  TIMESTAMP NULL,
    modifieddate TIMESTAMP NULL,
    createdby    VARCHAR(255) NULL,
    modifiedby   VARCHAR(255) NULL
);

CREATE TABLE employee
(
    id           bigint       NOT NULL PRIMARY KEY auto_increment,
    name         VARCHAR(255) NOT NULL,
    birthdate    date NULL,
    gender       int          NOT NULL,
    phone        bigint       NOT NULL,
    email        VARCHAR(255) NOT NULL,
    idnumber     int          NOT NULL,
    house_id     bigint       NOT NULL,
    position     int          NOT NULL,
    account_id   bigint       NOT NULL,
    startdate    date NULL,
    status       int          NOT NULL,
    description  VARCHAR(255) NULL,
    createddate  TIMESTAMP NULL,
    modifieddate TIMESTAMP NULL,
    createdby    VARCHAR(255) NULL,
    modifiedby   VARCHAR(255) NULL
);

CREATE TABLE account
(
    id         bigint       NOT NULL PRIMARY KEY auto_increment,
    username   VARCHAR(255) NOT NULL,
    password   VARCHAR(255) NOT NULL,
    repassword VARCHAR(255) NOT NULL,
    role_id    bigint       NOT NULL
);

CREATE TABLE role
(
    id           bigint       NOT NULL PRIMARY KEY auto_increment,
    name         VARCHAR(255) NOT NULL,
    createddate  TIMESTAMP NULL,
    modifieddate TIMESTAMP NULL,
    createdby    VARCHAR(255) NULL,
    modifiedby   VARCHAR(255) NULL
);

CREATE TABLE invoice
(
    id               bigint       NOT NULL PRIMARY KEY auto_increment,
    house_id         bigint       NOT NULL,
    room_id          bigint       NOT NULL,
    paymentmethod_id bigint       NOT NULL,
    tenant_id        bigint       NOT NULL,
    phone            bigint       NOT NULL,
    email            VARCHAR(255) NOT NULL,
    creator          VARCHAR(255) NULL,
    createddate      DATE NULL,
    closingdate      DATE NULL,
    modifieddate     TIMESTAMP NULL,
    createdby        VARCHAR(255) NULL,
    modifiedby       VARCHAR(255) NULL
);

CREATE TABLE paymentmethod
(
    id           bigint       NOT NULL PRIMARY KEY auto_increment,
    name         VARCHAR(255) NOT NULL,
    type         VARCHAR(255) NOT NULL,
    createddate  TIMESTAMP NULL,
    modifieddate TIMESTAMP NULL,
    createdby    VARCHAR(255) NULL,
    modifiedby   VARCHAR(255) NULL
);

CREATE TABLE house
(
    id            bigint       NOT NULL PRIMARY KEY auto_increment,
    name          VARCHAR(255) NOT NULL,
    location      VARCHAR(255) NOT NULL,
    street        VARCHAR(255) NOT NULL,
    establishdate DATE NULL,
    totalroom     int          NOT NULL,
    manager       VARCHAR(255) NOT NULL,
    status        int          NOT NULL,
    createddate   TIMESTAMP NULL,
    modifieddate  TIMESTAMP NULL,
    createdby     VARCHAR(255) NULL,
    modifiedby    VARCHAR(255) NULL
);


