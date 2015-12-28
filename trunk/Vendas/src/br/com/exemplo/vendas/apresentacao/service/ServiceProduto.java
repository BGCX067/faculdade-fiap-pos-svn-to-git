package br.com.exemplo.vendas.apresentacao.service ;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import br.com.exemplo.vendas.apresentacao.delegate.BusinessDelegate;
import br.com.exemplo.vendas.negocio.entity.Produto;
import br.com.exemplo.vendas.negocio.model.vo.ProdutoVO;
import br.com.exemplo.vendas.util.dto.ServiceDTO;
import br.com.exemplo.vendas.util.exception.LayerException;

public class ServiceProduto
{
	public Boolean inserir( ProdutoVO vo ) throws LayerException
	{
		ServiceDTO requestDTO = new ServiceDTO( ) ;
		ServiceDTO responseDTO = new ServiceDTO( ) ;

		requestDTO.set( "ProdutoVO", vo ) ;
		responseDTO = BusinessDelegate.getInstance( ).inserirProduto( requestDTO ) ;
		Boolean sucesso = ( Boolean ) responseDTO.get( "resposta" ) ;

		return sucesso ;
	}

	public List<ProdutoVO> listar( ) throws LayerException
	{
		ServiceDTO requestDTO = new ServiceDTO( ) ;
		ServiceDTO responseDTO = new ServiceDTO( ) ;

		responseDTO = BusinessDelegate.getInstance( ).selectionarTodosProdutos( requestDTO ) ;
		ProdutoVO[ ] produtos = ( ProdutoVO[ ] ) responseDTO.get( "listaProduto" ) ;
		List<ProdutoVO> lista = Arrays.asList( produtos ) ;
		return lista ;
	}

	public Boolean alterar( ProdutoVO vo ) throws LayerException
	{
		ServiceDTO requestDTO = new ServiceDTO( ) ;
		ServiceDTO responseDTO = new ServiceDTO( ) ;

		requestDTO.set( "ProdutoVO", vo ) ;
		responseDTO = BusinessDelegate.getInstance( ).alterarProduto( requestDTO ) ;
		Boolean sucesso = ( Boolean ) responseDTO.get( "resposta" ) ;

		return sucesso ;
	}

	public Boolean excluir( ProdutoVO vo ) throws LayerException
	{
		ServiceDTO requestDTO = new ServiceDTO( ) ;
		ServiceDTO responseDTO = new ServiceDTO( ) ;

		requestDTO.set( "ProdutoVO", vo ) ;
		responseDTO = BusinessDelegate.getInstance( ).excluirProduto( requestDTO ) ;
		Boolean sucesso = ( Boolean ) responseDTO.get( "resposta" ) ;

		return sucesso ;
	}
	
	public ProdutoVO[] listarPorPrecoEstoque() throws LayerException
	{
		ServiceDTO requestDTO = new ServiceDTO( ) ;
		ServiceDTO responseDTO = new ServiceDTO( ) ;

		responseDTO = BusinessDelegate.getInstance( ).listarPorPrecoEstoque( requestDTO ) ;
		ProdutoVO[ ] produtos = ( ProdutoVO[ ] ) responseDTO.get( "listaProduto" ) ;
		return produtos;
	}
	
	
}