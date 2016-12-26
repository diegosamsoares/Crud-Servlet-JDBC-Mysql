package br.triadworks.javaweb.modelo;

import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.triadworks.javaweb.dao.CaloteiroDao;

public class ExcluiCaloteiroLogica implements Logica {
	
	public void executa(HttpServletRequest request , 
			HttpServletResponse response) throws Exception{
		
	
			
		Connection connection = (Connection) request.getAttribute("conexao");
		CaloteiroDao dao = new CaloteiroDao(connection);
			
		    dao.deleta(	dao.getCaloteiro(new Long(request.getParameter("id"))));	
			
			
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<body>");
			out.println("apaga");
			out.println("</body>");
			out.println("</html>");
		
	}

}
