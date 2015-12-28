package br.com.controleaereo.bo;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import br.com.controleaereo.bean.Assento;
import br.com.controleaereo.bean.Usuario;
import br.com.controleaereo.dao.AssentoDao;

@Service
public class AssentoBO {
	
	private static AssentoBO INSTANCE;
	
	@Inject
	private AssentoDao assentoDao;
	
	private AssentoBO() {
		if (INSTANCE == null) {
			INSTANCE = this;
		}
	}

	public static AssentoBO getInstance() {
		return INSTANCE;
	}
	
	public List<Assento> recuperaAssentosDisponiveis(Usuario u, Long idVoo) {
		List<Assento> list = assentoDao.recuperaAssentosDisponiveis(u.getId(),
				idVoo);
		for (Assento assento : list) {
			if (assento.getIdUsuario().intValue() == u.getId()) {
				assento.setSelected("checked");
			} else {
				assento.setSelected("");
			}
		}
		return list;
	}

	public List<Assento> recuperaAssentoSelecionados(Usuario u, Long idVoo) {
		List<Assento> list = assentoDao.recuperaAssentoSelecionados(u.getId(),
				idVoo);
		return list;
	}
	
	public void reservar(Usuario u, List<Assento> assentos, String[] selecteds, Long idVoo) {
		List<Assento> assentosAux = recuperaAssentosSelecionados(selecteds, assentos);
		List<Assento> list = recuperaAssentoSelecionados(u, idVoo);
		for (Assento assento : list) {
			assento.setIdUsuario(0);
			assentoDao.update(assento);
		}
		for (Assento assento : assentosAux) {
			assento.setIdUsuario(u.getId());
			assentoDao.update(assento);
		}
	}

	private List<Assento> recuperaAssentosSelecionados(
			String[] assentosSelecionados, List<Assento> listAssentos) {
		List<Assento> listSelectedAssentos = new ArrayList<Assento>();
		for (Assento assento : listAssentos) {
			for (int i = 0; i < assentosSelecionados.length; i++) {
				if (assentosSelecionados[i].equals(assento.getId().toString())) {
					listSelectedAssentos.add(assento);
					continue;
				}
			}
		}
		return listSelectedAssentos;
	}
	
	public void cancelar(Usuario u, Long idVoo) throws Exception {
		List<Assento> assentos = recuperaAssentosDisponiveis(u, idVoo);
		for (Assento assento : assentos) {
			assento.setIdUsuario(0);
		}
		assentoDao.update(assentos);
	}
	
	public void finalizar(Usuario u, Long idVoo) throws Exception {
		List<Assento> assentos = recuperaAssentoSelecionados(u, idVoo);
		for (Assento assento : assentos) {
			assento.setFechado(true);
		}
		assentoDao.update(assentos);
	}
	
	public void save(Assento assento) throws Exception{
		assentoDao.save(assento);
	}
	
	public void save(List<Assento> assentos) throws Exception{
		assentoDao.save(assentos);
	}
}
