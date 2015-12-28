package br.com.fiap;

public aspect ObserverConcreto extends PadraoObserver {

	
	pointcut criarSujeito(Subject s) : execution(MP3Player.new()) && this(s);
	
	pointcut criarObservador(Observer o) : (execution(Slide.new()) || execution(TextLevel.new() )) && this(o);

	pointcut modificaSujeito() : execution( * MP3Player.setVolume(..));
	
	declare parents : MP3Player implements Subject;
	declare parents : Slide implements Observer;
	declare parents : TextLevel implements Observer;

	public void Slide.update(Subject s) {
		MP3Player p = (MP3Player ) s;
		System.out.println("foi informado Slide");
	}
	
	
	public void TextLevel.update(Subject s) {
		MP3Player p = (MP3Player ) s;
		System.out.println("foi informado TextLevel");
	}
	

}
