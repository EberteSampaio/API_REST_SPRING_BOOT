create table medicos(

                        id bigint not null auto_increment,
                        name varchar(100) not null,
                        email varchar(100) not null unique,
                        crm varchar(6) not null unique,
                        specialty varchar(100) not null,
                        street_address varchar(100) not null,
                        neighborhood varchar(100) not null,
                        zip_code varchar(9) not null,
                        complement varchar(100),
                        house_number varchar(20),
                        uf char(2) not null,
                        city varchar(100) not null,

                        primary key(id)

);