package com.jdbcmanager;

import java.util.List;

import dao.AnimaleDAO;
import dao.PersonaDAO;
import objects.Animale;
import objects.Persona;

public class ServicesQuery {
	private SQLManager db = new SQLManager();
	private PersonaDAO personaDao = new PersonaDAO();
	private AnimaleDAO animaleDao = new AnimaleDAO();
	
	public void executeQuery() throws Exception{
		listTable();
		getPersone();
		getAnimali();
		getInnerJoinPersoneAnimali();
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
	
	
}
