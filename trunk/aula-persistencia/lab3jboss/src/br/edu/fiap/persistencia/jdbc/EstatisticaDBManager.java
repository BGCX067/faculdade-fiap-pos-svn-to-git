package br.edu.fiap.persistencia.jdbc;


import java.sql.Connection;
import java.util.Hashtable;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class EstatisticaDBManager {

	public  Connection obterConexaoMySQLDataSource() throws Exception {
		Hashtable<String, String> ht = new Hashtable<String, String>();
		ht.put(InitialContext.INITIAL_CONTEXT_FACTORY,
				"org.jnp.interfaces.NamingContextFactory");
		ht.put(InitialContext.PROVIDER_URL, "jnp://localhost:1099");
		ht.put(InitialContext.URL_PKG_PREFIXES,
				"org.jboss.naming:org.jnp.interfaces");
		InitialContext initialContext = new InitialContext(ht);
		DataSource dataSource = (DataSource) initialContext
				.lookup("estatistica");
		return dataSource.getConnection();
	}
	
}
