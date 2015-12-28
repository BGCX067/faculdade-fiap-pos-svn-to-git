package br.com.exemplo.vendas.apresentacao.actions ;

import java.math.BigInteger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.exemplo.vendas.apresentacao.service.ServiceCompra;
import br.com.exemplo.vendas.apresentacao.web.Action;
import br.com.exemplo.vendas.negocio.model.vo.CompraVO;
import br.com.exemplo.vendas.util.exception.LayerException;

public class ExcluirReservaACT implements Action
{
	public String execute( HttpServletRequest request, HttpServletResponse response )
			throws LayerException
	{
		Integer numero = new Integer(request.getParameter("numero"));

		CompraVO vo = new CompraVO(numero);

		ServiceCompra service = new ServiceCompra( ) ;
		Boolean sucesso = service.excluir( vo ) ;

		if (sucesso.booleanValue( ))
		{
			request.setAttribute( "sucesso", sucesso ) ;
		}

		return "index.html" ;
	}

}
