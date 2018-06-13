package entidades;

import java.io.Serializable;

public class InstrumentoAula implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer instruAula;
	private String descricao;

	public InstrumentoAula() {
	}

	public Integer getInstruAula() {
		return instruAula;
	}

	public void setInstruAula(Integer instAula) {
		this.instruAula = instAula;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


}
