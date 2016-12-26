package br.triadworks.javaweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/OlaMundo")
public class MinhaPrimeiraServlet extends HttpServlet{
	
@Override
public void service(ServletRequest request, ServletResponse response)
		throws ServletException, IOException {
	PrintWriter sysout = response.getWriter();
	sysout.println("<html>");
	sysout.println("<body>");
	sysout.println("Ebaa, meu primeiro servlet");
	sysout.println("</body>");
	sysout.println("</html>");
	
	
}

}
