package br.com.exemplo.vendas.apresentacao.actions;

import java.math.BigInteger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.exemplo.vendas.apresentacao.service.ServiceProduto;
import br.com.exemplo.vendas.apresentacao.web.Action;
import br.com.exemplo.vendas.negocio.model.vo.ProdutoVO;
import br.com.exemplo.vendas.util.exception.LayerException;

public class ExcluirProdutoACT implements Action
{
	public String execute( HttpServletRequest request, HttpServletResponse response )
			throws LayerException
	{
		String codigo = request.getParameter( "codigo" ) ;


		ProdutoVO vo = new ProdutoVO(new Integer(codigo));

		ServiceProduto service = new ServiceProduto( ) ;
		Boolean sucesso = service.excluir( vo ) ;

		if (sucesso.booleanValue( ))
		{
			request.setAttribute( "sucesso", sucesso ) ;
		}

		return "index.html" ;
	}

}
