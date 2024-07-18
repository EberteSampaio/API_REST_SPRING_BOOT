CREATE TABLE `pacientes`
(
    `id`             bigint       NOT NULL AUTO_INCREMENT,
    `name`           varchar(100) NOT NULL,
    `email`          varchar(100) NOT NULL,
    `phoneNumber`    varchar(13)  NOT NULL,
    `cpf`            varchar(11)  NOT NULL,
    `street_address` varchar(100) NOT NULL,
    `neighborhood`   varchar(100) NOT NULL,
    `zip_code`       varchar(9)   NOT NULL,
    `complement`     varchar(100) DEFAULT NULL,
    `house_number`   varchar(20)  DEFAULT NULL,
    `uf`             char(2)      NOT NULL,
    `city`           varchar(100) NOT NULL,

    PRIMARY KEY (`id`),
    UNIQUE KEY `email` (`email`),
    UNIQUE KEY `cpf` (`cpf`)
);