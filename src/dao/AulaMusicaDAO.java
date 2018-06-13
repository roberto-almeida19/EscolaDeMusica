package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import entidades.AulaMusica;
import util.ConexaoUtil;

public class AulaMusicaDAO {

	public void incluirAulaMusica(AulaMusica aulaMusica) {
		Connection conexao = null;
		int codAulaMusica;
		try {
			conexao = ConexaoUtil.getConexao();

			String sql = "INSERT INTO TB_AULAMUSICA VALUES (?, ?, ?, ? , ? , ?) " ;
			PreparedStatement statement = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			statement.setString(1, aulaMusica.getDataHora());
			statement.setInt(2, aulaMusica.getCodAluno());
			statement.setInt(3, aulaMusica.getCodProfessor());
			statement.setInt(4, aulaMusica.getAulaInstr().getAula());
			statement.setString(5, String.valueOf(aulaMusica.getPresenca()));
			statement.setString(6, aulaMusica.getHistorico());

			statement.executeUpdate();

			ResultSet resultSet = statement.getGeneratedKeys();
			if (resultSet.first()) {
				codAulaMusica = resultSet.getInt(1);
				System.out.println("check c�digo aulaMusica :" + codAulaMusica);
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
	 * Consulta aulaMusica por c�digo do Aluno
	 * 
	 * @param codAluno
	 * @return
	 */
	public List<AulaMusica> consultaraulaMusicaAluno(int codAluno) {
		List<AulaMusica> ListaAulaMusica = new ArrayList<>();

		Connection conexao = null;
		try {
			conexao = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();

			sql.append("SELECT AU.ID_AULA, AU.DATAHORA, AU.COD_ALUNO, AU.COD_PROFESSOR, ");
			sql.append(" AU.INSTRUMENTO, Historico,  PROF.NOME, ALU.NOME ");
			sql.append("	FROM TB_AULAMUSICA AU ");
			sql.append("		INNER JOIN TB_PROFESSOR PROF");
			sql.append(" 			INNER JOIN TB_ALUNO ALU ");
			sql.append("			ON AU.COD_PROFESSOR = PROF.ID_PROFESSOR ");
			sql.append(" 				AND AU.COD_ALUNO = ALU.ID_ALUNO ");
			sql.append(" 					WHERE COD_ALUNO = ? ");
			sql.append("						ORDER BY AU.DATAHORA");

			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			statement.setInt(1, codAluno);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				AulaMusica aulaMusica = new AulaMusica();
				aulaMusica.setIdAulaMusica(resultSet.getInt("ID_AULA"));
				aulaMusica.setDataHora(resultSet.getString("DATAHORA"));
				aulaMusica.setCodAluno(resultSet.getInt("COD_ALUNO"));
				aulaMusica.setCodProfessor(resultSet.getInt("COD_PROFESSOR"));
				aulaMusica.setOrdAulaInstr(resultSet.getInt("INSTRUMENTO"));
				aulaMusica.setHistorico(resultSet.getString("HISTORICO"));

				ListaAulaMusica.add(aulaMusica);
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
		return ListaAulaMusica;
	}

	/**
	 * Consulta aulaMusica por c�digo do Professor
	 * 
	 * @param codAluno
	 * @return
	 */
	public List<AulaMusica> consultaraulaMusicaProfessor(int codProfessor) {
		List<AulaMusica> ListaulaMusica = new ArrayList<>();

		Connection conexao = null;
		try {
			conexao = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();

			sql.append("SELECT AU.ID_AULA, AU.DATAHORA, AU.COD_ALUNO, AU.COD_PROFESSOR, ");
			sql.append(" AU.INSTRUMENTO, Historico, PROF.NOME, ALU.NOME ");
			sql.append("	FROM TB_AULAMUSICA AU ");
			sql.append("		INNER JOIN TB_PROFESSOR PROF");
			sql.append(" 			INNER JOIN TB_ALUNO ALU ");
			sql.append("			ON AU.COD_PROFESSOR = PROF.ID_PROFESSOR ");
			sql.append(" 				AND AU.COD_ALUNO = ALU.ID_ALUNO ");
			sql.append(" 					WHERE COD_PROFESSOR = ? ");
			sql.append("						ORDER BY AU.DATAHORA");

			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			statement.setInt(1, codProfessor);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				AulaMusica aulaMusica = new AulaMusica();
				aulaMusica.setIdAulaMusica(resultSet.getInt("ID_AULA"));
				aulaMusica.setDataHora(resultSet.getString("DATAHORA"));
				aulaMusica.setCodAluno(resultSet.getInt("COD_ALUNO"));
				aulaMusica.setCodProfessor(resultSet.getInt("COD_PROFESSOR"));
				aulaMusica.setOrdAulaInstr(resultSet.getInt("INSTRUMENTO"));
				aulaMusica.setHistorico(resultSet.getString("HISTORICO"));

				ListaulaMusica.add(aulaMusica);
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
		return ListaulaMusica;
	}

	/**
	 * Consulta aulaMusica por c�digo do Professor
	 * 
	 * @param codAluno
	 * @return
	 */
	public List<AulaMusica> consultaraulaMusicaGeral() {
		List<AulaMusica> ListaulaMusica = new ArrayList<>();

		Connection conexao = null;
		try {
			conexao = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();

			sql.append("SELECT AU.ID_aulaMusica, AU.DATAHORA, AU.COD_ALUNO, AU.COD_PROFESSOR,  ");
			sql.append(" AU.INSTRUMENTO, Historico, PROF.NOME, ALU.NOME ");
			sql.append("	FROM TB_AULAMUSICA AU ");
			sql.append("		INNER JOIN TB_PROFESSOR PROF");
			sql.append(" 			INNER JOIN TB_ALUNO ALU ");
			sql.append("			ON AU.COD_PROFESSOR = PROF.ID_PROFESSOR ");
			sql.append(" 				AND AU.COD_ALUNO = ALU.ID_ALUNO ");
			sql.append("					ORDER BY AU.DATAHORA");

			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				AulaMusica aulaMusica = new AulaMusica();
				aulaMusica.setIdAulaMusica(resultSet.getInt("ID_AULA"));
				aulaMusica.setDataHora(resultSet.getString("DATAHORA"));
				aulaMusica.setCodAluno(resultSet.getInt("COD_ALUNO"));
				aulaMusica.setCodProfessor(resultSet.getInt("COD_PROFESSOR"));
				aulaMusica.setOrdAulaInstr(resultSet.getInt("INSTRUMENTO"));
				aulaMusica.setHistorico(resultSet.getString("HISTORICO"));

				ListaulaMusica.add(aulaMusica);
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
		return ListaulaMusica;
	}

	public void alteraraulaMusica(AulaMusica aulaMusica) {

		Connection conexao = null;
		try {
			conexao = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();

			sql.append("UPDATE TB_AULALMUSICA ");
			sql.append(" SET DATAHORA = ?, COD_ALUNO = ?, COD_PROFESSOR = ?, INSTRUMENTO = ? , HISTORICO = ? ");
			sql.append(" WHERE ID_AULA = ? ");

			PreparedStatement statement = conexao.prepareStatement(sql.toString());

			statement.setString(1, aulaMusica.getDataHora());
			statement.setInt(2, aulaMusica.getCodAluno());
			statement.setInt(3, aulaMusica.getCodProfessor());
			statement.setInt(4, aulaMusica.getOrdAulaInstr());
			statement.setString(5, aulaMusica.getHistorico());

			statement.setInt(6, aulaMusica.getIdAulaMusica());

			statement.executeUpdate();
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

	public boolean removeraulaMusica(AulaMusica aulaMusica) {

		Connection conexao = null;
		int cod_AulaMusica = aulaMusica.getIdAulaMusica();
		try {
			conexao = ConexaoUtil.getConexao();

			String sql = "DELETE TB_AULAMUSICA WHERE ID_AULA = ? ";

			PreparedStatement statement = conexao.prepareStatement(sql);
			statement.setInt(1, cod_AulaMusica);

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
