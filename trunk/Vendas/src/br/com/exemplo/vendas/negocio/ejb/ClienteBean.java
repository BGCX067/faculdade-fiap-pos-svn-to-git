package br.com.exemplo.vendas.negocio.ejb;

import java.rmi.RemoteException;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.exemplo.vendas.negocio.dao.DaoFactory;
import br.com.exemplo.vendas.negocio.ejb.interfaces.ClienteLocal;
import br.com.exemplo.vendas.negocio.ejb.interfaces.ClienteRemote;
import br.com.exemplo.vendas.negocio.entity.Cliente;
import br.com.exemplo.vendas.negocio.entity.ClienteFisico;
import br.com.exemplo.vendas.negocio.entity.ClienteJuridico;
import br.com.exemplo.vendas.negocio.model.vo.ClienteFisicoVO;
import br.com.exemplo.vendas.negocio.model.vo.ClienteJuridicoVO;
import br.com.exemplo.vendas.negocio.model.vo.ClienteVO;
import br.com.exemplo.vendas.util.dto.ServiceDTO;
import br.com.exemplo.vendas.util.exception.LayerException;

@Stateless
public class ClienteBean implements ClienteRemote, ClienteLocal {
	@PersistenceContext(unitName = "Vendas")
	EntityManager em;

	public ServiceDTO inserirCliente(ServiceDTO requestDTO)
			throws LayerException {
		ServiceDTO responseDTO = new ServiceDTO();
		ClienteVO vo = (ClienteVO) requestDTO.get("ClienteVO");
		if (vo != null) {
			Cliente cliente = new Cliente();
			cliente.setEndereco(vo.getEndereco());
			cliente.setNome(vo.getNome());
			cliente.setSituacao(vo.getSituacao());
			cliente.setTelefone(vo.getTelefone());
			Boolean result = false;
			if(vo instanceof ClienteFisicoVO){
				ClienteFisico clienteFisico = new ClienteFisico(cliente);
				clienteFisico.setCPF(((ClienteFisicoVO) vo).getCpf());
				clienteFisico.setRG(((ClienteFisicoVO) vo).getRG());
				result = DaoFactory.getClienteDAO(em).inserir(clienteFisico);
			}
			if(vo instanceof ClienteJuridicoVO){
				ClienteJuridico clienteJuridico = new ClienteJuridico(cliente);
				clienteJuridico.setCNPJ(((ClienteJuridicoVO) vo).getCnpj());
				clienteJuridico.setIE(((ClienteJuridicoVO) vo).getIe());				
				result = DaoFactory.getClienteDAO(em).inserir(clienteJuridico);
			}
			responseDTO.set("resposta", result);

		}
		return responseDTO;
	}

	public ServiceDTO alterarCliente(ServiceDTO requestDTO)
			throws LayerException {
		ServiceDTO responseDTO = new ServiceDTO();
		ClienteVO vo = (ClienteVO) requestDTO.get("ClienteVO");
		if (vo != null) {
			Cliente cliente = new Cliente(vo.getId(), vo.getNome(),
					vo.getEndereco(), vo.getTelefone(), vo.getSituacao());
			if (DaoFactory.getClienteDAO(em).alterar(cliente)) {
				responseDTO.set("resposta", new Boolean(true));
			} else {
				responseDTO.set("resposta", new Boolean(false));
			}
		}
		return responseDTO;
	}

	public ServiceDTO excluirCliente(ServiceDTO requestDTO)
			throws LayerException {
		ServiceDTO responseDTO = new ServiceDTO();
		ClienteVO vo = (ClienteVO) requestDTO.get("ClienteVO");
		if (vo != null) {
			Cliente cliente = new Cliente();
			cliente.setId(vo.getId());
			if (DaoFactory.getClienteDAO(em).excluir(cliente)) {
				responseDTO.set("resposta", new Boolean(true));
			} else {
				responseDTO.set("resposta", new Boolean(false));
			}
		}
		return responseDTO;
	}

	public ServiceDTO selecionarTodosCliente(ServiceDTO requestDTO)
			throws LayerException {
		ServiceDTO responseDTO = new ServiceDTO();
		Cliente cliente = null;
		List<Cliente> lista = DaoFactory.getClienteDAO(em).listar();
		if ((lista != null) && (!lista.isEmpty())) {
			ClienteVO[] clientes = new ClienteVO[lista.size()];
			for (int i = 0; i < lista.size(); i++) {
				cliente = (Cliente) lista.get(i);
				ClienteVO clienteVO = new ClienteVO(cliente.getId(),
						cliente.getNome(), cliente.getEndereco(),
						cliente.getTelefone(), cliente.getSituacao());
				clientes[i] = clienteVO;
			}
			responseDTO.set("listaCliente", clientes);
		}
		return responseDTO;
	}

	public ServiceDTO find(ServiceDTO requestDTO) throws LayerException {
		ServiceDTO responseDTO = new ServiceDTO();
		ClienteVO vo = (ClienteVO) responseDTO.get("ClienteVO");
		Cliente cliente = new Cliente();
		cliente.setId(vo.getId());
		Cliente lista = DaoFactory.getClienteDAO(em).find(cliente);
		if (lista != null) {
			cliente = (Cliente) lista;
			ClienteVO clienteVO = new ClienteVO(cliente.getId(),
					cliente.getNome(), cliente.getEndereco(),
					cliente.getTelefone(), cliente.getSituacao());
			responseDTO.set("getCliente", clienteVO);
		}
		return responseDTO;
	}
	
	
	public ServiceDTO selecionarClientesComCompra(ServiceDTO requestDTO)
			throws LayerException {
		ServiceDTO responseDTO = new ServiceDTO();
		Cliente cliente = null;
		List<Cliente> lista = DaoFactory.getClienteDAO(em).selecionarClientesComCompra();
		if ((lista != null) && (!lista.isEmpty())) {
			ClienteVO[] clientes = new ClienteVO[lista.size()];
			for (int i = 0; i < lista.size(); i++) {
				cliente = (Cliente) lista.get(i);
				ClienteVO clienteVO = new ClienteVO(cliente.getId(),
						cliente.getNome(), cliente.getEndereco(),
						cliente.getTelefone(), cliente.getSituacao());
				clientes[i] = clienteVO;
			}
			responseDTO.set("listaCliente", clientes);
		}
		return responseDTO;
	}

	
}
