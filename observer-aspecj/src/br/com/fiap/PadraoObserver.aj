package br.com.fiap;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract aspect PadraoObserver {
	
	protected interface Subject{}
	
	protected interface Observer{
		void update();
	}
	
	Subject sujeito;
	List<Observer> observers = new ArrayList<Observer>();
	
	abstract pointcut criarSujeito(Subject s) ;
	abstract pointcut criarObservador(Observer o) ;
	abstract pointcut modificaSujeito() ;
	
	
	after(Subject s)  :  criarSujeito(s){
		if(sujeito == null){
			System.out.println(String.format("foi criado um sujeito %s ", s.getClass().getName()));
			sujeito = s;
		}
	}

	after(Observer o)  :  criarObservador(o){
			System.out.println(String.format("foi criado um observer %s ", o.getClass().getName()));
			observers.add(o);
	}
	
	after()  :  modificaSujeito(){
		Iterator<Observer> i = observers.iterator();
		while (i.hasNext()) {
			Observer o = i.next();
			System.out.println(String.format("foi executado um metodo updade do observer %s ", o.getClass().getName()));
			o.update();

		}
		
	}
	
	
	

	
	

}
