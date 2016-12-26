package br.triadworks.javaweb.modelo;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.triadworks.javaweb.dao.CaloteiroDao;
import br.triadworks.javaweb.servlet.CaloteiroServletException;

public class AtualizaCaloteiroLogica implements Logica{

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
	
		String id = request.getParameter("id");
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String devendo = request.getParameter("devendo");
		String dataDivida = request.getParameter("dataDivida");
		Caloteiro caloteiro = new Caloteiro();
		Calendar dataConvertida = null;
		try {
			Date data = new SimpleDateFormat("dd/MM/yyyy")
					.parse(dataDivida);
			dataConvertida = Calendar.getInstance();
			dataConvertida.setTime(data);
			caloteiro.setDataDivida(dataConvertida);
		} catch (ParseException e) {
			throw new CaloteiroServletException();
		}

		Connection connection = (Connection) request.getAttribute("conexao");
		CaloteiroDao dao = new CaloteiroDao(connection);
        caloteiro.setId(new Long(id));
		caloteiro.setNome(nome);
		caloteiro.setEmail(email);
		caloteiro.setDevendo(new Integer(devendo));

		dao.altera(caloteiro);
		
		
		
	}

}
