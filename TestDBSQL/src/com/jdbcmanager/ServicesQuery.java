package com.jdbcmanager;

import java.time.LocalDate;
import java.util.List;

import com.mysql.cj.xdevapi.InsertParams;

import dao.AnimaleDAO;
import dao.PersonaDAO;
import objects.Animale;
import objects.Persona;

public class ServicesQuery {
	private SQLManager db = new SQLManager();
	private PersonaDAO personaDao = new PersonaDAO();
	private AnimaleDAO animaleDao = new AnimaleDAO();
	
	public void executeQuery(int sel) throws Exception{
		switch(sel) {
		case 1:System.out.println(">>> listTable"); listTable(); break;
		case 2:System.out.println(">>> getPersone"); getPersone(); break;
		case 3:System.out.println(">>> getAnimali"); getAnimali(); break;
		case 4:System.out.println(">>> Inner Join Animali-Persona"); getInnerJoinPersoneAnimali(); break;
		case 5:System.out.println(">>> Insert Persona"); Persona p = new Persona("NomeInsert","CognomeInsert",LocalDate.of(1999, 1, 10));
				addPersona(p); break;
		case 6:System.out.println(">>> Remove Persona"); removePersona(11); break;
		default: System.out.println("Operazione non riconosciuta");
		}	
		
	}
	private void listTable() throws Exception{
		List<String> lT = db.listOfTables("test_jdbc");
		lT.forEach(t -> System.out.println(t));
	}
	private void getPersone() {
		String query = ConnectorJDBC.getInstance().getQuery("query.persona");
		System.out.println(query);
		try {
			List<Persona> lD = personaDao.findAll();
			lD.forEach(d -> System.out.println(d));
		} catch (Exception e) {
			System.out.println("Errore trovato "+e.getMessage());
		}
	}
	
	private void getAnimali() {
		String query = ConnectorJDBC.getInstance().getQuery("query.animale");
		System.out.println(query);
		try {
			List<Animale> lD = animaleDao.findAll();
			lD.forEach(d -> System.out.println(d));
		} catch (Exception e) {
			System.out.println("Errore trovato "+e.getMessage());
		}
	}
	
	private void getInnerJoinPersoneAnimali() {
		String query = ConnectorJDBC.getInstance().getQuery("query.join");
		System.out.println(query);
		try {
			List<Persona> lD = personaDao.findPersoneConAnimali();
			for(Persona p : lD) {

			    System.out.println(p);

			    for(Animale a : p.getAnimali()) {
			        System.out.println("   " + a);
			    }
			}
		} catch (Exception e) {
			System.out.println("Errore trovato "+e.getMessage());
		}
	}
	
	private void addPersona(Persona p) {
		String query = ConnectorJDBC.getInstance().getQuery("query.insert");
		personaDao.insertPersona(p);
		//System.out.println(query);
	}
	
	private void removePersona(int id) {
		String query = ConnectorJDBC.getInstance().getProperty("query.delete");
		personaDao.deletePersona(id);
	}
	
	
}
