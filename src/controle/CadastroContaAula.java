package controle;

import javax.servlet.http.HttpServletRequest;
import entidades.ContaAula;
public class CadastroContaAula implements Command {

	@Override
	public String execute(HttpServletRequest request) {
		String proxima = "";
		String valorAula = request.getParameter("valorAula");
		String valorDesc = request.getParameter("valorDesc");
		String valorTotal = request.getParameter("valorTotal");
		
		ContaAula aula = new ContaAula();
		//TODO - Como pegar a aula atual e fazer o pagamento
		aula.setValorAula(Double.parseDouble(valorAula));
		aula.setValorDesc(Double.parseDouble(valorDesc));
		aula.setValorTotal(Double.parseDouble(valorTotal));
		
		proxima = "aulaPaga.jsp";
		return proxima;
	}

}
