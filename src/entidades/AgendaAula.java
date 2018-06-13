package entidades;

import util.AulaInstrumento;

public class AgendaAula {

	private int idAgendaAula;
	private String dataHora;
	private int codAluno;
	private int codProfessor;
	private AulaInstrumento aulaInstr;
	private String programacao;
	private int ordinalAula;

	public int getOrdinalAula() {
		return ordinalAula;
	}

	public void setOrdinalAula(int ordinalAula) {
		this.ordinalAula = ordinalAula;
	}

	public int getIdAgendaAula() {
		return idAgendaAula;
	}

	public void setIdAgendaAula(int idAgendaAula) {
		this.idAgendaAula = idAgendaAula;
	}

	public String getDataHora() {
		return dataHora;
	}

	public void setDataHora(String dataHora) {
		this.dataHora = dataHora;
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

	public String getProgramacao() {
		return programacao;
	}

	public void setProgramacao(String programacao) {
		this.programacao = programacao;
	}

}