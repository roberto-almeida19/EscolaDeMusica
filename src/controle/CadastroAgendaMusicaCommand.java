package controle;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import entidades.AulaMusica;

public class CadastroAgendaMusicaCommand implements Command {

	@Override
	public String execute(HttpServletRequest request) {
		String proxima = "";
		String data = request.getParameter("data");
		String hora = request.getParameter("hora");
		String codProfessor = request.getParameter("codProfessor");
		String codAluno = request.getParameter("codProfessor");
		String instrumento = request.getParameter("instrumento");
		String presenca = request.getParameter("presenca");
		String historico = request.getParameter("historico");
		
		AulaMusica musica = new AulaMusica();
		musica.setDataHora(data+hora);
		musica.setCodProfessor(Integer.parseInt(codProfessor));
		musica.setCodAluno(Integer.parseInt(codAluno));
		//musica.setAulaInstr(instrumento);
		musica.setPresenca(presenca.charAt(0));
		musica.setHistorico(historico);
		
		
		
		proxima = "aulamarcada.jsp";
	
	return proxima;
	}

}
