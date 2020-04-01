<h1>Sistema Blog Web</h1>

Backend: 
	- Java 8 (Springboot)
		- Lombok (encapsulamento)
	- Mysql (5.7) (docker-composer)
	- API Resfull 
	- Documentação da API com SWAGGER (Utilizando data tansfer object)

Frontend:
	- React.js
		- react-icons
		- react-dom
		- react-router-dom
	- Axios.js (consumir API Restfull)

	
<h2>Descrição - Backend</h2>

* API básica que disponibiliza endpoints para operações de CRUD entre Posts e Usuários

<h2>Descrição - FrontEnd</h2>

* Consumir a API restfull em Java 8 (Stringboot) através de autenticação JWT (<i>Desenvolvimento</i>) e guardando o estado da sessão para executar as funcionalidades do backend.

<h1>Funcionalidades</h1>

* Usuário / Autor:
	- Criar
	- Alterar
	- Excluir
	- Detalhes
	- Consulta Paginada (todos autores)

* Posts: 
	- Criar
	- Alterar
	- Excluir
	- Detalhes
	- Listar todos os Posts (paginado)
	- Listar todos os Posts do Autor (paginado)

##############

-- Primeiro acesso (tenha o docker-composer configurado em sua máquina)
-- Executar dentro da pasta `/backend` do projeto

`$ docker-compose up -d `

`$ sudo docker run --name=backend_bd_1 -d`
`$ sudo docker logs backend_bd_1`

-- Conectar 
`$ sudo docker exec -it backend_bd_1 mysql -uroot -p`

-- Parâmetros Default
Base de dados Mysql 5.7 (docker-compose.yml)
base: dbBlogWeb
usuario: root
senha: q1w2e3r4t5




