<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<h2>Aula</h2>
<div class="container">
<form action="./escola" method="post"> 

<div class="row">
	<div class="col-sm-6">
	<label for="data">Data:</label>
	<input type="date" id="data" name="data">
	</div>
	<label for="hora">Hora:</label>
	<input type="time" id="hora" name="hora">


</div>
<div class="row">
<div class="col-sm-5">
	<label for="codAluno">Código do Aluno:</label>
	<input type="text" id="codAluno" name="codAluno">
</div>
<label for="codProfessor">Código do Professor:</label>
<input type="text" id="codProfessor" name="codProfessor">



</div>
<div class="row">
<div class="col-sm-4"><label for="instrumento">Instrumento:</label>
<select id="instrumento"  name="instrumento">
        				<option value="1">Guitarra</option>
        				<option value="2">Baixo Elétrico</option>
        				<option value="3">Violão Popular</option>
        				<option value="4">Violão Clássico</option>
        				<option value="5">Piano</option>
        				<option value="6">Bateria</option>
        				<option value="7">Canto</option>
        			</select> </div>

<label for="presenca">Presença:</label>
<select id="presenca" name="presenca">
	<option value="P">Presente</option>
	<option value="F">Falta</option>
</select>


</div>
<div class="row">

<label for="historico">Histórico</label>
<textarea rows="" cols="" id="historico" name="historico"></textarea>
</div>
<div class="row">
        	<div class="col-sm-3">
	        	<button class="btn btn-success" value="cadastroAgendaMusica" id="btn-novo" type="submit" name="acao">Novo</button>
	        </div>
	        	<button class="btn btn-success" name="cmd" value="alterar" type="submit">Alterar</button>
				<button class="btn btn-success" name="cmd" value="consultar" type="submit">Consultar</button>
				<button class="btn btn-danger" name="cmd" value="deletar" type="submit">Deletar</button>        
        </div>




</form>
</div>
	
	
	
	
</body>
</html>