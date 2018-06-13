<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Conta Aula</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
<forrm>
	<h2>Aula do Dia:<select></select></h2>
	<hr>
		<fieldset>
	<div class="row">
		<label for="valorAula">Valor da Aula:</label>
		<input type="text" id="valorAula">
	</div>
	<div class="row">
		<label for="valorDesc" >Valor de Desconto:</label>
		<input type="text" id="valorDesc">
	</div>
	<div class="row">
		<label for="valorTotal">Valor Total:</label>
		<input type="text" id="valorTotal">
	
	</div></fieldset>
	<div class="row">
        	<div class="col-sm-3">
	        	<button class="btn btn-success" value="novo" id="btn-novo" type="submit">Novo</button>
	        </div>
	        	<button class="btn btn-success" name="cmd" value="alterar" type="submit">Alterar</button>
				<button class="btn btn-success" name="cmd" value="consultar" type="submit">Consultar</button>
				<button class="btn btn-danger" name="cmd" value="deletar" type="submit">Deletar</button>        
        </div>


</forrm>
	</div>
</body>
</html>