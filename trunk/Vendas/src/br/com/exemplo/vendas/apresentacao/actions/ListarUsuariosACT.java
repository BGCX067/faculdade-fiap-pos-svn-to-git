package br.com.exemplo.vendas.apresentacao.actions ;

import java.util.List ;

import javax.servlet.http.HttpServletRequest ;
import javax.servlet.http.HttpServletResponse ;

import br.com.exemplo.vendas.apresentacao.service.ServiceUsuario ;
import br.com.exemplo.vendas.apresentacao.web.Action ;
import br.com.exemplo.vendas.negocio.model.vo.UsuarioVO ;
import br.com.exemplo.vendas.util.exception.LayerException ;

public class ListarUsuariosACT implements Action
{
	public String execute( HttpServletRequest request, HttpServletResponse response )
			throws LayerException
	{

		ServiceUsuario service = new ServiceUsuario( ) ;
		List<UsuarioVO> lista = service.listar( ) ;

		request.getSession( ).setAttribute( "listaUsuarios", lista ) ;

		return "cadastroCliente.jsp" ;
	}
}
