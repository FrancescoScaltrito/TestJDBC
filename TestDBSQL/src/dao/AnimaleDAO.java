package dao;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.jdbcmanager.ConnectorJDBC;
import com.jdbcmanager.SQLManager;

import objects.Animale;
import objects.Persona;
import utilities.Utilities;

public class AnimaleDAO {
	private SQLManager db = new SQLManager();
	public List<Animale> findAll() throws Exception{
		String query = ConnectorJDBC.getInstance()
				.getQuery("query.animale");
		List<Map<String,Object>> myList = db.list(query);
		
		return myList.stream()
				.map(it -> new Animale(
					(Integer)it.get("id_animale"),
					(String)it.get("nome"),
					Utilities.dateToLocalDate(it.get("data_di_nascita")),
					(String)it.get("sesso"),
					(String)it.get("tipo"),
					(String)it.get("razza"),
					(Integer)it.get("id_padrone")
					
			
				)
			).collect(Collectors.toList());
	}
}
