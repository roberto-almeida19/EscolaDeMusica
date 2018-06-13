package controle;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import dao.ProfessorDAO;
import entidades.Endereco;
import entidades.Professor;
import exception.NegocioException;
import util.MensagensConstantes;
import validacao.PreValidador;

public class CadastroProfessorCommand implements Command {
	private ProfessorDAO professorDAO;
	private PreValidador preValidador;
	private String proxima = null;

	public CadastroProfessorCommand() {
		professorDAO = new ProfessorDAO();
	}

	@Override
	public String execute(HttpServletRequest request) {
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String rg = request.getParameter("rg");
		String OMB = request.getParameter("OMB");
		String sexo = request.getParameter("sexo");
		String telefone1 = request.getParameter("telefone1");
		String telefone2 = request.getParameter("telefone2");
		String logradouro = request.getParameter("logradouro");
		String numero = request.getParameter("numero");
		String complemento = request.getParameter("complemento");
		String bairro = request.getParameter("bairro");
		String cidade = request.getParameter("cidade");

		String[] ListaAulaInstrumento = request.getParameterValues("listaAulaInstrumentos");
		Set<Integer> listaInstrumentos = new HashSet<>();

		if (listaInstrumentos != null) {
			for (String s : ListaAulaInstrumento) {
				listaInstrumentos.add(Integer.parseInt(s));
			}
		}
		Professor professor = new Professor();
		professor.setNome(nome);
		professor.setCpf(cpf);
		professor.setRg(rg);
		professor.setOMB(OMB);
		professor.setSexo(sexo.charAt(0));
		professor.setTelefone1(telefone1);
		professor.setTelefone2(telefone2);
		professor.setListaAulaInstrumentos(listaInstrumentos);

		Endereco endereco = new Endereco();
		endereco.setLogradouro(logradouro);
		endereco.setNumero(Integer.parseInt(numero));
		endereco.setComplemento(complemento);
		endereco.setBairro(bairro);
		endereco.setCidade(cidade);

		boolean isValido = checagenInicial(professor);

		if (!isValido) {
			request.setAttribute("msgErro", MensagensConstantes.MSG_ERR_DADOS_INVALIDOS);
			proxima = "professor.jsp";
		} else {
			cadastrar(professor);
			proxima = "homeProfessor.jsp";
			System.out.println();
			request.setAttribute("msgSucesso", MensagensConstantes.MSG_SUC_CADASTRO_PESSOA);
		}

		return proxima;

	}

	public boolean checagenInicial(Professor professor) {
		boolean isOK = false;
		try {
			preValidador = new PreValidador(professor);
			isOK = preValidador.verificaObjetoDoCadastro(professor);
		} catch (NegocioException e) {
			e.printStackTrace();
		}
		return isOK;
	}

	public void cadastrar(Professor professor) {
		professorDAO.cadastrarProfessor(professor);
	}

	public void consultar(Professor professor) {
		professorDAO.consultarProfessorPorId(professor.getIdProfessor());
	}

	public void alterar(Professor professor) {
		professorDAO.atualizarProfessor(professor);
	}

	
}
