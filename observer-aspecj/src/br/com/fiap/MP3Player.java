package br.com.fiap;

public class MP3Player {

	
	private int volume;
	
	public MP3Player() {
		this.volume = 0;
	}
	
	public int getVolume() {
		return volume;
	}
	
	public void setVolume(int volume) {
		this.volume = volume;
	}
	
	public static void main(String[] args) {
		MP3Player player = new MP3Player();
		Slide s = new Slide();
		TextLevel l = new TextLevel();
		player.setVolume(10);
		
	}

}
