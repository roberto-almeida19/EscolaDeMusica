package validacao;

import java.util.HashMap;
import java.util.Map;

import entidades.Aluno;
import exception.NegocioException;
import util.MensagensConstantes;

public class ValidadorAluno {
	Aluno aluno = new Aluno();

	public ValidadorAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	/**
	 * Valida Campos Aluno
	 * 
	 * @param aluno
	 * @return
	 * @throws NegocioException
	 */
	
	public boolean validarAluno(Aluno aluno) throws NegocioException {
		boolean isValido = false;

		try {
			if (aluno.getNome() == null || "".equals(aluno.getNome())) {
				throw new NegocioException(MensagensConstantes.MSG_ERR_CAMPO_OBRIGATORIO.replace("?", "Nome"));
			}
			Map<String, Object> valores = new HashMap<>();
			valores.put("CPF", aluno.getCpf());

			if (new CPFValidador().validar(valores)) {
				isValido = true;
			}
			if (aluno.getSexo() == ' ') {
				throw new NegocioException(MensagensConstantes.MSG_ERR_CAMPO_OBRIGATORIO.replace("?", "Sexo"));
			}
			if (aluno.getEndereco() == null || "".equals((aluno.getEndereco().getLogradouro()))) {
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
