package entidades;

import java.io.Serializable;
import java.util.Set;

public class Aluno implements Serializable {

	private static final long serialVersionUID = -291760250869563914L;
	private int idAluno;
	private String Nome;
	private String cpf;
	private char sexo;
	private String telefone1;
	private String telefone2;
	private Set<Integer> listaAulaInstrumentos;
	private Endereco Endereco;

	
	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public int getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(int idAluno) {
		this.idAluno = idAluno;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	public Set<Integer> getListaAulaInstrumentos() {
		return listaAulaInstrumentos;
	}

	public void setListaAulaInstrumentos(Set<Integer> listaAulaInstrumentos) {
		this.listaAulaInstrumentos = listaAulaInstrumentos;
	}

	public Endereco getEndereco() {
		return Endereco;
	}

	public void setEndereco(Endereco endereco) {
		Endereco = endereco;
	}
}
