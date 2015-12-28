
package br.com.exemplo.vendas.apresentacao.service ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.exemplo.vendas.apresentacao.delegate.BusinessDelegate;
import br.com.exemplo.vendas.negocio.model.vo.ClienteVO;
import br.com.exemplo.vendas.negocio.model.vo.ReservaVO;
import br.com.exemplo.vendas.util.dto.ServiceDTO;
import br.com.exemplo.vendas.util.exception.LayerException;

public class ServiceReserva
{
	public Boolean inserir( ReservaVO vo ) throws LayerException
	{
		ServiceDTO requestDTO = new ServiceDTO( ) ;
		ServiceDTO responseDTO = new ServiceDTO( ) ;

		requestDTO.set( "ReservaVO", vo ) ;
		responseDTO = BusinessDelegate.getInstance( ).inserirReserva( requestDTO ) ;
		Boolean sucesso = ( Boolean ) responseDTO.get( "resposta" ) ;

		return sucesso ;
	}

	public List<ReservaVO> listar( ) throws LayerException
	{
		List<ReservaVO> lista = null;
		ServiceDTO requestDTO = new ServiceDTO( ) ;
		ServiceDTO responseDTO = new ServiceDTO( ) ;

		responseDTO = BusinessDelegate.getInstance( ).selectionarTodasReservas( requestDTO ) ;
		ReservaVO[ ] reservas = ( ReservaVO[ ] ) responseDTO.get( "listaReserva" ) ;
		if(reservas.length > 0){
			lista = new ArrayList();
			for (int i = 0; i < reservas.length; i++) {
				lista.add(reservas[i]);
			}
		}
		return lista;
	}

	public Boolean alterar( ReservaVO vo ) throws LayerException
	{
		ServiceDTO requestDTO = new ServiceDTO( ) ;
		ServiceDTO responseDTO = new ServiceDTO( ) ;

		requestDTO.set( "ReservaVO", vo ) ;
		responseDTO = BusinessDelegate.getInstance( ).alterarReserva( requestDTO ) ;
		Boolean sucesso = ( Boolean ) responseDTO.get( "resposta" ) ;

		return sucesso ;
	}

	public Boolean excluir( ReservaVO vo ) throws LayerException
	{
		ServiceDTO requestDTO = new ServiceDTO( ) ;
		ServiceDTO responseDTO = new ServiceDTO( ) ;

		requestDTO.set( "ReservaVO", vo ) ;
		responseDTO = BusinessDelegate.getInstance( ).excluirReserva( requestDTO ) ;
		Boolean sucesso = ( Boolean ) responseDTO.get( "resposta" ) ;

		return sucesso ;
	}
	
	public List<ReservaVO> listarPorCliente( Integer idCliente ) throws LayerException
	{
		ServiceDTO requestDTO = new ServiceDTO( ) ;
		ServiceDTO responseDTO = new ServiceDTO( ) ;
		ClienteVO clienteVO = new ClienteVO();
		clienteVO.setId(idCliente);
		requestDTO.set("clienteVO", clienteVO);
		responseDTO = BusinessDelegate.getInstance( ).listarPorCliente( requestDTO ) ;
		ReservaVO[ ] reservas = ( ReservaVO[ ] ) responseDTO.get( "listaReserva" ) ;
		List<ReservaVO> lista = Arrays.asList( reservas ) ;
		return lista ;
	}
	
	public ReservaVO[] pedidosDia() throws LayerException
	{
		ServiceDTO requestDTO = new ServiceDTO( ) ;
		ServiceDTO responseDTO = new ServiceDTO( ) ;
		responseDTO = BusinessDelegate.getInstance( ).pedidosDia( requestDTO ) ;
		ReservaVO[ ] reservas = ( ReservaVO[ ] ) responseDTO.get( "listaReserva" ) ;
		return reservas;
	}
		
}