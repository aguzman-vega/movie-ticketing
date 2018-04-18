
package edu.csumb.xtreme.movieticketing.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetImpl;

public class AppUtils {
	public static boolean autheticateUser(String username,String password) throws Exception{
		String dbPassword="";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(DatabaseUtilsContants.CONNECTION_STRING);
		PreparedStatement  stmt=  (PreparedStatement) con.prepareStatement(DatabaseUtilsContants.SQL_LOGIN);
		stmt.setString(1,username);
		ResultSet rs=(ResultSet) stmt.executeQuery();
		
		if(rs.next()){
			rs.last();
			dbPassword=rs.getString(2);
			con.close(); 
		}
		return password.equals(dbPassword);
	}
	public static List<String> listMovies() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(DatabaseUtilsContants.CONNECTION_STRING);
		PreparedStatement  stmt=  (PreparedStatement) con.prepareStatement(DatabaseUtilsContants.SQL_MOVIES);
		ResultSet rs=(ResultSet) stmt.executeQuery(); 
		
		List<String> ls=new ArrayList<String>();
		while(rs.next()){
			ls.add(rs.getString("movie_name")+":"+rs.getString("movie_discription")+":"+rs.getString("movie_image_path"));
		}
		return ls;
	}
	public static List<String> listTheaters(String movie_name) throws Exception{
		movie_name=movie_name.replaceAll("_"," ");
		System.out.println(movie_name);
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(DatabaseUtilsContants.CONNECTION_STRING);
		PreparedStatement  stmt =  (PreparedStatement) con.prepareStatement(DatabaseUtilsContants.SQL_Theaters);
		stmt.setString(1,movie_name);
		ResultSet rs=(ResultSet) stmt.executeQuery(); 
		List<String> ls=new ArrayList<String>();
		while(rs.next()){
			ls.add(rs.getString("theater_name")+":"+movie_name);
		}
		return ls;
	}
}
