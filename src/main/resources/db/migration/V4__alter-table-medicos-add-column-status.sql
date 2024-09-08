alter table medicos add status tinyint;

update medicos set medicos.status = 1;