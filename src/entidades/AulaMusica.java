package entidades;

import util.AulaInstrumento;

public class AulaMusica {

	private int idAulaMusica;
	private String dataHora;
	private int codAluno;
	private int codProfessor;
	private AulaInstrumento aulaInstr;
	private int ordAulaInstr;
	private char presenca;
	private String historico;
	private int tipoAula;

	public double GerarContaAula() {
		
		return 0;
	}

	public int getIdAulaMusica() {
		return idAulaMusica;
	}

	public void setIdAulaMusica(int idAulaMusica) {
		this.idAulaMusica = idAulaMusica;
	}

	public String getDataHora() {
		return dataHora;
	}

	public void setDataHora(String dataHora) {
		this.dataHora = dataHora;
	}

	public char getPresenca() {
		return presenca;
	}

	public void setPresenca(char presenca) {
		this.presenca = presenca;
	}

	public int getCodAluno() {
		return codAluno;
	}

	public void setCodAluno(int codAluno) {
		this.codAluno = codAluno;
	}

	public int getCodProfessor() {
		return codProfessor;
	}

	public void setCodProfessor(int codProfessor) {
		this.codProfessor = codProfessor;
	}

	public AulaInstrumento getAulaInstr() {
		return aulaInstr;
	}

	public void setAulaInstr(AulaInstrumento aulaInstr) {
		this.aulaInstr = aulaInstr;
	}

	public int getOrdAulaInstr() {
		return aulaInstr.ordinal();
	}

	public void setOrdAulaInstr(int ordAulaInstr) {
		this.ordAulaInstr = ordAulaInstr;
	}

	public String getHistorico() {
		return historico;
	}

	public void setHistorico(String historico) {
		this.historico = historico;
	}

	public int getTipoAula() {
		return tipoAula;
	}

	public void setTipoAula(int tipoAula) {
		this.tipoAula = tipoAula;
	}

}
