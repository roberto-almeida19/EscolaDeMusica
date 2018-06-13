package entidades;

import java.io.Serializable;
import java.util.Set;

import util.AulaInstrumento;

public class Professor implements Serializable {

	private static final long serialVersionUID = 1L;

	private int idProfessor;
	private String nome;
	private String cpf;
	private String rg;
	private String OMB;
	private char sexo;
	private String telefone1;
	private String telefone2;
	private Set<Integer> listaAulaInstrumentos;
	private AulaInstrumento instrumento;
	private Endereco endereco;

	public int getIdProfessor() {
		return idProfessor;
	}

	public void setIdProfessor(int idProfessor) {
		this.idProfessor = idProfessor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getOMB() {
		return OMB;
	}

	public void setOMB(String oMB) {
		OMB = oMB;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
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

	public AulaInstrumento getInstrumento() {
		return instrumento;
	}

	public void setInstrumento(AulaInstrumento instrumento) {
		this.instrumento = instrumento;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Set<Integer> getListaAulaInstrumentos() {
		return listaAulaInstrumentos;
	}

	public void setListaAulaInstrumentos(Set<Integer> listaAulaInstrumentos) {
		this.listaAulaInstrumentos = listaAulaInstrumentos;
	}

	// private int ordAulaInstr;
	// public int getOrdAulaInstr() {
	// return instrumento.ordinal();
	// }
	// public void setOrdAulaInstr(int ordAulaInstr) {
	// this.ordAulaInstr = ordAulaInstr;
	// }
}
