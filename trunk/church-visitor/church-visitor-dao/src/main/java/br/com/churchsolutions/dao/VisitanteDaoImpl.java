package br.com.churchsolutions.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import br.com.churchsolutions.Visitante;

@Repository
public class VisitanteDaoImpl  {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public Visitante save(Visitante visitante){
		mongoTemplate.save(visitante);
		return visitante;
	}

}
