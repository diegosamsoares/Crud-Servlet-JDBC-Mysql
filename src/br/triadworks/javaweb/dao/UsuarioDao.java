package br.triadworks.javaweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import br.triadworks.javaweb.modelo.Usuario;

public class UsuarioDao {
	private Connection conexao;
	public UsuarioDao (Connection connection) {
		this.conexao = connection;
		
	}
	
public Usuario autentica(String login, String senha) {
	try {
		PreparedStatement ps = this.conexao.prepareStatement("select * from usuario "
				+ "where login =? and senha = ?");
		ps.setString(1, login);
		ps.setString(2, senha);
		Usuario usuario = null;
		ResultSet rs = ps.executeQuery();
		
		if (rs.next()){
			
			Long id = rs.getLong("id");
			String nome = rs.getString("nome");
			String uLogin = rs.getString("login");
			String uSenha = rs.getString("senha");
			
			usuario = new Usuario();
			usuario.setId(id);
			usuario.setLogin(uLogin);
			usuario.setNome(nome);
			usuario.setSenha(uSenha);
			
		}
		rs.close();
		ps.close();
		return usuario;
		
	} catch (Exception e) {
		throw new RuntimeException(e);
	}
	
}
}
