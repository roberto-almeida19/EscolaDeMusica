package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import entidades.Endereco;
import util.ConexaoUtil;

public class EnderecoDAO {

	public Integer cadastrarEndereco(Endereco endereco) {
		Integer idGerado = null;
		Connection conexao = null;
		try {
			conexao = ConexaoUtil.getConexao();
			String sql = "INSERT INTO TB_ENDERECO(LOGRADOURO, NUMERO, COMPLEMENTO, BAIRRO, CIDADE) VALUES (? , ? , ?, ? )";

			PreparedStatement statement = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, endereco.getLogradouro());
			statement.setInt(2, endereco.getNumero());
			statement.setString(3, endereco.getComplemento());
			statement.setString(3, endereco.getBairro());

			statement.executeUpdate();

			ResultSet resultSet = statement.getGeneratedKeys();

			if (resultSet.first()) {
				idGerado = resultSet.getInt(1);
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
		return idGerado;
	}
	
	public Endereco consultarendereco(Endereco endereco) {
		Connection conexao = null;
		Endereco enderecox = new Endereco();
		try {
			conexao = ConexaoUtil.getConexao();
			String sql = "SELECT * FROM TB_ENDERECO WHERE ID_ENDERECO = ?";
			PreparedStatement statement = conexao.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();

			if(resultSet.first()){
				enderecox.setIdEndereco(resultSet.getInt("ID_ENDERECO"));
				enderecox.setLogradouro(resultSet.getString("LOGRADOURO"));
				enderecox.setNumero(resultSet.getInt("NUMERO"));
				enderecox.setComplemento(resultSet.getString("COMPLEMENTO"));
				enderecox.setBairro(resultSet.getString("BAIRRO"));
				enderecox.setCidade(resultSet.getString("CIDADE"));
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
		return enderecox;
	}

	public void atualizarendereco(Endereco endereco) {
		Connection conexao = null;
		try {
			conexao = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE TB_ENDERECO  ");
			sql.append("SET LOGRADOURO = ?, SET NUMERO = ?, SET COMPLEMENTO = ? SET BAIRRO = ? SET CIDADE = ? ");
			sql.append("WHERE COD_ENDERECO = ? ");
		
			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			statement.setString(1, endereco.getLogradouro());
			statement.setInt(2, endereco.getNumero());
			statement.setString(3, endereco.getComplemento());
			statement.setString(4, endereco.getBairro());
			statement.setString(5, endereco.getCidade());
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

	public boolean removerendereco(Integer idEndereco) {

		Connection conexao = null;
		try {
			conexao = ConexaoUtil.getConexao();

			String sql = "DELETE FROM TB_ENDERECO WHERE ID_ENDERECO = ? ";

			PreparedStatement statement = conexao.prepareStatement(sql);
			statement.setInt(1, idEndereco);

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
