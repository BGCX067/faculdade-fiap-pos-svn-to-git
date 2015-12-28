package br.com.exemplo.vendas.apresentacao.actions;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.exemplo.vendas.apresentacao.service.ServiceCompra;
import br.com.exemplo.vendas.apresentacao.service.ServiceItem;
import br.com.exemplo.vendas.apresentacao.web.Action;
import br.com.exemplo.vendas.negocio.entity.Compra;
import br.com.exemplo.vendas.negocio.entity.Produto;
import br.com.exemplo.vendas.negocio.entity.Reserva;
import br.com.exemplo.vendas.negocio.model.vo.ItemVO;
import br.com.exemplo.vendas.util.exception.LayerException;

@SuppressWarnings("unused")
public class InserirItemACT implements Action
{
	public String execute( HttpServletRequest request, HttpServletResponse response )
			throws LayerException
	{
		String quantidade = request.getParameter( "quantidade" );
		String valor = request.getParameter( "valor" );
		String situacao = request.getParameter( "situacao" );
		
		String numeroReserva = request.getParameter( "reserva" );
		String numeroCompra = request.getParameter( "compra" );
		String numeroProduto = request.getParameter( "produto" );

		ServiceCompra serviceCompra = new ServiceCompra( );
		
		Compra compra = new Compra(new Integer(numeroCompra));
		Reserva reserva = new Reserva(new Integer(numeroReserva));
		Produto produto = new Produto(new Integer(numeroProduto));
		
		ServiceItem service = new ServiceItem();
		
		ItemVO itemVO = new ItemVO(new BigInteger(quantidade), new BigDecimal(
				valor), situacao, reserva, compra, produto, null);

		Boolean sucesso = service.inserir( itemVO ) ;

		if (sucesso.booleanValue( ))
		{
			request.setAttribute( "sucesso", sucesso ) ;
		}
		return "index.html" ;
	}
}
