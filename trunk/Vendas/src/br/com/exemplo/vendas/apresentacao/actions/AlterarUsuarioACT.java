package br.com.exemplo.vendas.apresentacao.actions ;

import java.util.Date ;

import javax.servlet.http.HttpServletRequest ;
import javax.servlet.http.HttpServletResponse ;

import br.com.exemplo.vendas.apresentacao.service.ServiceUsuario ;
import br.com.exemplo.vendas.apresentacao.web.Action ;
import br.com.exemplo.vendas.negocio.model.vo.UsuarioVO ;
import br.com.exemplo.vendas.util.exception.LayerException ;

public class AlterarUsuarioACT implements Action
{

	public String execute( HttpServletRequest request, HttpServletResponse response )
			throws LayerException
	{
		String login = request.getParameter( "login" ) ;
		String senha = request.getParameter( "senha" ) ;
		String grupo = request.getParameter( "grupo" ) ;
		String perfil = request.getParameter( "perfil" ) ;
		String bloqueado = request.getParameter( "bloqueado" ) ;
		String nome = request.getParameter( "nome" ) ;

		UsuarioVO vo = new UsuarioVO( login, senha, grupo, perfil, bloqueado, new Date( ), nome ) ;

		ServiceUsuario service = new ServiceUsuario( ) ;
		Boolean sucesso = service.alterar( vo ) ;

		if (sucesso.booleanValue( ))
		{
			request.setAttribute( "sucesso", sucesso ) ;
		}
		return "index.html" ;
	}

}
