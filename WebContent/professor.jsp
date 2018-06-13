<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Professor</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
	
		<h2 class="text-center">Professor</h2>
		<form>
			<div class="form-group">
				<label for="nomeCompleto">Nome Completo:</label>
				<input type="text" id="nome" class="form-control" placeholder="Digite aqui o nome completo">
			</div>
			<div class="form-group">
				<div class="row">
				<div class="col-sm-3">
				<label for="cpf">CPF:</label>
				<input type="text" id="cpf" class="form-control" placeholder="Digite aqui o CPF">
				</div>
				<div class="col-sm-3">
				<label for="omb">OMB:</label>
				<input type="text" id="omb" class="form-control" placeholder="Digite aqui o OMB">
				</div>				
				</div>
			</div>
			
			<fieldset class="form-group">
    			<div class="row">
    				<legend class="col-form-label col-sm-1 pt-0">Sexo:</legend>
    				<div class="col-sm-10">
       					<div class="form-check">
       					<select id="sexo">
       					<option value="M">Masculino</option>
       					<option value="F">Feminino</option>
       					</select>
        				</div>
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
        			<label for="instrumento">Instrumento</label>
        			<select id="instrumento">
        				<option>Guitarra</option>
        				<option>Baixo</option>
        			</select> 
        		
        		</div>
        	</div>
        
        </div>
        <div class="row">
        <legend class="col-form-label col-sm pt-0">Endereço:</legend>
        	<div class="form-control">
        	<div class="col-sm-12">
        		<label for="logradouro" >Logradouro:</label>
        		<input id="logradouro" type="text" class="form-control">
        	</div>
			<div class="row">
				<div class="col-sm-4">
				<label for="numero">Número:</label>
        		<input id="numero" type="text" class="form-control">
			</div>
			<div class="col-sm-4">				
        		<label for="cep">CEP:</label>
        		<input type="text" id="cep" class="form-control">
        	</div>
        	<div class="col-sm-4">
        		<label for="complemento">Complemento:</label>
        		<input type="text" id="complemento" class="form-control">
			</div>
			</div>
        		
        	<div class="row">
	        	<div class="col-sm-6">
	        		<label for="bairro">Bairro:</label>
	        		<input type="text" id="bairro" class="form-control">
	        	</div>
	        	<div class="col-sm-6">
	        		<label for="cidade">Cidade:</label>
	        		<input type="text" id="cidade" class="form-control">
	        	</div>
        	</div>
        	
        </div>
        </div>
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