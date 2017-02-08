package trainee05v2;

import java.util.HashMap;
import java.util.Map;

public class Cargo {

	static Map<Integer, String> cargo = new HashMap<Integer, String>();
	static int i =0;
	
	public static void ingreso(String cargo2) {
		if (cargo.containsValue(cargo2)) {
			System.out.println("Ya Existe este cargo");
		}else{
			cargo.put(i, cargo2);
			i++;
			System.out.println("Cargo creado");
		}
	}//ingreso
	public static void mostrar() {
		if(cargo.isEmpty()){
			System.out.println("No hay cargos");
		}else{
			cargo.forEach((k, v) -> System.out.println(" "+k+". -Cargo: "+v));	
		}
	}
}//class