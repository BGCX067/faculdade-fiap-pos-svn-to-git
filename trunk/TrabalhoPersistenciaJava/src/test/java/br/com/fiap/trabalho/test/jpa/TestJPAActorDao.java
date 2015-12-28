package br.com.fiap.trabalho.test.jpa;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.fiap.trabalho.dao.AbstractDAOFactory;
import br.com.fiap.trabalho.dao.ActorDAO;
import br.com.fiap.trabalho.dao.MovieDAO;
import br.com.fiap.trabalho.dao.StudioDAO;
import br.com.fiap.trabalho.dao.jpa.JPADAOFactory;
import br.com.fiap.trabalho.entity.Actor;
import br.com.fiap.trabalho.entity.Movie;
import br.com.fiap.trabalho.entity.Studio;

import com.carrotsearch.junitbenchmarks.AbstractBenchmark;
import com.carrotsearch.junitbenchmarks.BenchmarkOptions;
import com.carrotsearch.junitbenchmarks.annotation.AxisRange;
import com.carrotsearch.junitbenchmarks.annotation.BenchmarkMethodChart;

@AxisRange(min = 0, max = 1)
@BenchmarkMethodChart(filePrefix = "TestJPAActorDao")
@BenchmarkOptions(benchmarkRounds = 100, warmupRounds = 0)
@SuppressWarnings("deprecation")
public class TestJPAActorDao  extends AbstractBenchmark{
	private ActorDAO actorDAO;
	private MovieDAO movieDAO;
	private StudioDAO studioDAO;
	private HashSet<Actor> actors =  new HashSet<Actor>();
	private Studio studio1;
	
	@Before
	public void init(){
		AbstractDAOFactory abstractDAOFactory = new JPADAOFactory();
		actorDAO = abstractDAOFactory.createActorDAO();
		movieDAO = abstractDAOFactory.createMovieDAO();
		studioDAO = abstractDAOFactory.createStudioDAO();
		Actor actor1 = new Actor();
		actor1.setBirthDate(new Date("10/10/2010"));
		actor1.setFullName("actor1");
		actorDAO.createActor(actor1);

		Actor actor2 = new Actor();
		actor2.setBirthDate(new Date("10/10/2011"));
		actor2.setFullName("actor2");
		actorDAO.createActor(actor2);
		actors.add(actor1);
		actors.add(actor2);
		
		studio1 = new Studio();
		studio1.setName("Studio 1");
		studioDAO.createStudio(studio1);
	}
	
	@Test
	public void validarcreateDao(){
		Assert.assertNotNull(this.actorDAO);
	}

	
	@Test
	public void selectActorByName() {
		List<Actor> actorList = actorDAO.selectActorByName("actor2");
		assertNotNull(actorList);
	}

	@Test
	public void insertActor() {
		Actor actor = new Actor();
		actor.setBirthDate(new Date("10/10/2000"));
		actor.setFullName("actor insert");
		actorDAO.createActor(actor);
	}

	@Test
	public void selectActorByAge() {
		List<Actor> actorList = actorDAO.selectActorByAge(2);
		assertNotNull(actorList);
	}

	@Test
	public void deleteActor() {
		List<Actor> actorList = actorDAO.selectActorByName("actor1");
		int idActor = actorList.get(0).getId();
		long milisec = new Date().getTime();
		actorDAO.deleteActor(actorList.get(0));
		milisec = new Date().getTime() - milisec;
		System.out.println(milisec + " ms");
		List<Actor> actorList2 = actorDAO.selectActorByName("actor1");
		if(!actorList2.isEmpty()){
			assertTrue(idActor != actorList2.get(0).getId());
		}else{
			assertTrue(true);
		}
	}
	
	@Test
	public void selectActorByMovie(){
		Movie movie = new Movie();
		movie.setActors(actors);
		movie.setTitle("Caçada ao Mundo do Java");
		movie.setStudio(studio1);
		movie.setYear(2013);
		movieDAO.createMovie(movie);
		Set<Actor> list = actorDAO.selectActorByMovie(movie);
		assertTrue(list.size() > 0);
	}
}
