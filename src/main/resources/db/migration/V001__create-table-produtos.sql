create table produtos (
    id int not null auto_increment primary key ,
    nome varchar(255),
    preco decimal(19,2),
    validade date,
    categoria varchar(255)
);