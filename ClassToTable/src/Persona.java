

import java.time.LocalDate;

public class Persona {
	Integer id_persona;
	String nome;
	String cognome;
	LocalDate data_di_nascita;
	public Persona(Integer id_persona, String nome, String cognome, LocalDate data_di_nascita) {
		super();
		this.id_persona = id_persona;
		this.nome = nome;
		this.cognome = cognome;
		this.data_di_nascita = data_di_nascita;
	}
	public Persona(String nome, String cognome, LocalDate data_di_nascita) {
		super();
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
	
	@Override
	public String toString() {
		return "Persona [id_persona=" + id_persona + ", nome=" + nome + ", cognome=" + cognome + ", data_di_nascita="
				+ data_di_nascita + "]";
	}
	
}
