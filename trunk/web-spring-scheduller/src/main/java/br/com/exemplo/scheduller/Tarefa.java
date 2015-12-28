package br.com.exemplo.scheduller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Tarefa {
	
	private int id=0;
	
	@Autowired
	@Qualifier("dataSource")
	private DataSource dataSource;
	
	@Scheduled(fixedDelay=10000)
	public synchronized void  insert() {
		PreparedStatement pstmt;
		try {
			pstmt = dataSource.getConnection().prepareStatement("insert into URA(ID, DADOS, STATUS) values (?, ?, ?)");
			pstmt.setInt(1, ++id);
			pstmt.setString(2, "Dados: "+id);
			pstmt.setString(3, "0");
			pstmt.executeUpdate();
			dataSource.getConnection().close();
		} catch (SQLException e) {
			System.out.println("Deu pau insert"+e.getStackTrace());
		}
		
	}
	
	@Scheduled(fixedDelay=10000)
	public synchronized void executarTarefa() throws SQLException{
		System.out.println("Executando: "+new Date());
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement("select * from URA where STATUS = '0'");
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			int id = rs.getInt("ID");
			PreparedStatement pstmtUp = dataSource.getConnection().prepareStatement("update URA set STATUS = ? where ID= ?");
			pstmtUp.setString(1, "1");
			pstmtUp.setInt(2, id);
			pstmtUp.executeUpdate();
			dataSource.getConnection().close();
			System.out.println( id + " " + rs.getString("DADOS"));
		}
		dataSource.getConnection().close();
	}
	
	

}
