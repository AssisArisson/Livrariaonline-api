create table livros(
    id bigint not null auto_increment,
    titulo varchar(100) not null,
    data date not null,
    qtdpagina int not null,
    primary key (id)
);