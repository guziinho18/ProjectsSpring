create schema usuario;

use usuario;

drop table turma;
drop table aluno;

create table turma (
    id varchar(5) not null primary key,
    qtd_disciplinas int not null,
    qtd_prof int not null,
    media_turma int not null
);

create table aluno(
	ra varchar(20) not null primary key,
    semestre int(1) not null,
    curso varchar(50) not null,
    statuss varchar(50) not null,
    nome varchar(50) not null,
    sexo varchar(15) not null,
    endereco varchar(100) not null,
    nascimento date not null,
    fk_id_classe varchar(5) not null
);

create table uau_dados (
	aluno_ra varchar(20) not null,
    turma_id varchar(5) not null
);

alter table aluno add
constraint fk_id_classe foreign key (fk_id_classe)
references turma (id);

alter table uau_dados add
constraint aluno_ra foreign key (aluno_ra)
references aluno (ra);

alter table uau_dados add
constraint turma_id foreign key (turma_id)
references turma (id);

insert into turma values('20','5','5','6');
insert into turma values('21','5','5','6');

insert into aluno values('201607251','5','ads','matricurado','Zezinho','Homem','rua levers glevers','1998/12/20','20');
insert into aluno values('201607225','5','ads','matricurado','Zezinho2','Homem','rua levers glevers','1998/12/20','21');

