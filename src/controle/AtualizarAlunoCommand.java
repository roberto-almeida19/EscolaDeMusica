package controle;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import dao.AlunoDAO;
import entidades.Endereco;
import entidades.Aluno;
import exception.NegocioException;
import util.MensagensConstantes;
import validacao.PreValidador;

public class AtualizarAlunoCommand implements Command {
	private AlunoDAO alunoDAO;
	private PreValidador preValidador;
	private String proxima = null;
	Aluno aluno = null;

	public AtualizarAlunoCommand() {
		alunoDAO = new AlunoDAO();
	}

	@Override
	public String execute(HttpServletRequest request) {
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
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
		Aluno aluno = new Aluno();
		aluno.setNome(nome);
		aluno.setCpf(cpf);
		aluno.setSexo(sexo.charAt(0));
		aluno.setTelefone1(telefone1);
		aluno.setTelefone2(telefone2);
		aluno.setListaAulaInstrumentos(listaInstrumentos);

		Endereco endereco = new Endereco();
		endereco.setLogradouro(logradouro);
		endereco.setNumero(Integer.parseInt(numero));
		endereco.setComplemento(complemento);
		endereco.setBairro(bairro);

		endereco.setCidade(cidade);

		boolean isValido = checagenInicial(aluno);

		if (!isValido) {
			request.setAttribute("msgErro", MensagensConstantes.MSG_ERR_DADOS_INVALIDOS);
			proxima = "aluno.jsp";
		} else {
			atualizar(aluno);
			proxima = "escola?acao=consultaAluno";
			request.setAttribute("msgSucesso", MensagensConstantes.MSG_SUC_CADASTRO_PESSOA);
		}

		return proxima;
	}

	public boolean checagenInicial(Aluno aluno) {
		boolean isOK = false;
		try {
			preValidador = new PreValidador(aluno);
			isOK = preValidador.verificaObjetoDoCadastro(aluno);
		} catch (NegocioException e) {
			e.printStackTrace();
		}
		return isOK;
	}

	
	public void atualizar(Aluno aluno) {
		alunoDAO.atualizaraluno(aluno);
	}
	
	
}
