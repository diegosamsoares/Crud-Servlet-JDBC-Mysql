package br.triadworks.javaweb.modelo;

import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.triadworks.javaweb.dao.UsuarioDao;

public class AutenticaUsuarioLogica  implements Logica{

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
			Usuario usuarioAutenticado = null;
			String login=request.getParameter("login");
			String senha=request.getParameter("senha");
			Connection connection = (Connection) request.getAttribute("conexao");		
			UsuarioDao dao = new UsuarioDao(connection);
			usuarioAutenticado = dao.autentica(login, senha);
			if (usuarioAutenticado != null) {
				RequestDispatcher rd = request.getRequestDispatcher("/adicionacaloteiro.jsp");
				HttpSession session= request.getSession();
				session.setAttribute("usuarioLogado", usuarioAutenticado);
		
				rd.forward(request, response);
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
				request.setAttribute("msgUsuario", "login ou senha invalidos");
				rd.forward(request, response);
				
			}
	}

}
