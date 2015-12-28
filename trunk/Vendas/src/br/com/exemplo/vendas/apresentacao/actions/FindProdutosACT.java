package br.com.exemplo.vendas.apresentacao.actions ;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.exemplo.vendas.apresentacao.service.ServiceReserva;
import br.com.exemplo.vendas.apresentacao.web.Action;
import br.com.exemplo.vendas.negocio.model.vo.ReservaVO;
import br.com.exemplo.vendas.util.exception.LayerException;

public class FindProdutosACT implements Action
{
	public String execute( HttpServletRequest request, HttpServletResponse response )
			throws LayerException{
		String idCliente = request.getParameter("idCliente");
		if(idCliente != null){
			ServiceReserva service = new ServiceReserva();
			List<ReservaVO> lista = service.listarPorCliente(new Integer(idCliente));
			request.getSession().setAttribute("reservaList", lista);
			System.out.println("Listando Reservas");
			return "inserirCompra.jsp?idCliente=" + idCliente;
		}
		return "erro.html";
	}
}