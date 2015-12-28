package br.com.fiap.trabalho.dao.jdbc;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.com.fiap.trabalho.dao.ActorDAO;
import br.com.fiap.trabalho.entity.Actor;
import br.com.fiap.trabalho.entity.Movie;

public class JDBCActorDAO extends JDBCConnection implements ActorDAO {

	public Actor createActor(Actor actor) {
		try {
			String sql = "INSERT INTO ACTOR (FULLNAME, BIRTHDATE) VALUES (?,?)";
			PreparedStatement stm = getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			stm.setString(1, actor.getFullName());
			stm.setDate(2, new Date(actor.getBirthDate().getTime()));
			stm.execute();
			ResultSet rs = stm.getGeneratedKeys();
			rs.next();
			actor.setId(rs.getInt(1));
		} catch (SQLException e) {
			e.printStackTrace();
			actor = null;
		}
		return actor;
	}

	public boolean deleteActor(Actor actor) {
		Boolean result = false;
		try {
			String sql = "DELETE FROM ACTOR WHERE ID=?";
			PreparedStatement stm = getConnection().prepareStatement(sql);
			stm.setInt(1, actor.getId());
			result = stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<Actor> selectActorByName(String name) {
		List<Actor> actors = new ArrayList<Actor>();
		try {
			String sql = "SELECT * FROM ACTOR WHERE FULLNAME=?";
			PreparedStatement stm = getConnection().prepareStatement(sql);
			stm.setString(1, name);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Actor actor = new Actor();
				actor.setId(rs.getInt("ID"));
				actor.setFullName(rs.getString("FULLNAME"));
				actor.setBirthDate(rs.getDate("BIRTHDATE"));
				actors.add(actor);
			}
		} catch (SQLException e) {
			return actors;
		}
		return actors;
	}

	public List<Actor> selectActorByAge(int age) {
		List<Actor> actors = new ArrayList<Actor>();
		try {
			String sql = "SELECT * FROM ACTOR WHERE YEAR(BIRTHDATE)=?";
			PreparedStatement stm = getConnection().prepareStatement(sql);
			stm.setInt(1, getYear(age));
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Actor actor = new Actor();
				actor.setId(rs.getInt("ID"));
				actor.setFullName(rs.getString("FULLNAME"));
				actor.setBirthDate(rs.getDate("BIRTHDATE"));
				actors.add(actor);
			}
		} catch (SQLException e) {
			return actors;
		}
		return actors;
	}

	public Set<Actor> selectActorByMovie(Movie movie) {
		Set<Actor> actors = new HashSet<Actor>();
		try {
			String sql = "SELECT A.* FROM Actor A "
					+ "INNER JOIN MOVIE_ACTOR MA ON "
					+ "MA.IDACTOR=A.ID INNER JOIN MOVIE M ON "
					+ "M.ID = MA.IDMOVIE"
					+ " WHERE M.ID= ? ";
			System.out.println(sql);
			System.out.println(movie.getId());
			PreparedStatement stm = getConnection().prepareStatement(sql);
			stm.setInt(1, movie.getId());
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Actor actor = new Actor();
				actor.setId(rs.getInt("ID"));
				actor.setFullName(rs.getString("FULLNAME"));
				actor.setBirthDate(rs.getDate("BIRTHDATE"));
				actors.add(actor);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return actors;
		}
		return actors;
	}

	private int getYear(int age) {
		Calendar c = new GregorianCalendar();
		int ano = c.get(Calendar.YEAR);
		return ano - age;
	}
}
