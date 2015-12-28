package br.com.estudo.designpatterns;

import org.apache.commons.lang.StringUtils;

public class NullUser extends User {

	@Override
	public String getLogin() {
		return StringUtils.EMPTY;
	}

}
