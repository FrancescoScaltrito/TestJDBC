package objects;

import java.time.LocalDate;

public class Animale {
	Integer id_animale;
	String nome;
	LocalDate data_di_nascita;
	String sesso;
	String tipo;
	String razza;
	Integer id_padrone;
	public Animale(Integer id_persona, String nome, LocalDate data_di_nascita, String sesso, String tipo, String razza,
			Integer id_padrone) {
		super();
		this.id_animale = id_persona;
		this.nome = nome;
		this.data_di_nascita = data_di_nascita;
		this.sesso = sesso;
		this.tipo = tipo;
		this.razza = razza;
		this.id_padrone = id_padrone;
	}
	public Animale() {
		super();
	}
	public Integer get_Id_animale() {
		return id_animale;
	}
	public void setId_animale(Integer id_persona) {
		this.id_animale = id_persona;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getData_di_nascita() {
		return data_di_nascita;
	}
	public void setData_di_nascita(LocalDate data_di_nascita) {
		this.data_di_nascita = data_di_nascita;
	}
	public String getSesso() {
		return sesso;
	}
	public void setSesso(String sesso) {
		this.sesso = sesso;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getRazza() {
		return razza;
	}
	public void setRazza(String razza) {
		this.razza = razza;
	}
	public Integer getId_padrone() {
		return id_padrone;
	}
	public void setId_padrone(Integer id_padrone) {
		this.id_padrone = id_padrone;
	}
	@Override
	public String toString() {
		return "Animale [id_animale=" + id_animale + ", nome=" + nome + ", data_di_nascita=" + data_di_nascita
				+ ", sesso=" + sesso + ", tipo=" + tipo + ", razza=" + razza + ", id_padrone=" + id_padrone + "]";
	}
	
}
