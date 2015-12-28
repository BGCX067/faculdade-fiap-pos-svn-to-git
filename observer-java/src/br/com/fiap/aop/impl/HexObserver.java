package br.com.fiap.aop.impl;

import br.com.fiap.aop.Observer;
import br.com.fiap.aop.Subject;

public class HexObserver extends Observer {
	
	
	public HexObserver(Subject s) {
		subj = s;
		subj.attach(this);
	}

	@Override
	public void update() {
		System.out.println(String.format("Número Hexadecimal: %s", Integer.toHexString(subj.getState())));
	}

}
