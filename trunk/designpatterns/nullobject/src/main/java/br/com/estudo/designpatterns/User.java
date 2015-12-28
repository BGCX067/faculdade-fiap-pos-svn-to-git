package br.com.estudo.designpatterns;

public class User extends UserAbstract{
	
	private String login;

	public void setLogin(String login) {
		this.login = login;
	}
	
	@Override
	public String getLogin() {
		return this.login;
	}

}
