package objects;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Persona {
	Integer id_persona;
	String nome;
	String cognome;
	LocalDate data_di_nascita;
	List<Animale> animali = new ArrayList<Animale>();
	public Persona(Integer id_persona, String nome, String cognome, LocalDate data_di_nascita) {
		super();
		this.id_persona = id_persona;
		this.nome = nome;
		this.cognome = cognome;
		this.data_di_nascita = data_di_nascita;
	}
	public Persona() {
		super();
	}
	public Integer getId_persona() {
		return id_persona;
	}
	public void setId_persona(Integer id_persona) {
		this.id_persona = id_persona;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public LocalDate getData_di_nascita() {
		return data_di_nascita;
	}
	public void setData_di_nascita(LocalDate data_di_nascita) {
		this.data_di_nascita = data_di_nascita;
	}
	public List<Animale> getAnimali() {
		return animali;
	}
	public void setAnimali(List<Animale> animali) {
		this.animali = animali;
	}
	@Override
	public String toString() {
		return "Persona [id_persona=" + id_persona + ", nome=" + nome + ", cognome=" + cognome + ", data_di_nascita="
				+ data_di_nascita + "]";
	}
	
}
