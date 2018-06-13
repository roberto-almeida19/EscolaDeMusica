package controle;

import javax.servlet.http.HttpServletRequest;

import dao.ProfessorDAO;

public class RemoverProfessorCommand implements Command {

	private String proximo;

	private ProfessorDAO professorDAO;

	public String execute(HttpServletRequest request) {
		proximo = "main?acao=consultas";
		this.professorDAO = new ProfessorDAO();

		try {
			Integer idProfessor = Integer.parseInt(request.getParameter("id_Professor"));
			professorDAO.removerProfessor(idProfessor);
		} catch (Exception e) {
			request.setAttribute("msgErro", e.getMessage());
		}

		return proximo;
	}

}
