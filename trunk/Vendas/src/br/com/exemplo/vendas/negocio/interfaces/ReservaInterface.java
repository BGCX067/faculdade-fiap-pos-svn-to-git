package br.com.exemplo.vendas.negocio.interfaces ;


public interface ReservaInterface
{
	public br.com.exemplo.vendas.util.dto.ServiceDTO inserirReserva(
			br.com.exemplo.vendas.util.dto.ServiceDTO requestDTO )
			throws br.com.exemplo.vendas.util.exception.LayerException, java.rmi.RemoteException ;

	public br.com.exemplo.vendas.util.dto.ServiceDTO alterarReserva(
			br.com.exemplo.vendas.util.dto.ServiceDTO requestDTO )
			throws br.com.exemplo.vendas.util.exception.LayerException, java.rmi.RemoteException ;

	public br.com.exemplo.vendas.util.dto.ServiceDTO excluirReserva(
			br.com.exemplo.vendas.util.dto.ServiceDTO requestDTO )
			throws br.com.exemplo.vendas.util.exception.LayerException, java.rmi.RemoteException ;

	public br.com.exemplo.vendas.util.dto.ServiceDTO selecionarTodasReservas(
			br.com.exemplo.vendas.util.dto.ServiceDTO requestDTO )
			throws br.com.exemplo.vendas.util.exception.LayerException, java.rmi.RemoteException ;

	public br.com.exemplo.vendas.util.dto.ServiceDTO getReserva(
			br.com.exemplo.vendas.util.dto.ServiceDTO requestDTO, Integer codigo )
			throws br.com.exemplo.vendas.util.exception.LayerException, java.rmi.RemoteException ;
	
	public br.com.exemplo.vendas.util.dto.ServiceDTO listarPorCliente(
			br.com.exemplo.vendas.util.dto.ServiceDTO requestDTO )
			throws br.com.exemplo.vendas.util.exception.LayerException, java.rmi.RemoteException ;
	
	public br.com.exemplo.vendas.util.dto.ServiceDTO pedidosDia(
			br.com.exemplo.vendas.util.dto.ServiceDTO requestDTO )
			throws br.com.exemplo.vendas.util.exception.LayerException, java.rmi.RemoteException ;
	
}
