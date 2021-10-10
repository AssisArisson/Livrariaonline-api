create table livros(
    id bigint not null auto_increment,
    titulo varchar(100) not null,
    data_lancamento date not null,
    numero_paginas int not null,
    quantidade_livros int null,
    primary key (id)
);