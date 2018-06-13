package validacao;

import entidades.Aluno;
import entidades.Professor;
import exception.NegocioException;
import util.MensagensConstantes;

public class PreValidador {

	public PreValidador(Object obj) throws NegocioException {
	try {
			verificaObjetoDoCadastro(obj);
		} catch (NegocioException e) {
			throw new NegocioException(MensagensConstantes.MSG_ERR_DADOS_INVALIDOS);
		}
	}

	public boolean verificaObjetoDoCadastro(Object obj) throws NegocioException {

		boolean isValido = false;

		String classe = obj.getClass().toString().substring(23);
		System.out.println(classe);

		System.out.println("classe  " + classe);
		Professor professor = null;
		Aluno aluno = null;

		switch (classe) {
		case "Professor":
			professor = (Professor) obj;
			ValidadorProfessor validadorP = new ValidadorProfessor(professor);
			isValido = validadorP.validarProfessor(professor);
			break;
		case "Aluno":
			aluno = (Aluno) obj;
			ValidadorAluno validadorA = new ValidadorAluno(aluno);
			isValido = validadorA.validarAluno(aluno);
			break;
		default:
			System.out.println();
			break;
		}
		return isValido;

	}

}
