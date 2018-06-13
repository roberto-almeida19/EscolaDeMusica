package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import entidades.InstrumentoAula;
import util.ConexaoUtil;

public class InstrumentoAulaDAO {
	
	

	/**
	 * Cadastra habilita��es de professores 
	 * 
	 * Cadastra matr�culas de alunos 
	 * 
	 * @param lista
	 * @param codigo
	 */

	public void cadastrarInstrumentoAula(Set<Integer> lista, Integer codigo) {
		Connection conexao = null;
		try {
			conexao = ConexaoUtil.getConexao();

			String sql = "INSERT INTO TB_INSTRUMENTO_USUARIOS VALUES (?, ? )";

			for (Integer aula : lista) {
				PreparedStatement statement = conexao.prepareStatement(sql);
				statement.setInt(1, aula);
				statement.setInt(2, codigo);

				statement.executeUpdate();
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				conexao.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void removerListaInstrumentoAula(Integer codigo){
		Connection conexao = null;

		try {
			conexao = ConexaoUtil.getConexao();		
			String sql = "DELETE FROM TB_INSTRUMENTO_USUARIO WHERE ID_USUARIO = ? ";
			PreparedStatement statement = conexao.prepareStatement(sql);
			
			statement.execute();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				conexao.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Consulta Lista de Habilita��es do Professor
	 * 
	 * @param idProfessor
	 * @return
	 */
	public List<InstrumentoAula> consultarInstrumentoAulaProf(Integer idProfessor) {
		List<InstrumentoAula> listaInstrumentoAula = new ArrayList<>();

		Connection conexao = null;
		try {
			conexao = ConexaoUtil.getConexao();

			StringBuilder sql = new StringBuilder();
			sql.append("SELECT INSTR.ID_INSTRUMENTO, INSTRU.DESCRICAO FROM TB_INSTRUMENTO INSTRU");
			sql.append("	INNER JOIN TB_INSTRUMENTO_USUARIO INSTRUSU");
			sql.append("		ON INSTRU.ID_INSTRUMENTO = INSTRUSU.ID_INSTRUMENTO");
			sql.append("	INNER JOIN TB_PROFESSOR PROF");
			sql.append("		ON PROF.ID_PROFESSOR = INSTRUSU.ID_USUARIO ");
			sql.append(" WHERE PROF.ID_PROFESSOR = ?");

			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			statement.setInt(1, idProfessor);

			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				InstrumentoAula instrumentoAula = new InstrumentoAula();
				instrumentoAula.setInstruAula(resultSet.getInt("id_InstrAula"));
				instrumentoAula.setDescricao(resultSet.getString("descricao"));

				listaInstrumentoAula.add(instrumentoAula);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				conexao.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listaInstrumentoAula;
	}

	/**
	 * Consulta Lista de Instrumentos
	 * 
	 * @param idAluno
	 * @return
	 */

	public List<InstrumentoAula> consultarInstrumentoAulaAluno(Integer idObjeto) {
		List<InstrumentoAula> listaInstrumentoAula = new ArrayList<>();

		Connection conexao = null;
		try {
			conexao = ConexaoUtil.getConexao();

			StringBuilder sql = new StringBuilder();
			sql.append("SELECT INSTR.ID_INSTRUMENTO, INSTRU.DESCRICAO FROM TB_INSTRUMENTO INSTRU");
			sql.append("	INNER JOIN TB_INSTRUMENTO_USUARIO INSTRUSU");
			sql.append("		ON INSTRU.ID_INSTRUMENTO = INSTRUSU.ID_INSTRUMENTO");
			sql.append("	INNER JOIN TB_ALUNO ALU");
			sql.append("		ON ALU.ID_ALUNO = INSTRUSU.ID_USUARIO ");
			sql.append(" WHERE ALU.ID_ALUNO = ?");

			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			statement.setInt(1, idObjeto);

			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				InstrumentoAula instrumentoAula = new InstrumentoAula();
				instrumentoAula.setInstruAula(resultSet.getInt("id_InstrAula"));
				instrumentoAula.setDescricao(resultSet.getString("descricao"));

				listaInstrumentoAula.add(instrumentoAula);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				conexao.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listaInstrumentoAula;
	}
}
