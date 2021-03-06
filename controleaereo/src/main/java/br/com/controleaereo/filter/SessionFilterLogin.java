package br.com.controleaereo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.controleaereo.bean.Usuario;

@WebFilter(urlPatterns={"/login.jsf"})
public class SessionFilterLogin implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpServletResponse httpRes = (HttpServletResponse) response;

		HttpSession session = httpReq.getSession();
		Usuario user = (Usuario) session.getAttribute("userSession");
		
		if (user != null) {
			if ("adm".equals(user.getNivel())) {
				httpRes.sendRedirect("PaginasAdm/menuAdm.jsf");
			} else {
				httpRes.sendRedirect("paginas/menuUsuario.jsf");
			}
		}else{
			chain.doFilter(request, response);
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
