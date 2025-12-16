create table products (
    id bigint not null auto_increment,
    nome varchar(50) not null,
    preco decimal(7,2) not null,
    marca varchar(50) not null,
    descricao varchar(300) not null,
    status enum ('ACTIVE','INACTIVE'),
    primary key (id)
);