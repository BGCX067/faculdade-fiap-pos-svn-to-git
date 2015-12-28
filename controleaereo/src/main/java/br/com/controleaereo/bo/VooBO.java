package br.com.controleaereo.bo;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import br.com.controleaereo.bean.Assento;
import br.com.controleaereo.bean.Usuario;
import br.com.controleaereo.bean.Voo;
import br.com.controleaereo.dao.ReservaDao;
import br.com.controleaereo.dao.VooDao;

@Service
public class VooBO {

	@Inject
	private VooDao vooDao;

	@Inject
	private ReservaDao reservaDao;
	
	private static VooBO INSTANCE;
	
	private AssentoBO getAssentoBO(){
		return AssentoBO.getInstance();
	}

	private VooBO() {
		if (INSTANCE == null) {
			INSTANCE = this;
		}
	}

	public static VooBO getInstance() {
		return INSTANCE;
	}

	public void cadastra(Voo voo, List<Assento> assentos) throws Exception {
		vooDao.save(voo);
		getAssentoBO().save(assentos);
	}

	public List<Voo> recuperaVoos() {
		List<Voo> voos = vooDao.listAll();
		return voos;
	}
	
	public List<Voo> recuperaVoosReservados(Usuario u) {
		List<Voo> voos = new ArrayList<Voo>();
		List<Assento> assentos= vooDao.recuperaVoosReservados(u.getId());
		for (Assento assento : assentos) {
			voos.add(assento.getVoo());
		}
		return voos;
	}

	public Voo recuperaVoo(Long id) {
		return vooDao.find(id);
	}

}