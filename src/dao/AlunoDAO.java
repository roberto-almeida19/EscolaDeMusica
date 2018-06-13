package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import entidades.Aluno;
import entidades.Endereco;
import util.ConexaoUtil;

public class AlunoDAO {

	/**
	 * Cadastro de Aluno e seu endere�o
	 * 
	 * @param aluno
	 */

	public void cadastrarAluno(Aluno aluno) {
		Connection conexao = null;
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		Integer codEndereco = enderecoDAO.cadastrarEndereco(aluno.getEndereco());

		Integer codAluno = null;

		try {
			conexao = ConexaoUtil.getConexao();

			String sql = "INSERT INTO TB_ALUNO (NOME, CPF, SEXO, TELE1, TELE2, COD_ENDER)" + "VALUES (?,?,?,?,?,? )";

			PreparedStatement statement = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, aluno.getNome());
			statement.setString(2, aluno.getCpf());
			statement.setString(3, String.valueOf(aluno.getSexo()));
			statement.setString(4, aluno.getTelefone1());
			statement.setString(5, aluno.getTelefone2());
			statement.setInt(6, codEndereco);

			// statement.sets

			statement.executeUpdate();
			ResultSet resultSet = statement.getGeneratedKeys();

			if (resultSet.first()) {
				codAluno = resultSet.getInt(1);
				System.out.println("check c�digo aluno :" + codAluno);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Consulta de Aluno e seu endere�o
	 * 
	 * @param idAluno
	 * @return
	 */

	public Aluno consultarAlunoPorId(Integer idAluno) {
		Connection conexao = null;
		Aluno aluno = null;
		try {
			conexao = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT ALU.ID_ALUNO, ALU.NOME, ALU.CPF, ALU.RG,  ");
			sql.append("ALU.SEXO, ALU.TELE1, ALU.TELE2, ");
			sql.append("EN.ID_ENDERECO, EN.LOGRADOURO,  EN.NUMERO,  EN.COMPLEMENTO, EN.BAIRRO. EN.CIDADE, ");
			sql.append(" 	FROM TB_ALUNO ALU ");
			sql.append(" 		INNER JOIN TB_ENDERECO EN");
			sql.append("			ON ALU.COD_ENDER = EN.ID_ENDERECO");
			sql.append(" WHERE ID_ALUNO = ?");
			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.first()) {
				aluno = new Aluno();
				aluno.setNome(resultSet.getString("NOME"));
				aluno.setCpf(resultSet.getString("CPF"));
				aluno.setSexo(resultSet.getString("SEXO").charAt(0));
				aluno.setTelefone1(resultSet.getString("TELE1"));
				aluno.setTelefone2(resultSet.getString("TELE2"));

				Endereco endereco = new Endereco();
				endereco.setIdEndereco(resultSet.getInt("ID_ENDERECO"));
				endereco.setLogradouro(resultSet.getString("LOGRADOURO"));
				endereco.setNumero(resultSet.getInt("NUMERO"));
				endereco.setComplemento(resultSet.getString("COMPLEMENTO"));
				endereco.setBairro(resultSet.getString("BAIRRO"));
				endereco.setCidade(resultSet.getString("CIDADE"));

				aluno.setEndereco(endereco);

			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return aluno;
	}

	/**
	 * Atualiza��o de Cadastro de Aluno
	 * 
	 * @param aluno
	 */

	public void atualizaraluno(Aluno aluno) {
		Connection conexao = null;
		try {
			conexao = ConexaoUtil.getConexao();
			String sql = "UPDATE TB_ALUNO " + "SET NOME = ? , CPF = ? , SEXO = ? , TELE1 = ?, TELE1 = ? "
					+ "WHERE ID_ALUNO = ? ";

			PreparedStatement statement = conexao.prepareStatement(sql);

			statement.setString(1, aluno.getNome());
			statement.setString(2, aluno.getCpf());
			statement.setString(3, String.valueOf(aluno.getSexo()));
			statement.setString(4, aluno.getTelefone1());
			statement.setString(4, aluno.getTelefone2());

			statement.executeUpdate();

			EnderecoDAO enderecoDAO = new EnderecoDAO();
			enderecoDAO.atualizarendereco(aluno.getEndereco());

			InstrumentoAulaDAO instrumentoAulaDAO = new InstrumentoAulaDAO();
			instrumentoAulaDAO.removerListaInstrumentoAula(aluno.getIdAluno());
			instrumentoAulaDAO.cadastrarInstrumentoAula(aluno.getListaAulaInstrumentos(), aluno.getIdAluno());

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean removerAluno(Integer idAluno) {

		Connection conexao = null;
		try {
			Aluno aluno = consultarAlunoPorId(idAluno);
			
			if ((aluno.getEndereco() != null)) {
				EnderecoDAO enderecoDAO = new EnderecoDAO();
				enderecoDAO.removerendereco(aluno.getEndereco().getIdEndereco());
			}
			
			
			InstrumentoAulaDAO instrumentoAulaDAO = new InstrumentoAulaDAO();
			instrumentoAulaDAO.removerListaInstrumentoAula(aluno.getIdAluno());
			conexao = ConexaoUtil.getConexao();

			int cod_Aluno = aluno.getIdAluno();

			String sql = "DELETE FROM TB_ALUNO WHERE ID_ALUNO = ? ";

			PreparedStatement statement = conexao.prepareStatement(sql);
			statement.setInt(1, cod_Aluno);

			statement.execute();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

}
