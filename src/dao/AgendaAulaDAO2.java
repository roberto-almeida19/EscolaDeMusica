package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import entidades.AgendaAula;
import util.ConexaoUtil;

public class AgendaAulaDAO2 {

	public void incluirAgendaAula(AgendaAula agenda) {
		Connection conexao = null;
		int codAgendamento;
		try {
			conexao = ConexaoUtil.getConexao();

			String sql = "INSERT INTO TB_AGENDA_AULA VALUES (?, ?, ?, ? , ? ) ";
			PreparedStatement statement = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			statement.setString(1, agenda.getDataHora());
			statement.setInt(2, agenda.getCodAluno());
			statement.setInt(3, agenda.getCodProfessor());
			statement.setInt(4, agenda.getAulaInstr().getAula());
			statement.setString(5, agenda.getProgramacao());

			statement.executeUpdate();

			ResultSet resultSet = statement.getGeneratedKeys();
			if (resultSet.first()) {
				codAgendamento = resultSet.getInt(1);
				System.out.println("check c�digo AGENDAMENTO :" + codAgendamento);
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
	 * Consulta Agenda por c�digo do Aluno
	 * 
	 * @param codAluno
	 * @return
	 */
	public List<AgendaAula> consultarAgendaAluno(int codAluno) {
		List<AgendaAula> ListAgenda = new ArrayList<>();

		Connection conexao = null;
		try {
			conexao = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();

			sql.append("SELECT AG.ID_AGENDA, AG.DATAHORA, AG.COD_ALUNO, AG.COD_PROFESSOR, ");
			sql.append(" AG.INSTRUMENTO, PROGRAMACAO,  PROF.NOME, ALU.NOME ");
			sql.append("	FROM TB_AGENDAAULA AG ");
			sql.append("		INNER JOIN TB_PROFESSOR PROF");
			sql.append(" 			INNER JOIN TB_ALUNO ALU ");
			sql.append("			ON AG.COD_PROFESSOR = PROF.ID_PROFESSOR ");
			sql.append(" 				AND AG.COD_ALUNO = ALU.ID_ALUNO ");
			sql.append(" 					WHERE COD_ALUNO = ? ");
			sql.append("						ORDER BY AG.DATAHORA");

			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			statement.setInt(1, codAluno);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				AgendaAula agenda = new AgendaAula();
				agenda.setIdAgendaAula(resultSet.getInt("ID_AGENDA"));
				agenda.setDataHora(resultSet.getString("DATAHORA"));
				agenda.setCodAluno(resultSet.getInt("COD_ALUNO"));
				agenda.setCodProfessor(resultSet.getInt("COD_PROFESSOR"));
				agenda.setOrdinalAula(resultSet.getInt("INSTRUMENTO"));
				agenda.setProgramacao(resultSet.getString("PROGRAMACAO"));

				ListAgenda.add(agenda);
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
		return ListAgenda;
	}

	/**
	 * Consulta Agenda por c�digo do Professor
	 * 
	 * @param codAluno
	 * @return
	 */
	public List<AgendaAula> consultarAgendaProfessor(int codProfessor) {
		List<AgendaAula> ListAgenda = new ArrayList<>();

		Connection conexao = null;
		try {
			conexao = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();

			sql.append("SELECT AG.ID_AGENDA, AG.DATAHORA, AG.COD_ALUNO, AG.COD_PROFESSOR, ");
			sql.append(" AG.INSTRUMENTO, PROGRAMACAO, PROF.NOME, ALU.NOME ");
			sql.append("	FROM TB_AGENDAAULA AG ");
			sql.append("		INNER JOIN TB_PROFESSOR PROF");
			sql.append(" 			INNER JOIN TB_ALUNO ALU ");
			sql.append("			ON AG.COD_PROFESSOR = PROF.ID_PROFESSOR ");
			sql.append(" 				AND AG.COD_ALUNO = ALU.ID_ALUNO ");
			sql.append(" 					WHERE COD_PROFESSOR = ? ");
			sql.append("						ORDER BY AG.DATAHORA");

			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			statement.setInt(1, codProfessor);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				AgendaAula agenda = new AgendaAula();
				agenda.setIdAgendaAula(resultSet.getInt("ID_AGENDA"));
				agenda.setDataHora(resultSet.getString("DATAHORA"));
				agenda.setCodAluno(resultSet.getInt("COD_ALUNO"));
				agenda.setCodProfessor(resultSet.getInt("COD_PROFESSOR"));
				agenda.setOrdinalAula(resultSet.getInt("INSTRUMENTO"));
				agenda.setProgramacao(resultSet.getString("PROGRAMACAO"));

				ListAgenda.add(agenda);
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
		return ListAgenda;
	}

	/**
	 * Consulta Agenda por c�digo do Professor
	 * 
	 * @param codAluno
	 * @return
	 */
	public List<AgendaAula> consultarAgendaGeral() {
		List<AgendaAula> ListAgenda = new ArrayList<>();

		Connection conexao = null;
		try {
			conexao = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();

			sql.append("SELECT AG.ID_AGENDA, AG.DATAHORA, AG.COD_ALUNO, AG.COD_PROFESSOR,  ");
			sql.append(" AG.INSTRUMENTO, PROGRAMACAO, PROF.NOME, ALU.NOME ");
			sql.append("	FROM TB_AGENDAAULA AG ");
			sql.append("		INNER JOIN TB_PROFESSOR PROF");
			sql.append(" 			INNER JOIN TB_ALUNO ALU ");
			sql.append("			ON AG.COD_PROFESSOR = PROF.ID_PROFESSOR ");
			sql.append(" 				AND AG.COD_ALUNO = ALU.ID_ALUNO ");
			sql.append("					ORDER BY AG.DATAHORA");

			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				AgendaAula agenda = new AgendaAula();
				agenda.setIdAgendaAula(resultSet.getInt("ID_AGENDA"));
				agenda.setDataHora(resultSet.getString("DATAHORA"));
				agenda.setCodAluno(resultSet.getInt("COD_ALUNO"));
				agenda.setCodProfessor(resultSet.getInt("COD_PROFESSOR"));
				agenda.setOrdinalAula(resultSet.getInt("INSTRUMENTO"));
				agenda.setProgramacao(resultSet.getString("PROGRAMACAO"));

				ListAgenda.add(agenda);
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
		return ListAgenda;
	}

	public void alterarAgenda(AgendaAula agenda) {

		Connection conexao = null;
		try {
			conexao = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();

			sql.append("UPDATE TB_AGENDAAULA ");
			sql.append(" SET DATAHORA = ?, COD_ALUNO = ?, COD_PROFESSOR = ?, INSTRUMENTO = ? , PROGRAMACAO = ? ");
			sql.append(" WHERE ID_AGENDA = ? ");

			PreparedStatement statement = conexao.prepareStatement(sql.toString());

			statement.setString(1, agenda.getDataHora());
			statement.setInt(2, agenda.getCodAluno());
			statement.setInt(3, agenda.getCodProfessor());
			statement.setInt(4, agenda.getOrdinalAula());
			statement.setString(5, agenda.getProgramacao());

			statement.setInt(6, agenda.getIdAgendaAula());

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

	public boolean removerAgenda(AgendaAula agenda) {

		Connection conexao = null;
		int cod_agendaAula = agenda.getIdAgendaAula();
		try {
			conexao = ConexaoUtil.getConexao();

			String sql = "DELETE TB_AGENDA_AULA WHERE ID_AGENDA = ? ";

			PreparedStatement statement = conexao.prepareStatement(sql);
			statement.setInt(1, cod_agendaAula);

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
