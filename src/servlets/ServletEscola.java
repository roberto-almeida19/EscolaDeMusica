package servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controle.*;

@WebServlet("/escola")
public class ServletEscola extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Map<String, Command> comandos = new HashMap<>();

	@Override
	public void init() throws ServletException {
		comandos.put("cadastroProfessor", new CadastroProfessorCommand());
		comandos.put("cadastroAluno", new CadastroAlunoCommand());
		comandos.put("cadastroAgendaMusica", new CadastroAgendaMusicaCommand());
		comandos.put("cadastroContaAula", new CadastroContaAula());
		comandos.put("removerProfessor", new RemoverProfessorCommand());
		comandos.put("atualizarProfessor", new AtualizarProfessorCommand());
		comandos.put("removerAluno", new RemoverAlunoCommand());
		comandos.put("atualizarAluno", new AtualizarAlunoCommand());

		// comandos.put("logout", new LogoutCommand());
		// comandos.put("index", new IndexCommand());
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String acao = request.getParameter("acao");
		String proxima = "";

		try {
			Command comando = verificarComand(acao);
			
			proxima = comando.execute(request);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msgErro", e.getMessage());
		}
		System.out.println("Acao: "+acao+"  "+proxima);
		request.getRequestDispatcher(proxima).forward(request, response);
	}

	private Command verificarComand(String acao) {
		Command comando = null;
		for (String key : comandos.keySet()) {
			if (key.equalsIgnoreCase(acao)) {
				comando = comandos.get(key);
			}
		}
		return comando;
	}
}
