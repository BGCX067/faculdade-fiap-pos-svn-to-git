package br.com.exemplo.vendas.apresentacao.actions ;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.exemplo.vendas.apresentacao.service.ServiceCompra;
import br.com.exemplo.vendas.apresentacao.web.Action;
import br.com.exemplo.vendas.negocio.model.vo.CompraVO;
import br.com.exemplo.vendas.util.exception.LayerException;

public class ListarCompraACT implements Action
{
	public String execute( HttpServletRequest request, HttpServletResponse response )
			throws LayerException
	{
		
		String page = request.getParameter("page");
		ServiceCompra service = new ServiceCompra( ) ;
		List<CompraVO> lista = service.listar( ) ;

		request.getSession( ).setAttribute( "listaCompras", lista ) ;

		return page;
	}
}
