<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>A46</title>
<!--  Favicon -->
<link rel="icon" href="img/favicon.png">

<!-- Font Awesome  -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">

<!-- CSS  -->
<link rel="stylesheet" href="css/formstyle.css">

</head>
<body>
	<!-- Header -->

	<header>

		<div id="menu-bar" class="fas fa-bars"></div>

		<a href="index.html" class="logo">A<span>46</span></a>

		<nav class="navbar">
			<a href="index.html">Home</a>
			<a href="main" class="btn">Voltar ao Gerenciamento de Destinos</a>
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
	<div class="main-title">
		<h1 class="title-primary">Adicionar um Destino</h1>
	</div>
	<div class="form">
		<form name="frmDestino" action="update">
			<table>
				<tr>
					<td>Id: <input type="text" name="id_dest" id="input_id"
						readonly value="<%out.print(request.getAttribute("id_dest"));%>"></td>
				</tr>
				<tr>
					<td>Nome: <input type="text" name="name" placeholder="Nome"
						class="input" value="<%out.print(request.getAttribute("name"));%>"></td>
				</tr>
				<tr>
					<td>Descri??o: <input type="text" name="description"
						placeholder="Descri??o" class="input"
						value="<%out.print(request.getAttribute("description"));%>"></td>
				</tr>
				<tr>
					<td>Valor: <input type="text" name="price" placeholder="Valor"
						class="input" value="<%out.print(request.getAttribute("price"));%>">
					</td>
				</tr>
				<tr>
					<td>Imagem: <input type="file" name="image" class="input"
						value="<%out.print(request.getAttribute("image"));%>">
				</tr>
			</table>
			<div class="btnn">
				<input type="button" value="Salvar" class="btn"
					onclick="validar()">
			</div>

		</form>

	</div>

	<script src="scripts/validador.js"></script>
</body>
</html>