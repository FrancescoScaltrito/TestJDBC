package dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.jdbcmanager.ConnectorJDBC;
import com.jdbcmanager.SQLManager;

import objects.Animale;
import objects.Persona;
import utilities.Utilities;

public class PersonaDAO {
	private SQLManager db = new SQLManager();
	
	public List<Persona> findAll() throws Exception{
		String query = ConnectorJDBC.getInstance().getQuery("query.persona");
		List<Map<String,Object>> myList = db.list(query);
		return myList.stream()
					.map(it -> new Persona(
						(Integer)it.get("id_persona"),
						(String)it.get("nome"),
						(String)it.get("cognome"),
						Utilities.dateToLocalDate(it.get("data_di_nascita"))
					)
				).collect(Collectors.toList());
	}
	
	public List<Persona> findPersoneConAnimali() throws Exception {
	    String query = ConnectorJDBC.getInstance().getQuery("query.join");
	    List<Map<String,Object>> rows = db.list(query);
	    Map<Integer, Persona> personeMap = new HashMap<>();

	    for(Map<String,Object> row : rows) {

	        Integer idPersona = (Integer) row.get("id_persona");

	        Persona persona = personeMap.get(idPersona);

	        // Se non esiste, la creiamo
	        if(persona == null) {

	            persona = new Persona(
	                    idPersona,
	                    (String)row.get("persona_nome"),
	                    (String)row.get("cognome"),
	                    Utilities.dateToLocalDate(row.get("data_di_nascita"))
	            );

	            personeMap.put(idPersona, persona);
	        }

	        // Creazione animale
	        Animale animale = new Animale(
	                (Integer)row.get("id_animale"),
	                (String)row.get("animale_nome"),
	                Utilities.dateToLocalDate(row.get("animale_data")),
	                (String)row.get("sesso"),
	                (String)row.get("tipo"),
	                (String)row.get("razza"),
	                (Integer)row.get("id_padrone")
	        );

	        persona.getAnimali().add(animale);
	    }

	    return new ArrayList<>(personeMap.values());
	}
	
	public void insertPersona(Persona p) {
		String query = ConnectorJDBC.getInstance().getQuery("query.insert");
		query = query + "(" 
				+"\""+p.getNome() + "\""+ ","
				+"\""+(String)p.getCognome() + "\""+ ","
				+"\""+Utilities.localDateToDate(p.getData_di_nascita() )+"\""		//da implementare conversione in Utilities
				+ ");";
		System.out.println(query);
		try {
			int x =db.update(query);
			System.out.printf("Esito insertPersona(%s) ",p);
			System.out.println("è: "+x);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void deletePersona(int id) {
		String query = ConnectorJDBC.getInstance().getQuery("query.delete");
		query = query +""+id;
		System.out.println(query);
		try {
			int x =db.update(query);
			System.out.printf("Esito deletePersona(%d) ",id);
			System.out.println("è: "+x);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	
}
