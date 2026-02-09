import java.time.LocalDate;

import com.jdbcmanager.ConnectorJDBC;
import com.jdbcmanager.ServicesQuery;

import objects.Persona;

public class Main_TestDBSQL {
	public static void main(String[] args) {
		System.out.println("Begin Main_TestDBSQL");
	/*		Operazioni possibili
	 1: listTable(); 
	 2  getPersone();  
	 3: getAnimali();  
	 4: getInnerJoinPersoneAnimali();
	 5: addPersona(p); 
	 6: removePersona(11);
	 7: assegnaPadrone();
	 */
		int operazione = 0;
		try {
			ConnectorJDBC.getInstance().getConnection();
			System.out.println("Conn OK");
			new ServicesQuery().executeQuery(operazione);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
