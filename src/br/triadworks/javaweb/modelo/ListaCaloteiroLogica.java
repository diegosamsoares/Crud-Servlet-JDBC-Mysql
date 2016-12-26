package br.triadworks.javaweb.modelo;

import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.triadworks.javaweb.dao.CaloteiroDao;

public class ListaCaloteiroLogica implements Logica{

	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
	
		Connection connection = (Connection) request.getAttribute("conexao");
		CaloteiroDao dao = new CaloteiroDao(connection);
		List<Caloteiro> lista = dao.getLista();
		request.setAttribute("lista", lista);

		RequestDispatcher rd =

		request.getRequestDispatcher("/listaCaloteirosJSTL.jsp");
		rd.forward(request, response);
	}
}
