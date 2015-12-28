package br.com.estudo.designpatterns;


import org.junit.Assert;
import org.junit.Test;

public class TestNullObject {
	
	UserAbstract userAbstract = new NullUser();
	Login login = new Login();
	
	
	@Test
	public void testNullObject(){
		Assert.assertNotNull(userAbstract.getLogin());
	}
	
	@Test
	public void testNonNullObject(){
		userAbstract = new User();
		Assert.assertTrue(userAbstract instanceof User);
	}
	
	@Test
	public void testNullObjectLogin(){
		Assert.assertNotNull(login.getUser().getLogin());
	}
	
	@Test
	public void testNonNullObjectLogin(){
		User user = new User();
		user.setLogin("carlos");
		login.setUser(user);
		Assert.assertNotNull(login.getUser().getLogin());
	}
	
	

}
