package br.com.exemplo.vendas.apresentacao.actions;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.exemplo.vendas.apresentacao.service.ServiceProduto;
import br.com.exemplo.vendas.apresentacao.web.Action;
import br.com.exemplo.vendas.negocio.model.vo.ProdutoVO;
import br.com.exemplo.vendas.util.exception.LayerException;

@SuppressWarnings("unused")
public class InserirProdutoACT implements Action
{
	public String execute( HttpServletRequest request, HttpServletResponse response )
			throws LayerException
	{
		String descricao = request.getParameter( "descricao" );
		String estoque = request.getParameter( "estoque" );
		String preco = request.getParameter( "preco" );

		ProdutoVO produtoVO = new ProdutoVO();
		produtoVO.setDescricao(descricao);
		produtoVO.setEstoque(estoque);
		produtoVO.setPreco(new BigDecimal(preco));
		
		ServiceProduto service = new ServiceProduto( ) ;
		Boolean sucesso = service.inserir( produtoVO ) ;

		if (sucesso.booleanValue( ))
		{
			request.setAttribute( "sucesso", sucesso ) ;
		}
		return "index.html" ;
	}
}
