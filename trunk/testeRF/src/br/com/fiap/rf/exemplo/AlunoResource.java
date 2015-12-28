package br.com.fiap.rf.exemplo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/alunos")
public class AlunoResource {
	static private Map<Integer, Aluno> alunosMap;

	static {
		alunosMap = new HashMap<Integer, Aluno>();
		Aluno b1 = new Aluno();
		b1.setId(1);
		b1.setAnoDeFormacao(2010);
		b1.setNome("teste");

		alunosMap.put(b1.getId(), b1);

		Aluno b2 = new Aluno();
		b1.setId(2);
		b1.setAnoDeFormacao(2011);
		b1.setNome("teste2");

		alunosMap.put(b2.getId(), b2);
	}

	@GET
	@Produces(MediaType.TEXT_XML)
	public List<Aluno> getAlunos() {
		return new ArrayList<Aluno>(alunosMap.values());
	}
}
