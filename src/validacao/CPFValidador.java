package validacao;

import java.util.Map;
import util.Util;

import exception.ValidacaoException;
import util.MensagensConstantes;

public class CPFValidador {

	public boolean validar(Map<String, Object> valores) throws ValidacaoException {
		String msgErro = "";
		for (String key : valores.keySet()) {
			String cpf = (String) valores.get(key);

			if (!"".equals(cpf)) {
				if (!Util.isCPF(cpf)) {
					msgErro += MensagensConstantes.MSG_ERR_CAMPO_INVALIDO.replace("?", key).concat("<br/>");
				}
				if (cpf.length() < 11) {
					msgErro += MensagensConstantes.MSG_ERR_CAMPO_CPF_MENOR.replace("?", key).concat("<br/>");
				}
				if (cpf.length() > 11) {
					msgErro += MensagensConstantes.MSG_ERR_CAMPO_CPF_MAIOR.replace("?", key).concat("<br/>");

				}
			} else {
				msgErro += MensagensConstantes.MSG_ERR_CAMPO_OBRIGATORIO.replace("?", key).concat("<br/>");
			}
		}
		if (!"".equals(msgErro)) {
			throw new ValidacaoException(msgErro);
		}

		return true;
	}

}