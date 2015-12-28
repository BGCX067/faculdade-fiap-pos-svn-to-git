package br.com.exemplo.vendas.apresentacao.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.exemplo.vendas.apresentacao.service.ServiceReserva;
import br.com.exemplo.vendas.apresentacao.web.Action;
import br.com.exemplo.vendas.negocio.model.vo.ReservaVO;
import br.com.exemplo.vendas.util.exception.LayerException;

public class ListarReservaACT implements Action
{
	public String execute( HttpServletRequest request, HttpServletResponse response )
			throws LayerException
	{

		String page = request.getParameter("page");
		ServiceReserva service = new ServiceReserva( ) ;
		List<ReservaVO> lista = service.listar( );

		request.getSession( ).setAttribute( "listarReserva", lista ) ;

		return page;
	}
}
