package br.com.fiap.trabalho.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.com.fiap.trabalho.dao.MovieDAO;
import br.com.fiap.trabalho.entity.Actor;
import br.com.fiap.trabalho.entity.Movie;

public class JDBCMovieDao extends JDBCConnection implements MovieDAO {

	public Movie createMovie(Movie movie) {
		try {
			String sql = "INSERT INTO MOVIE (TITLE, YEARR, STUDIO_ID) VALUES (?,?, ?)";
			PreparedStatement stm = getConnection().prepareStatement(sql,
					PreparedStatement.RETURN_GENERATED_KEYS);
			stm.setString(1, movie.getTitle());
			stm.setInt(2, movie.getYear());
			stm.setInt(3, movie.getStudio().getId());
			stm.execute();
			ResultSet rs = stm.getGeneratedKeys();
			rs.next();
			movie.setId(rs.getInt(1));

			for (Iterator iterator = movie.getActors().iterator(); iterator
					.hasNext();) {
				Actor actor = (Actor) iterator.next();
				insertMovieActor(movie.getId(), actor.getId());
			}

		} catch (SQLException e) {
			e.printStackTrace();
			movie = null;
		}
		return movie;
	}

	public boolean deleteMovie(Movie movie) {
		Boolean result = false;
		try {
			deleteMovieActor(movie);
			String sql = "DELETE FROM MOVIE WHERE ID=?";
			PreparedStatement stm = getConnection().prepareStatement(sql);
			stm.setInt(1, movie.getId());
			result = stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	private void deleteMovieActor(Movie movie) throws SQLException {
		String sql = "DELETE FROM MOVIE_ACTOR M WHERE M.IDMOVIE = ? ";
		PreparedStatement stm = getConnection().prepareStatement(sql);
		stm.setInt(1, movie.getId());
		stm.execute();
	}

	public List<Movie> selectMoviesByTitle(String title) {
		List<Movie> movies = null;
		try {
			String sql = "SELECT * FROM MOVIE WHERE TITLE=?";
			PreparedStatement stm = getConnection().prepareStatement(sql);
			stm.setString(1, title);
			ResultSet rs = stm.executeQuery();
			movies = getMovies(rs);
		} catch (SQLException e) {
			e.printStackTrace();
			return movies;
		}
		return movies;
	}

	public List<Movie> selectMoviesByYear(int year) {
		List<Movie> movies = null;
		try {
			String sql = "SELECT * FROM MOVIE WHERE YEARR=?";
			PreparedStatement stm = getConnection().prepareStatement(sql);
			stm.setInt(1, year);
			ResultSet rs = stm.executeQuery();
			movies = getMovies(rs);
		} catch (SQLException e) {
			e.printStackTrace();
			return movies;
		}
		return movies;
	}

	public List<Movie> selectMoviesByActorName(String actorName) {
		List<Movie> movies = null;
		try {
			String sql = "SELECT * FROM MOVIE M INNER JOIN MOVIE_ACTOR MA ON MA.IDMOVIE=M.ID INNER JOIN ACTOR A ON A.ID=MA.IDACTOR WHERE A.FULLNAME=?";
			PreparedStatement stm = getConnection().prepareStatement(sql);
			stm.setString(1, actorName);
			ResultSet rs = stm.executeQuery();
			movies = getMovies(rs);
		} catch (SQLException e) {
			e.printStackTrace();
			return movies;
		}
		return movies;
	}

	public void insertMovieActor(int idMovie, int idActor) {
		try {
			String sql = "INSERT INTO MOVIE_ACTOR (IDMOVIE, IDACTOR) VALUES (?,?)";
			PreparedStatement stm = getConnection().prepareStatement(sql,
					PreparedStatement.RETURN_GENERATED_KEYS);
			stm.setInt(1, idMovie);
			stm.setInt(2, idActor);
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Movie> selectMoviesByCategoryName(String categoryName) {
		List<Movie> movies = null;
		try {
			String sql = "SELECT * FROM MOVIE M INNER JOIN MOVIE_CATEGORY MC ON MC.IDMOVIE=M.ID INNER JOIN CATEGORY C ON C.ID=MC.IDCATEGORY WHERE C.NAME=?";
			PreparedStatement stm = getConnection().prepareStatement(sql);
			stm.setString(1, categoryName);
			ResultSet rs = stm.executeQuery();
			movies = getMovies(rs);
		} catch (SQLException e) {
			e.printStackTrace();
			return movies;
		}
		return movies;
	}

	public List<Movie> selectMoviesByStudioName(String studioName) {
		List<Movie> movies = null;
		try {
			String sql = "SELECT * FROM MOVIE M INNER JOIN STUDIO S ON S.ID=M.STUDIO_ID WHERE S.NAME=?";
			PreparedStatement stm = getConnection().prepareStatement(sql);
			stm.setString(1, studioName);
			ResultSet rs = stm.executeQuery();
			movies = getMovies(rs);
		} catch (SQLException e) {
			e.printStackTrace();
			return movies;
		}
		return movies;
	}

	public Movie find(int id) {
		Movie movie = null;
		try {
			String sql = "SELECT * FROM MOVIE WHERE ID=?";
			PreparedStatement stm = getConnection().prepareStatement(sql);
			stm.setInt(1, id);
			ResultSet rs = stm.executeQuery();
			if (rs.next()) {
				movie = new Movie();
				movie.setId(rs.getInt("ID"));
				movie.setTitle(rs.getString("TITLE"));
				movie.setYear(rs.getInt("YEARR"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return movie;
		}
		return movie;
	}

	private List<Movie> getMovies(ResultSet rs) throws SQLException {
		List<Movie> movies = new ArrayList<Movie>();
		while (rs.next()) {
			Movie movie = new Movie();
			movie.setId(rs.getInt("ID"));
			movie.setTitle(rs.getString("TITLE"));
			movie.setYear(rs.getInt("YEARR"));
			movies.add(movie);
		}
		return movies;
	}

}