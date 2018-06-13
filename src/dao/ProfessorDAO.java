package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import entidades.Endereco;
import entidades.Professor;
import util.ConexaoUtil;

public class ProfessorDAO {

	/**
	 * Cadastra professor e seu endere�o
	 * 
	 * @param professor
	 */

	public void cadastrarProfessor(Professor professor) {

		Connection conexao = null;
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		Integer codEndereco = null;

		codEndereco = enderecoDAO.cadastrarEndereco(professor.getEndereco());

		Integer codProfessor = null;

		try {
			conexao = ConexaoUtil.getConexao();
			String sql = "INSERT INTO TB_PROFESSOR (NOME, CPF, RG, OMB, SEXO, TELE1, TELE2, COD_ENDER )";

			PreparedStatement statement = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, professor.getNome());
			statement.setString(2, professor.getCpf());
			statement.setString(3, professor.getRg());
			statement.setString(4, professor.getOMB());
			statement.setString(5, String.valueOf(professor.getSexo()));
			statement.setString(6, professor.getTelefone1());
			statement.setString(7, professor.getTelefone2());
			statement.setInt(8, codEndereco);

			statement.executeUpdate();
			ResultSet resultSet = statement.getGeneratedKeys();

			if (resultSet.first()) {
				codProfessor = resultSet.getInt(1);
				System.out.println("check c�digo professor :" + codProfessor);
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
	 * Consulta cadastro Professor e seu endere�o
	 * 
	 * @param idProfessor
	 * @return
	 */

	@SuppressWarnings("null")
	public Professor consultarProfessorPorId(Integer idProfessor) {
		Connection conexao = null;
		Professor professor = null;
		try {
			conexao = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();

			sql.append("SELECT PROF.ID_PROFESSOR, PROF.NOME, PROF.CPF, PROF.RG, PROF.OMB, ");
			sql.append("PROF.SEXO, PROF.TELE1, PROF.TELE2, PROF.INSTRUMENTO, ");
			sql.append("EN.ID_ENDERECO, EN.LOGRADOURO,  EN.NUMERO, EN. COMPLEMENTO, EN.BAIRRO. EN.CIDADE, ");
			sql.append(" 	FROM TB_PROFESSOR PROF ");
			sql.append(" 		INNER JOIN TB_ENDERECO EN");
			sql.append("			ON PROF.COD_ENDER = EN.ID_ENDERECO");
			sql.append(" 				WHERE ID_PROFESSOR = ?");

			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			statement.setInt(1, idProfessor);
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.first()) {

				professor.setNome(resultSet.getString("NOME"));
				professor.setCpf(resultSet.getString("CPF"));
				professor.setRg(resultSet.getString("RG"));
				professor.setOMB(resultSet.getString("OMB"));
				professor.setTelefone1(resultSet.getString("TELE1"));
				professor.setTelefone2(resultSet.getString("TELE2"));

				Endereco endereco = new Endereco();
				endereco.setIdEndereco(resultSet.getInt("ID_ENDERECO"));
				endereco.setLogradouro(resultSet.getString("LOGRADOURO"));
				endereco.setNumero(resultSet.getInt("NUMERO"));
				endereco.setComplemento(resultSet.getString("COMPLEMENTO"));
				endereco.setBairro(resultSet.getString("BAIRRO"));
				endereco.setCidade(resultSet.getString("CIDADE"));

				professor.setEndereco(endereco);
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
		return professor;
	}

	/**
	 * Altera cadastro do professor e seu endere�o
	 * 
	 * @param professor
	 */
	public void atualizarProfessor(Professor professor) {
		Connection conexao = null;
		try {
			conexao = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE TB_PROFESSOR ");
			sql.append(" SET NOME = ?, CPF = ?, RG = ?, OMB = ?,  SEXO = ?, TELE1 = ? , TELE2 = ? ");
			sql.append(" WHERE ID_PROFESSOR = ?");

			PreparedStatement statement = conexao.prepareStatement(sql.toString());

			statement.setString(1, professor.getNome());
			statement.setString(2, professor.getCpf());
			statement.setString(3, professor.getRg());
			statement.setString(4, professor.getOMB());
			statement.setString(5, String.valueOf(professor.getSexo()));
			statement.setString(6, professor.getTelefone1());
			statement.setString(7, professor.getTelefone2());

			statement.executeUpdate();

			EnderecoDAO enderecoDAO = new EnderecoDAO();
			enderecoDAO.atualizarendereco(professor.getEndereco());

			InstrumentoAulaDAO instrumentoAulaDAO = new InstrumentoAulaDAO();
			instrumentoAulaDAO.removerListaInstrumentoAula(professor.getIdProfessor());
			instrumentoAulaDAO.cadastrarInstrumentoAula(professor.getListaAulaInstrumentos(),
					professor.getIdProfessor());

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

	public boolean removerProfessor(Integer idProfessor) {

		Connection conexao = null;

		Professor professor = consultarProfessorPorId(idProfessor);

		EnderecoDAO enderecoDAO = new EnderecoDAO();
		if (professor.getEndereco() != null) {
			enderecoDAO.removerendereco(professor.getEndereco().getIdEndereco());
		}
		InstrumentoAulaDAO instrumentoAulaDAO = new InstrumentoAulaDAO();
		if (professor.getListaAulaInstrumentos() != null) {
			instrumentoAulaDAO.removerListaInstrumentoAula(professor.getIdProfessor());
		}

		try {
			conexao = ConexaoUtil.getConexao();

			String sql = "DELETE FROM TB_PROFESSOR WHERE ID_PROFESSOR = ?  ";

			PreparedStatement statement = conexao.prepareStatement(sql);
			statement.setInt(1, idProfessor);

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
