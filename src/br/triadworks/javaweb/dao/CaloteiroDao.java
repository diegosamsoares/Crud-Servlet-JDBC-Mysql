package br.triadworks.javaweb.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.triadworks.javaweb.modelo.Caloteiro;



public class CaloteiroDao {

	private Connection conexao;

	public CaloteiroDao(Connection connection) {
		this.conexao = connection;
		
	}

	public List<Caloteiro> getLista() {
		try {
			PreparedStatement ps = this.conexao
					.prepareStatement("select * from caloteiro");
			List<Caloteiro> caloteiros = new ArrayList<Caloteiro>();
			Caloteiro caloteiro = null;
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Long id = rs.getLong("id");
				String nome = rs.getString("Nome");
				String email = rs.getString("email");
				double devendo = rs.getDouble("devendo");
		
				Calendar dataDivida = Calendar.getInstance();
				dataDivida.setTime(rs.getDate("dataDivida"));

				caloteiro = new Caloteiro();
				caloteiro.setId(id);
				caloteiro.setNome(nome);
				caloteiro.setDevendo(devendo);
				caloteiro.setEmail(email);
				caloteiro.setDataDivida(dataDivida);
				caloteiros.add(caloteiro);
				

			}
			rs.close();
			ps.close();
			return caloteiros;

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	public void altera(Caloteiro caloteiro) {
		String sql = "update caloteiro set nome=? , email=? , devendo=? , dataDivida=? where id=?";
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, caloteiro.getNome());
			ps.setString(2, caloteiro.getEmail());
			ps.setDouble(3, caloteiro.getDevendo());
			ps.setDate(4, new Date(caloteiro.getDataDivida().getTimeInMillis()));
			ps.setLong(5, caloteiro.getId());
			ps.execute();
			ps.close();

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void deleta(Caloteiro caloteiro) {
		String sql = ("delete from caloteiro where id=?");
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setLong(1, caloteiro.getId());
			ps.execute();
			ps.close();

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void adiciona(Caloteiro caloteiro) {
		String sql = "insert into caloteiro"
				+ "(nome , email, devendo , dataDivida)" + "values(?,?,?,?)";
		try {
			PreparedStatement pstmt = conexao.prepareStatement(sql);

			pstmt.setString(1, caloteiro.getNome());
			pstmt.setString(2, caloteiro.getEmail());
			pstmt.setDouble(3, caloteiro.getDevendo());
			//System.out.println(caloteiro.getDataDivida().getTimeInMillis());
			pstmt.setDate(4, new Date(caloteiro.getDataDivida().getTimeInMillis()));
			pstmt.execute();
			pstmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
	public Caloteiro getCaloteiro(long id){
		try {
			
			PreparedStatement ps = this.conexao.prepareStatement("select * from caloteiro where id=?");
			ps.setLong(1, id);
			
			Caloteiro caloteiro = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()){
				long idCaloteiro = rs.getLong("id");
				String nome = rs.getString("nome");
				String email = rs.getString("email");
				int devendo = rs.getInt("devendo");
				Calendar dataDivida = Calendar.getInstance();
				dataDivida.setTime(rs.getDate("datadivida"));
				
				caloteiro = new Caloteiro();
				caloteiro.setId(idCaloteiro);
				caloteiro.setNome(nome);
				caloteiro.setEmail(email);
				caloteiro.setDevendo(devendo);
				caloteiro.setDataDivida(dataDivida);
				
			}
			rs.close();
			ps.close();
			return caloteiro;
			
			
			
		} catch (Exception e) {

		throw new RuntimeException(e);
		}
		
		
		
		
	}

}
