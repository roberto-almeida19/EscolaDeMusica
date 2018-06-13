package validacao;

import java.util.HashMap;
import java.util.Map;

import entidades.Professor;
import exception.NegocioException;
import util.MensagensConstantes;

public class ValidadorProfessor {
	Professor professor = new Professor();

	public ValidadorProfessor(Professor professor) {
		this.professor = professor;
	}

	/**
	 * Valida Campos Professor
	 * 
	 * @param professor
	 * @return
	 * @throws NegocioException
	 */

	public boolean validarProfessor(Professor professor) throws NegocioException {
		boolean isValido = false;

		try {
			if (professor.getNome() == null || "".equals(professor.getNome())) {
				throw new NegocioException(MensagensConstantes.MSG_ERR_CAMPO_OBRIGATORIO.replace("?", "Nome"));
			}
			Map<String, Object> valores = new HashMap<>();
			valores.put("CPF", professor.getCpf());

			if (new CPFValidador().validar(valores)) {
				isValido = true;
			}
			if (professor.getSexo() == ' ') {
				throw new NegocioException(MensagensConstantes.MSG_ERR_CAMPO_OBRIGATORIO.replace("?", "Sexo"));
			}
			if (professor.getEndereco() == null || "".equals((professor.getEndereco().getLogradouro()))) {
				throw new NegocioException(MensagensConstantes.MSG_ERR_CAMPO_OBRIGATORIO.replace("?", "Logradouro"));
			}
			if (!isValido) {
				throw new NegocioException(MensagensConstantes.MSG_ERR_DADOS_INVALIDOS);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}

		return isValido;
	}
}
