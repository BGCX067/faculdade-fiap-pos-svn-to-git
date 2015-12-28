package br.com.exemplo.transacao;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class ServicePrincipal implements Servico {

	@Override
	public void impressao() {
		System.out.println(ServicePrincipal.class.getName());
		
	}

	
	
}
