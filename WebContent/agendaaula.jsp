<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container">
<h2 class="text-center">Agendar Aula</h2>
	<form>
	
	<fieldset title="Data e Hora">
	<legend>Data e Hora</legend>
	
	<label for="data">Data:</label>
	<input type="date" id="data">
	
	<label for="hora">Hora:</label>
	<input type="time">
	
	</fieldset>
	<fieldset>
	<legend>Dados</legend>
	<div class="row">
	
	<div class="col-sm-6">
	<label for="professor">Código do Professor</label>
	<input type="text" id="codProfessor">
	</div>
	<div class="col-sm-6">
	<label for="aluno">Código do Aluno</label>
	<input type="text" id="codAluno" >
	</div>
	</div></fieldset>
	
	
	<label for="instrumento">Instrumento:</label>
	<select id="instrumento">
						<option value="1">Guitarra</option>
        				<option value="2">Baixo Elétrico</option>
        				<option value="3">Violão Popular</option>
        				<option value="4">Violão Clássico</option>
        				<option value="5">Piano</option>
        				<option value="6">Bateria</option>
        				<option value="7">Canto</option>
	</select>
	
	
	
	<div class="row">
	<label for="programacao">Programação:</label>
	<textarea rows="" cols="50" id="programacao"></textarea>
	</div>
	<br>
	<div class="row">
        	<div class="col-sm-3">
	        	<button class="btn btn-success" value="novo" id="btn-novo" type="submit">Novo</button>
	        </div>
	        	<button class="btn btn-success" name="cmd" value="alterar" type="submit">Alterar</button>
				<button class="btn btn-success" name="cmd" value="consultar" type="submit">Consultar</button>
				<button class="btn btn-danger" name="cmd" value="deletar" type="submit">Deletar</button>        
        </div>
	
	</form>
</div>
</body>
</html>