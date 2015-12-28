package br.com.exemplo.vendas.apresentacao.service ;

import java.util.Arrays;
import java.util.List;

import br.com.exemplo.vendas.apresentacao.delegate.BusinessDelegate;
import br.com.exemplo.vendas.negocio.model.vo.ItemVO;
import br.com.exemplo.vendas.util.dto.ServiceDTO;
import br.com.exemplo.vendas.util.exception.LayerException;

public class ServiceItem
{
	public Boolean inserir( ItemVO vo ) throws LayerException
	{
		ServiceDTO requestDTO = new ServiceDTO( ) ;
		ServiceDTO responseDTO = new ServiceDTO( ) ;

		requestDTO.set( "ItemVO", vo ) ;
		responseDTO = BusinessDelegate.getInstance( ).inserirItem( requestDTO ) ;
		Boolean sucesso = ( Boolean ) responseDTO.get( "resposta" ) ;

		return sucesso ;
	}

	public List<ItemVO> listar( ) throws LayerException
	{
		ServiceDTO requestDTO = new ServiceDTO( ) ;
		ServiceDTO responseDTO = new ServiceDTO( ) ;

		responseDTO = BusinessDelegate.getInstance( ).selectionarTodosItems( requestDTO ) ;
		ItemVO[ ] items = ( ItemVO[ ] ) responseDTO.get( "listaItem" ) ;
		List<ItemVO> lista = Arrays.asList( items ) ;
		return lista ;
	}

	public Boolean alterar( ItemVO vo ) throws LayerException
	{
		ServiceDTO requestDTO = new ServiceDTO( ) ;
		ServiceDTO responseDTO = new ServiceDTO( ) ;

		requestDTO.set( "ItemVO", vo ) ;
		responseDTO = BusinessDelegate.getInstance( ).alterarItem( requestDTO ) ;
		Boolean sucesso = ( Boolean ) responseDTO.get( "resposta" ) ;

		return sucesso ;
	}

	public Boolean excluir( ItemVO vo ) throws LayerException
	{
		ServiceDTO requestDTO = new ServiceDTO( ) ;
		ServiceDTO responseDTO = new ServiceDTO( ) ;

		requestDTO.set( "ItemVO", vo ) ;
		responseDTO = BusinessDelegate.getInstance( ).excluirItem( requestDTO ) ;
		Boolean sucesso = ( Boolean ) responseDTO.get( "resposta" ) ;

		return sucesso ;
	}
}