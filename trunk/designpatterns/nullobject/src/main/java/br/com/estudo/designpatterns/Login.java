package br.com.estudo.designpatterns;

public class Login {

	private User user = new NullUser();
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
}
