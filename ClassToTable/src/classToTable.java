import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class classToTable {
	
	public static <T> String creaTabella(Class<T> obj) {
		
		String query = "create table NAME (FIELDS);";
		
		String className = obj.getName();
		
		List<Object> classAttributes = Arrays.asList(obj.getDeclaredFields());
		
		query = query.replace("NAME", className);
		
		//classAttributes.forEach(a -> System.out.println(a));
		
		Map<String,String> mappa = new HashMap<String, String>();
		
		for(int i = 0; i<classAttributes.size();i++) {
			String[] arr = classAttributes.get(i).toString().split(" ");
			arr[1] = arr[1].replace(className+".", "");
			switch(arr[0]) {
			case "java.lang.String": arr[0] = arr[0].replace("java.lang.String", "varchar(255)"); break;
			case "java.lang.Integer": arr[0] = arr[0].replace("java.lang.Integer", "int"); break;
			case "java.time.LocalDate": arr[0] = arr[0].replace("java.time.LocalDate", "date"); break;
			case "int": arr[0] = arr[0].replace("int", "int"); break;
			default : System.err.println("Tipo"+arr[0] +"non gestito");
			}
			mappa.put(arr[1], arr[0]);
		}
		//System.out.println(mappa);
		
		String mapToStringWithoutDelimiters = mappa.toString().replace("{", "");
		mapToStringWithoutDelimiters = mapToStringWithoutDelimiters.toString().replace("}", "");
		mapToStringWithoutDelimiters = mapToStringWithoutDelimiters.toString().replace("=", " ");
		
		//System.out.println(mapToStringWithoutDelimiters);
		
		query = query.replace("FIELDS", mapToStringWithoutDelimiters);
		
		//String primaryKey = ",primary key(PRIMARY_KEY_FIELD)";
		
		System.out.println(">>> Creazione di una tabella a partire dalla classe: "+className);
		System.out.println(">>> Query da eseguire: \n"+query);
		
		return query;
	}
	
	public static String setPK(String query, String pkName) {
		String rg = ", primary key(PK_NAME)";
		if(!query.contains(pkName)) {
			System.err.println("Campo \""+pkName +"\" non non presente...");
		}else {
			rg = rg.replace("PK_NAME", pkName);
			query = query.replace(");", rg+");");
			System.out.println(">>> Assegnazione PK: "+pkName);
			System.out.println(query);
			return query;
		}
		return null;
		
		
	}
}
