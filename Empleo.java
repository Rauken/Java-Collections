package trainee05v2;

public class Empleo{

	int id;
	String nombre;
	String dato;
	String nota;
		
	public Empleo(int id, String nombre, String dato, String nota) {
		this.id = id;
		this.nombre = nombre;
		this.dato = dato;
		this.nota = nota;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDato() {
		return dato;
	}
	public void setDato(String dato) {
		this.dato = dato;
	}
	public String getNota() {
		return nota;
	}
	public void setNota(String nota) {
		this.nota = nota;
	}
}