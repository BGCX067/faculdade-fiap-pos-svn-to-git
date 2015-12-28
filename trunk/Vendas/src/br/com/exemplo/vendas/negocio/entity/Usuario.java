package br.com.exemplo.vendas.negocio.entity ;

import java.io.Serializable ;
import javax.persistence.* ;

import java.util.Date ;

/**
 * The persistent class for the Usuario database table.
 * 
 */
@Entity
public class Usuario implements Serializable
{

	private static final long serialVersionUID = -1837228910141706157L;

	public Usuario( String login, String senha, String grupo, String perfil, Boolean bloqueado,
			Date ultimoAcesso )
	{
		this.login = login ;
		this.senha = senha ;
		this.grupo = grupo ;
		this.perfil = perfil ;
		this.bloqueado = bloqueado ;
		this.ultimoAcesso = ultimoAcesso ;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Column
	private String login ;

	@Column
	private Boolean bloqueado ;

	@Column
	private String grupo ;

	@Column
	private String perfil ;

	@Column
	private String senha ;

	@Temporal( TemporalType.TIMESTAMP )
	private Date ultimoAcesso ;

	public Usuario( )
	{
	}

	public String getLogin( )
	{
		return this.login ;
	}

	public void setLogin( String login )
	{
		this.login = login ;
	}

	public Boolean getBloqueado( )
	{
		return this.bloqueado ;
	}

	public void setBloqueado( Boolean bloqueado )
	{
		this.bloqueado = bloqueado ;
	}

	public String getGrupo( )
	{
		return this.grupo ;
	}

	public void setGrupo( String grupo )
	{
		this.grupo = grupo ;
	}

	public String getPerfil( )
	{
		return this.perfil ;
	}

	public void setPerfil( String perfil )
	{
		this.perfil = perfil ;
	}

	public String getSenha( )
	{
		return this.senha ;
	}

	public void setSenha( String senha )
	{
		this.senha = senha ;
	}

	public Date getUltimoAcesso( )
	{
		return this.ultimoAcesso ;
	}

	public void setUltimoAcesso( Date ultimoAcesso )
	{
		this.ultimoAcesso = ultimoAcesso ;
	}
}