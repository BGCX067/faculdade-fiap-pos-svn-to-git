package br.com.exemplo.vendas.apresentacao.actions;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.exemplo.vendas.apresentacao.service.ServiceProduto;
import br.com.exemplo.vendas.apresentacao.web.Action;
import br.com.exemplo.vendas.negocio.model.vo.ProdutoVO;
import br.com.exemplo.vendas.util.exception.LayerException;

public class AlterarProdutoACT implements Action
{

	public String execute( HttpServletRequest request, HttpServletResponse response )
			throws LayerException
	{
		Integer codigo = new Integer(request.getParameter( "codigo" )) ;
		String descricao = request.getParameter( "descricao" ) ;
		BigDecimal preco = new BigDecimal(request.getParameter( "preco" )) ;
		String estoque = request.getParameter( "estoque" ) ;

		ProdutoVO vo = new ProdutoVO( codigo, descricao, preco, estoque ) ;

		ServiceProduto service = new ServiceProduto( ) ;
		Boolean sucesso = service.alterar( vo ) ;

		if (sucesso.booleanValue( ))
		{
			request.setAttribute( "sucesso", sucesso ) ;
		}
		return "index.html" ;
	}

}
