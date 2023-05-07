alter table medicos DROP column ativo;
ALTER TABLE medicos add ativo bool DEFAULT TRUE;