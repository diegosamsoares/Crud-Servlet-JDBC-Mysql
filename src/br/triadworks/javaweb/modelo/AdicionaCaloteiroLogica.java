package br.triadworks.javaweb.modelo;

import java.io.PrintWriter;
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

public class AdicionaCaloteiroLogica implements Logica{
	
	public void executa(HttpServletRequest request , 
			HttpServletResponse response) throws Exception{
		

		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String devendo = request.getParameter("devendo");
		String dataDivida=request.getParameter("dataDivida");
		Calendar dataConvertida = null;
		PrintWriter out = response.getWriter();
		Caloteiro caloteiro = new Caloteiro();
		try {
			Date data = new SimpleDateFormat("dd/MM/yyyy").parse(dataDivida);
		    dataConvertida = Calendar.getInstance();
			dataConvertida.setTime(data);
			caloteiro.setDataDivida(dataConvertida);
		} catch (ParseException e) {
			out.println("Erro na conversão de data");
			throw new CaloteiroServletException();
		}
		
		
	
		
		caloteiro.setNome(nome);
		caloteiro.setEmail(email);
		caloteiro.setDevendo(new Double(devendo));
		
		Connection connection = (Connection) request.getAttribute("conexao");
		CaloteiroDao dao = new CaloteiroDao(connection);
		dao.adiciona(caloteiro);
		
		RequestDispatcher rd = 
				request.getRequestDispatcher("/caloteiro-adicionado.jsp");
				rd.forward(request, response);			
		
	
		
	}

}
