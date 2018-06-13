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
	<div class="container">
	
		<h2 class="text-center">Alunos</h2>
		<form>
			<div class="form-group">
				<label for="nomeCompleto">Nome Completo:</label>
				<input type="text" id="nomeCompleto" class="form-control" placeholder="Digite aqui o nome completo">
			</div>
			<div class="form-group">
				<label for="cpf">CPF:</label>
				<input type="text" id="cpf" class="form-control-sm" placeholder="Digite aqui o CPF">
			</div>
			
			<fieldset class="form-group">
    			<div class="row">
    				<legend class="col-form-label col-sm-1 pt-0">Sexo:</legend>
    				<div class="col-sm-10">
       					<div class="form-check">
          					<input class="form-check-input" type="radio" name="masculino" id="sex-masculino" value="masculino" checked>
          					<label class="form-check-label" for="sex-masculino">Masculino</label>
        				</div>
        <div class="form-check">
          <input class="form-check-input" type="radio" name="feminino" id="sex-feminino" value="feminino">
          <label class="form-check-label" for="sex-feminino">
            Feminino
          </label>
        </div>
       </div>
	</div>
	</fieldset>
        <!-- Telefone -->
        <div class="row">
        	<legend class="col-form-label col-sm-1 pt-0">Telefone:</legend>
        	<div class="col-sm-6">
	        	<div class="form-control">
	        		<label for="telefone1">Telefone Fixo:</label>
	        		<input type="text" name="telefone1" id="telefone1" placeholder="Digite aqui o telefone" ><br>
	        		<label for="telefone2">Celular:</label>
	        		<input type="text" name="telefone2" id="telefone2" placeholder="Digite aqui o telefone">
	        	</div>
        	</div>
        		
        
        </div>
        <div class="row">
        	<legend class="col-form-label col-sm-1 pt-0">Instrumento:</legend>
        	<div class="col-sm-6">
        		<div class="form-control">
        			<label for="">Instrumento</label>
        			<select>
        				<option>Guitarra</option>
        				<option>Baixo</option>
        			</select> 
        		
        		</div>
        	</div>
        
        </div>
        <div class="row">
        <legend class="col-form-label col-sm-1 pt-0">Endereço:</legend>
        	<div class="form-control">
        	<div class="col-sm-8">
        		<label for="rua" >Rua:</label>
        		<input id="rua" type="text" class="form-control">
        	</div>
        	<div class="col-sm-2">
        		<label for="numero">Número:</label>
        		<input id="numero" type="text">
        	</div></div>
        
        </div>
        <div class="row">
        	<div class="col-sm-3">
	        	<button class="btn btn-success" value="novo" id="btn-novo">Novo</button>
	        </div>
	        	<button class="btn btn-success" name="cmd" value="alterar">Alterar</button>
				<button class="btn btn-success" name="cmd" value="consultar">Consultar</button>
				<button class="btn btn-danger" name="cmd" value="deletar">Deletar</button>        
        </div>
		</form>
      </div>
	
	

</body>
</html>