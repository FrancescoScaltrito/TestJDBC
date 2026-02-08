import com.jdbcmanager.ConnectorJDBC;
import com.jdbcmanager.ServicesQuery;

public class Main_TestDBSQL {
	public static void main(String[] args) {
		System.out.println("Begin Main_TestDBSQL");
		int operazione = 2;
		try {
			ConnectorJDBC.getInstance().getConnection();
			System.out.println("Conn OK");
			new ServicesQuery().executeQuery(operazione);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
