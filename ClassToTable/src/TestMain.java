import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMain {

	public static void main(String[] args) {
		
		String q1 = classToTable.creaTabella(Macchina.class);
		String q2 = classToTable.creaTabella(Persona.class);
		String q3 = classToTable.setPK(q1, "targa");

	}
	
	

}
