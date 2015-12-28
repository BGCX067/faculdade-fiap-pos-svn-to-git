package br.com.fiap.trabalho.test.jpa;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.fiap.trabalho.dao.AbstractDAOFactory;
import br.com.fiap.trabalho.dao.CategoryDAO;
import br.com.fiap.trabalho.dao.MovieDAO;
import br.com.fiap.trabalho.dao.StudioDAO;
import br.com.fiap.trabalho.dao.jpa.JPADAOFactory;
import br.com.fiap.trabalho.entity.Actor;
import br.com.fiap.trabalho.entity.Category;
import br.com.fiap.trabalho.entity.Movie;
import br.com.fiap.trabalho.entity.Studio;

import com.carrotsearch.junitbenchmarks.AbstractBenchmark;
import com.carrotsearch.junitbenchmarks.BenchmarkOptions;
import com.carrotsearch.junitbenchmarks.annotation.AxisRange;
import com.carrotsearch.junitbenchmarks.annotation.BenchmarkMethodChart;

@AxisRange(min = 0, max = 1)
@BenchmarkMethodChart(filePrefix = "TestJPAMovieDao")
@BenchmarkOptions(benchmarkRounds = 100, warmupRounds = 0)
@SuppressWarnings("deprecation")
public class TestJPAMovieDao extends AbstractBenchmark {
	private MovieDAO movieDAO;

	private CategoryDAO categoryDAO;
	private static StudioDAO studioDAO;
	private Set<Category> categories;
	private Studio studio;

	@Before
	public void init() {
		AbstractDAOFactory abstractDAOFactory = new JPADAOFactory();
		movieDAO = abstractDAOFactory.createMovieDAO();
		categoryDAO = abstractDAOFactory.createCategoryDAO();
		studioDAO = abstractDAOFactory.createStudioDAO();

		studio = new Studio();
		studio.setName("teste studio");
		studioDAO.createStudio(studio);

		Category category = new Category();
		category.setName("Terror");
		categoryDAO.createCategory(category);
		categories = new HashSet<Category>();
		categories.add(category);

		Actor actor = new Actor();
		actor.setBirthDate(new Date("10/10/2012"));
		actor.setFullName("actor1 movie");

		Actor actor2 = new Actor();
		actor2.setBirthDate(new Date("10/10/2011"));
		actor2.setFullName("actor2 movie");

		Set<Actor> actors = new HashSet<Actor>();
		actors.add(actor);
		actors.add(actor2);

		Movie movie = new Movie();
		movie.setTitle("movie select");
		movie.setYear(2013);
		movie.setActors(actors);
		movie.setCategories(categories);
		movie.setStudio(studio);
		movieDAO.createMovie(movie);

		Movie movie2 = new Movie();
		movie2.setTitle("movie del");
		movie2.setYear(2013);
		movie2.setActors(actors);
		movie2.setCategories(categories);
		movie2.setStudio(studio);
		movieDAO.createMovie(movie2);
	}

	@Test
	public void validarcreateDao() {
		Assert.assertNotNull(this.movieDAO);
	}

	@Test
	public void selectActorByTitle() {
		List<Movie> movieList = movieDAO.selectMoviesByTitle("movie select");
		assertNotNull(movieList);
	}

	@Test
	public void selectMovieByYear() {
		List<Movie> movieList = movieDAO.selectMoviesByYear(2013);
		assertNotNull(movieList);
	}

	@Test
	public void insertMovie() {
		Movie movie = new Movie();
		movie.setTitle("movie insert");
		movie.setYear(2013);
		movie.setCategories(categories);
		movie.setStudio(studio);
		movieDAO.createMovie(movie);
		assertNotNull(movie);
	}

	@Test
	public void deleteMovie() {
		List<Movie> movieList = movieDAO.selectMoviesByTitle("movie del");
		int id = movieList.get(0).getId();
		movieDAO.deleteMovie(movieList.get(0));
		Movie movie = movieDAO.find(id);
		assertNull(movie);
	}

	@Test
	public void selectMovieByActor() {
		List<Movie> movies = movieDAO.selectMoviesByActorName("actor1");
		assertNotNull(movies);
	}

	@Test
	public void selectMoviesByCategoryName() {
		List<Movie> movies = movieDAO.selectMoviesByCategoryName("Terror");
		assertNotNull(movies);
	}

	@Test
	public void selectMoviesByStudioName() {
		List<Movie> movies = movieDAO.selectMoviesByStudioName("teste studio");
		assertNotNull(movies);
	}

}
