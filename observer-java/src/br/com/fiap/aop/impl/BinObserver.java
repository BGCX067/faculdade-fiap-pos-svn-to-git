package br.com.fiap.aop.impl;

import br.com.fiap.aop.Observer;
import br.com.fiap.aop.Subject;

public class BinObserver extends Observer {
	
	
	public BinObserver(Subject s) {
		subj = s;
		subj.attach(this);
	}

	@Override
	public void update() {
		System.out.println(String.format("Número Binário: %s", Integer.toBinaryString(subj.getState())));
	}

}
