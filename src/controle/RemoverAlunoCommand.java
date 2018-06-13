package controle;

import javax.servlet.http.HttpServletRequest;

import dao.AlunoDAO;

public class RemoverAlunoCommand implements Command {

	private String proximo;

	private AlunoDAO alunoDAO;

	public String execute(HttpServletRequest request) {
		proximo = "escola?acao=consultas";
		this.alunoDAO = new AlunoDAO();

		try {
			Integer idAluno = Integer.parseInt(request.getParameter("id_Aluno"));
			alunoDAO.removerAluno(idAluno);
		} catch (Exception e) {
			request.setAttribute("msgErro", e.getMessage());
		}

		return proximo;
	}

}
