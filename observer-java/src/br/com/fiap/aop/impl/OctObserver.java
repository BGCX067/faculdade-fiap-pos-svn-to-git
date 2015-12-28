package br.com.fiap.aop.impl;

import br.com.fiap.aop.Observer;
import br.com.fiap.aop.Subject;

public class OctObserver extends Observer {
	
	
	public OctObserver(Subject s) {
		subj = s;
		subj.attach(this);
	}

	@Override
	public void update() {
		System.out.println(String.format("Número Hexadecimal: %s", Integer.toOctalString(subj.getState())));
	}

}
