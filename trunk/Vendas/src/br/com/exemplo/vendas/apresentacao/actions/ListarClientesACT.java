package br.com.exemplo.vendas.apresentacao.actions ;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.exemplo.vendas.apresentacao.service.ServiceCliente;
import br.com.exemplo.vendas.apresentacao.web.Action;
import br.com.exemplo.vendas.negocio.model.vo.ClienteVO;
import br.com.exemplo.vendas.util.exception.LayerException;

public class ListarClientesACT implements Action
{
	public String execute( HttpServletRequest request, HttpServletResponse response )
			throws LayerException
	{

		ServiceCliente service = new ServiceCliente( ) ;
		List<ClienteVO> lista = service.listar( ) ;
		if(lista != null){
			request.getSession( ).setAttribute( "listaClientes", lista) ;
		}
		System.out.println("Listando Clientes");
		if("inserirReserva".equals(request.getParameter("page"))){
			return "inserirReserva.jsp" ;	
		}else if("inserirCompra".equals(request.getParameter("page"))){
			return "inserirCompra.jsp" ;
		}else{
			return "";
		}
		
	}
}