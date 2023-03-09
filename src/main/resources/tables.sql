CREATE TABLE Street
(
    street_code bigint primary key,
    title       varchar(255)
);

CREATE TABLE Personal_Accounts
(
    account_code   bigint,
    account_number bigint,
    street_code    bigint references Street (street_code),
    house          bigint,
    frame          bigint,
    apartment      int,
    full_name      varchar(255)
);

CREATE TABLE Services
(
    service_code bigint primary key,
    title        varchar(255),
    rate         varchar(255)
);

CREATE TABLE Accruals
(
    accrual_code bigint,
    account_code bigint,
    service_code bigint references Services(service_code),
    quantity     int
);