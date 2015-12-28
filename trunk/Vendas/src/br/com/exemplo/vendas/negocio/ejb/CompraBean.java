package br.com.exemplo.vendas.negocio.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.exemplo.vendas.negocio.dao.DaoFactory;
import br.com.exemplo.vendas.negocio.ejb.interfaces.CompraLocal;
import br.com.exemplo.vendas.negocio.ejb.interfaces.CompraRemote;
import br.com.exemplo.vendas.negocio.entity.Compra;
import br.com.exemplo.vendas.negocio.model.vo.CompraVO;
import br.com.exemplo.vendas.util.dto.ServiceDTO;
import br.com.exemplo.vendas.util.exception.LayerException;

@Stateless
public class CompraBean implements CompraRemote, CompraLocal {
	@PersistenceContext(unitName = "Vendas")
	EntityManager em;

	public ServiceDTO inserirCompra(ServiceDTO requestDTO)
			throws LayerException {
		ServiceDTO responseDTO = new ServiceDTO();
		CompraVO vo = (CompraVO) requestDTO.get("CompraVO");
		if (vo != null) {
			Compra compra = new Compra(vo.getNumero(), vo.getData(),
					vo.getResponsavel(), vo.getSituacao(), vo.getValor(),
					vo.getReserva(), vo.getCliente());

			if (DaoFactory.getCompraDAO(em).inserir(compra)) {
				responseDTO.set("resposta", new Boolean(true));
			} else {
				responseDTO.set("resposta", new Boolean(false));
			}
		}
		return responseDTO;
	}

	public ServiceDTO alterarCompra(ServiceDTO requestDTO)
			throws LayerException {
		ServiceDTO responseDTO = new ServiceDTO();
		CompraVO vo = (CompraVO) requestDTO.get("CompraVO");
		if (vo != null) {
			Compra compra = new Compra(vo.getNumero(), vo.getData(),
					vo.getResponsavel(), vo.getSituacao(), vo.getValor(),
					vo.getReserva(), vo.getCliente());
			if (DaoFactory.getCompraDAO(em).alterar(compra)) {
				responseDTO.set("resposta", new Boolean(true));
			} else {
				responseDTO.set("resposta", new Boolean(false));
			}
		}
		return responseDTO;
	}

	public ServiceDTO excluirCompra(ServiceDTO requestDTO)
			throws LayerException {
		ServiceDTO responseDTO = new ServiceDTO();
		CompraVO vo = (CompraVO) requestDTO.get("CompraVO");
		if (vo != null) {
			Compra compra = new Compra();
			compra.setNumero(vo.getNumero());
			if (DaoFactory.getCompraDAO(em).excluir(compra)) {
				responseDTO.set("resposta", new Boolean(true));
			} else {
				responseDTO.set("resposta", new Boolean(false));
			}
		}
		return responseDTO;
	}

	public ServiceDTO selecionarTodasCompras(ServiceDTO requestDTO)
			throws LayerException {
		ServiceDTO responseDTO = new ServiceDTO();
		List<Compra> lista = DaoFactory.getCompraDAO(em).listar();
		CompraVO[] comprasVO = getList(lista);
		responseDTO.set("listaCompra", comprasVO);
		return responseDTO;
	}

	public ServiceDTO getCompra(ServiceDTO requestDTO)
			throws LayerException {
		ServiceDTO responseDTO = new ServiceDTO();
		CompraVO compraVO = (CompraVO)requestDTO.get("CompraVO");
		Compra compra = new Compra();
		compra.setNumero(compraVO.getNumero());
		Compra compraRet = DaoFactory.getCompraDAO(em).localizarPorId(compra);
		responseDTO.set("getCompra", getCompraVO(compraRet));
		return responseDTO;
	}


	private CompraVO[] getList(List lista){
		Compra compra = null;
		if ((lista != null) && (!lista.isEmpty())) {
			CompraVO[] comprasVO = new CompraVO[lista.size()];
			for (int i = 0; i < lista.size(); i++) {
				compra = (Compra) lista.get(i);
				CompraVO vo = new CompraVO(compra.getNumero(),
						compra.getData(), compra.getResponsavel(),
						compra.getSituacao(), compra.getValor(),
						compra.getReserva(), compra.getCliente());
				comprasVO[i] = vo;
			}
			return comprasVO;
		}
		return null;
	}
	
	private CompraVO getCompraVO(Compra compra){
		CompraVO vo = null;
		if (compra != null) {
			vo = new CompraVO(compra.getNumero(), compra.getData(),
					compra.getResponsavel(), compra.getSituacao(),
					compra.getValor(), compra.getReserva(), compra.getCliente());
			
		}
		return vo;
	}
	
	public ServiceDTO listarValorEntre(ServiceDTO requestDTO)
			throws LayerException {
		ServiceDTO responseDTO = new ServiceDTO();
		List<Compra> lista = DaoFactory.getCompraDAO(em).listarValorEntre();
		CompraVO[] comprasVO = getList(lista);
		responseDTO.set("listaCompra", comprasVO);
		return responseDTO;
	}

	
	public ServiceDTO listarComprasComReserva(ServiceDTO requestDTO)
			throws LayerException {
		ServiceDTO responseDTO = new ServiceDTO();
		List<Compra> lista = DaoFactory.getCompraDAO(em).listarComprasComReserva();
		CompraVO[] comprasVO = getList(lista);
		responseDTO.set("listaCompra", comprasVO);
		return responseDTO;
	}
	
	
}
