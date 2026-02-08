package com.jdbcmanager;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// classe di utilities per instaurare connessione col DB (attraverso
// ConnectorJDBC) e preparare le query all'esecuzione
public class SQLManager {
	
	public Connection getConnection(){
		Connection connection = null;
		try {
			Class.forName(ConnectorJDBC.getInstance().getProperty("driver"));
			connection = DriverManager.getConnection(
								ConnectorJDBC.getInstance().getProperty("url"),
								ConnectorJDBC.getInstance().getProperty("user"),
								ConnectorJDBC.getInstance().getProperty("pwd")
							);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return connection;
	}
	
	public List<Map<String,Object>> list(String query)throws Exception{
		try {
			PreparedStatement ps = ConnectorJDBC.getInstance()
						.getConnection().prepareStatement(query);
			System.out.println("After preparedStatement");
			ResultSet result = ps.executeQuery();
			return resultSetToList(result);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			//e.printStackTrace();
			throw new Exception();
		}
	}
	public List<String> listOfTables(String dbName) throws Exception{
		List<String> lT = new ArrayList<String>();
		try {
			DatabaseMetaData dbMD = ConnectorJDBC
									.getInstance()
									.getConnection()
									.getMetaData();
			ResultSet res = dbMD.getTables(dbName, null, null, null);
			//build del result
			while(res.next()) {
				lT.add(res.getString("TABLE_name"));
			}
		}catch(SQLException e) {
			throw new Exception(e.getMessage());
		}
		return lT;
	}
	private List<Map<String,Object>> resultSetToList(ResultSet rs)throws SQLException{
		//retrieve resultset metadata
		ResultSetMetaData md = rs.getMetaData();
		int columns = md.getColumnCount(); //num. colonne query
		List<Map<String,Object>> rows = new ArrayList<Map<String,Object>>();
		
		while(rs.next()) {
			Map<String,Object> row = new HashMap<String, Object>();
			for(int i=1; i<= columns; i++) {
				row.put(md.getColumnName(i), rs.getObject(i));
			}
			rows.add(row);
		}
		return rows;
		
	}
	
}
