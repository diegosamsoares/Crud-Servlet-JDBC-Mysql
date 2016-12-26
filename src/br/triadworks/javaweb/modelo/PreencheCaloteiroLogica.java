package br.triadworks.javaweb.modelo;

import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.triadworks.javaweb.dao.CaloteiroDao;

public class PreencheCaloteiroLogica implements Logica{

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		Connection connection = (Connection) request.getAttribute("conexao");
		CaloteiroDao dao = new CaloteiroDao(connection);
		Caloteiro caloteiro = null;
		caloteiro = dao.getCaloteiro(new Long(request.getParameter("id")));

		request.setAttribute("caloteiro", caloteiro);

		RequestDispatcher rd =

		request.getRequestDispatcher("/atualizacaloteiro.jsp");
		rd.forward(request, response);
	}

}
