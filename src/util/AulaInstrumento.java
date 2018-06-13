package util;

public enum AulaInstrumento {

	GUITARRA, VIOLAO_POPULAR, VIOLAO_CLASSICO, PIANO, BAIXO_ELETRICO, BATERIA, CANTO;

	public int aula;

	public String toString(int aula) {
		return name();
	}

	public int getAula() {
		return aula;
	}

}
