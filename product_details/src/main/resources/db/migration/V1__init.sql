CREATE TABLE categories
(
    id   INT AUTO_INCREMENT NOT NULL,
    name VARCHAR(255) NULL,
    CONSTRAINT pk_categories PRIMARY KEY (id)
);

CREATE TABLE jt_instructor
(
    id             INT NOT NULL,
    specialization VARCHAR(255) NULL,
    CONSTRAINT pk_jt_instructor PRIMARY KEY (id)
);

CREATE TABLE jt_student
(
    id     INT NOT NULL,
    batch  VARCHAR(255) NULL,
    course VARCHAR(255) NULL,
    CONSTRAINT pk_jt_student PRIMARY KEY (id)
);

CREATE TABLE jt_user
(
    id       INT NOT NULL,
    name     VARCHAR(255) NULL,
    email    VARCHAR(255) NULL,
    password VARCHAR(255) NULL,
    CONSTRAINT pk_jt_user PRIMARY KEY (id)
);

CREATE TABLE msc_instructor
(
    id       INT AUTO_INCREMENT NOT NULL,
    position VARCHAR(255) NULL,
    name     VARCHAR(255) NULL,
    CONSTRAINT pk_msc_instructor PRIMARY KEY (id)
);

CREATE TABLE msc_student
(
    id    INT AUTO_INCREMENT NOT NULL,
    batch VARCHAR(255) NULL,
    CONSTRAINT pk_msc_student PRIMARY KEY (id)
);

CREATE TABLE products
(
    id            INT AUTO_INCREMENT NOT NULL,
    title         VARCHAR(500) NULL,
    `description` VARCHAR(1000) NULL,
    price DOUBLE NOT NULL,
    category_id   INT NULL,
    CONSTRAINT pk_products PRIMARY KEY (id)
);

CREATE TABLE st_user
(
    id             INT NOT NULL,
    dtype          VARCHAR(31) NULL,
    name           VARCHAR(255) NULL,
    email          VARCHAR(255) NULL,
    password       VARCHAR(255) NULL,
    specialization VARCHAR(255) NULL,
    batch          VARCHAR(255) NULL,
    course         VARCHAR(255) NULL,
    CONSTRAINT pk_st_user PRIMARY KEY (id)
);

CREATE TABLE tpc_instructor
(
    id             INT NOT NULL,
    name           VARCHAR(255) NULL,
    email          VARCHAR(255) NULL,
    password       VARCHAR(255) NULL,
    specialization VARCHAR(255) NULL,
    CONSTRAINT pk_tpc_instructor PRIMARY KEY (id)
);

CREATE TABLE tpc_student
(
    id       INT NOT NULL,
    name     VARCHAR(255) NULL,
    email    VARCHAR(255) NULL,
    password VARCHAR(255) NULL,
    batch    VARCHAR(255) NULL,
    course   VARCHAR(255) NULL,
    CONSTRAINT pk_tpc_student PRIMARY KEY (id)
);

CREATE TABLE tpc_user
(
    id       INT NOT NULL,
    name     VARCHAR(255) NULL,
    email    VARCHAR(255) NULL,
    password VARCHAR(255) NULL,
    CONSTRAINT pk_tpc_user PRIMARY KEY (id)
);

ALTER TABLE jt_instructor
    ADD CONSTRAINT FK_JT_INSTRUCTOR_ON_ID FOREIGN KEY (id) REFERENCES jt_user (id);

ALTER TABLE jt_student
    ADD CONSTRAINT FK_JT_STUDENT_ON_ID FOREIGN KEY (id) REFERENCES jt_user (id);

ALTER TABLE products
    ADD CONSTRAINT FK_PRODUCTS_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES categories (id);