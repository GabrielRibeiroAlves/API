# API

INSERIR PESSOA

http://localhost:8081/api/pessoa

{
"permissaoPessoas":
[
{"permissao":{"id":23}}
],
"nome": "joao",
"email" : "joao123@gmail.com",
"senha": 123
}

TROCAR NOME PESSOA

http://localhost:8081/api/categoria

{
"id":  ,
"nome": "gabriel",
"email" : "gabriel123@gmail.com",
"senha": 123
}   

INSERIR CATEGORIA

http://localhost:8081/api/categoria

{
"categoria":"usado"
}  

TROCAR CATEGORIA

http://localhost:8081/api/categoria

{
"id":  ,
"categoria":"usado"
}   

INSERIR MARCA

http://localhost:8081/api/marca

{
"marca":"uno"
}   

TROCAR MARCA
{
"id":  ,
"marca":"uno"
}  

INSERIR/ALTERAR CARRO


http://localhost:8081/api/carro

{
"marca":{"id":19},
"categoria":{"id":15},
"pessoa":{"id":14},
"modelo":"uno",
"ano": 2010,
"motor": 1.0,
"valor": 16.000
}  




RECUPERAR CODIGO SENHA

http://localhost:8081/api/pessoa-gerenciamento/recuperar-codigo

codigo enviado no email

{
"email":"email@gmail.com"
}

ALTERAR SENHA

http://localhost:8081/api/pessoa-gerenciamento/alterar-senha

codigo enviado no email

{
"email":"email",
"codigoRecuperacaoSenha":"241120221907000732",
"senha":"  "
}

FAZER LOGIN 

http://localhost:8081/api/pessoa-gerenciamento/login

{
"email":"email@gmail.com",
"senha":"  "
}

INSERIR PERMISAO

http://localhost:8081/api/permissao/

{
"permissao":"   ",
}

ALTERAR PERMISSAO 

http://localhost:8081/api/permissao/

TROCAR MARCA
{
"id":  ,
"permissao":"  "
}  

INSERIR USUARIO

http://localhost:8081/api/usuario/

{
"email":"email@gmail.com",
"senha":" "
}



    