package com.jdbcmanager;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class ConnectorJDBC {
	private static ConnectorJDBC connectorInstance;
	private static Properties properties = new Properties();
	private static Properties queries = new Properties();
	private Connection connection = null;
	
	private ConnectorJDBC() {
		super();
	}
	
	public static ConnectorJDBC getInstance() {
		if(connectorInstance==null) {
			connectorInstance = new ConnectorJDBC();
			loadConfing();
		}
		return connectorInstance;
	}
	
	private static void loadConfing() {
		try {
			InputStream in = new FileInputStream("sql.properties");
			properties.load(in);
			InputStream sql = new FileInputStream("query.properties");
			queries.load(sql);
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
	}
	
	public String getProperty(String p) {
		return properties.getProperty(p);
	}
	
	public String getQuery(String p) {
		return queries.getProperty(p);
	}
	
	public Connection getConnection(){
		if(connection == null) {
			connection = new SQLManager().getConnection();
		}
		return connection;
	}
}
