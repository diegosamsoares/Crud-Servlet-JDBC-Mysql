package br.triadworks.javaweb.filtro;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import br.triadworks.javaweb.modelo.Usuario;
import javafx.scene.AccessibleAction;

@WebFilter(filterName="/FiltroAutorizacao" , urlPatterns="/*")
public class FiltroAutorizacao implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
	
		String uri= req.getRequestURI();
		String acao = req.getParameter("acao");
		if(acao==null){
			acao="";
		}
		
		if( uri.equals("login.jsp") ||acao.endsWith("AutenticaUsuario")){
				request.setAttribute("usuarioLogado", null);
			chain.doFilter(request, response);
		}else{
			Usuario usuariologado=(Usuario) req.getSession().getAttribute("usuarioLogado");
			if(usuariologado!=null ){
				chain.doFilter(request, response);
			}else{
				RequestDispatcher rd= request.getRequestDispatcher("/login.jsp");
				request.setAttribute("msgUsuario", "Faça o login para entrar no sistema");
				rd.forward(request, response);
			}
		}
		
		
		
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
