<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>
<%
@SuppressWarnings("unchecked")
ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("destinos");
%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>A46 - Destinos</title>
<!--  Favicon -->
<link rel="icon" href="img/favicon.png">
<!-- CSS  -->
<link rel="stylesheet" href="css/formstyle.css">
</head>

<body>
	<!-- Header -->

	<header>

		<div id="menu-bar" class="fas fa-bars"></div>

		<a href="index.html" class="logo">A<span>46</span></a>

		<nav class="navbar">
			<a href="index.html">Voltar para Home</a>
		</nav>

		<div class="icons">
			<i class="fas fa-search" id="search-btn"></i> <i class="fas fa-user"
				id="login-btn"></i>
		</div>

		<form action="" class="search-bar-container">
			<input type="search" id="search-bar" placeholder="Pesquisar...">
			<label for="search-bar" class="fas fa-search"></label>
		</form>

	</header>

	<!-- Fim Header -->
	
	<!--  Lista de Destinos do DB -->
	<div class="main-title">
		<h1 class="title-secondary">Nossos Destinos</h1>
	</div>
	<div class="dest">
		<a href="saidadestinos.html" class="btn">Adicionar Destino</a>
	</div>
	
	<table id="tabela">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Descrição</th>
				<th>Valor</th>
				<th>Imagem</th>
				<th>Editar / Excluir</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (int i = 0; i < lista.size(); i++) {
			%>
			<tr>
				<td><%=lista.get(i).getId_dest()%></td>
				<td><%=lista.get(i).getNome()%></td>
				<td><%=lista.get(i).getDescricao()%></td>
				<td><%=lista.get(i).getValor()%></td>
				<td><%=lista.get(i).getImage()%></td>
				<td><a
					href="select?Id_dest=<%=lista.get(i).getId_dest()%>"
					class="btn-edit">Editar</a> <a
					href="javascript: confirmar(<%=lista.get(i).getId_dest()%>)"
					class="btn-delete">Excluir</a></td>

			</tr>
			<%
			}
			%>

		</tbody>
	</table>
	
	
	<script src="scripts/confirmador.js"></script>
</body>
</html>