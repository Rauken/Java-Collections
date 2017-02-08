package trainee05v2;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
	
	static int i=0;
	static Scanner sc = new Scanner(System.in);
	static String cargo;
	static List<Empleo> empleados = new LinkedList<Empleo>();
	static List<String> hijo = new LinkedList<String>();
	static Map<String, List> padre = new HashMap<String, List>(); 
	
	public static void main(String[]args){
		int op = 0;
		do{
			System.out.println("|-----------------------|");
			System.out.println("|1.-Ingresar Cargo      |");
			System.out.println("|2.-Mostrar Cargo       |");
			System.out.println("|3.-Ingresar Empleado   |");
			System.out.println("|4.-Mostrar Empleados   |");
			System.out.println("|5.-Asignar Sub-cargo   |");
			System.out.println("|-----------------------|");
			System.out.print("\nIngrese una opcion");
			op = sc.nextInt();
			switch(op){
				case 1:insertarCargo();break;
				case 2:Cargo.mostrar();break;
				case 3:Empleado();break;
				case 4:mostrarEmpleados();break;
				case 5:asignarSubcargo();break;
				default: System.out.println("Opcion no valida");
			}
		}while(op != 5);
	}//main
	private static void asignarSubcargo() {
		int padre, hijo, ciclo=0;
		Cargo.mostrar();
		do{
			System.out.print("Asigne un Cargo Padre: ");
			padre = sc.nextInt();
			if(Cargo.cargo.containsKey(padre) == true){
				ciclo++;
			}else{
				System.out.println("Ingrese un cargo valido");
			}
		}while(ciclo==0);
		do{
			System.out.print("Asigne un Cargo Hijo: ");
			hijo = sc.nextInt();
			if(Cargo.cargo.containsKey(hijo) == true && hijo != padre){
				ciclo++;
			}else{
				System.out.println("Ingrese un cargo valido");
			}
		}while(ciclo==0);
	}
	private static void mostrarEmpleados() {
		for (Map.Entry<Integer, String> entry : Cargo.cargo.entrySet()) {
		    System.out.println("clave=" + entry.getKey() + ", valor=" + entry.getValue());
			for(Empleo e: empleados){
				if(e.getId() == entry.getKey()){
					System.out.println("\t"+e.getId()+" "+e.getNombre()+" "+e.getDato()+" "+e.getNota());}
			}
		}
	}
	private static void insertarCargo() {
		System.out.print("Ingrese Cargo: ");
		cargo = sc.next();
		Cargo.ingreso(cargo);
	}
	private static void Empleado() {
		int count=0;
		do{
			Cargo.mostrar(); //muestra los cargos a elegir
			System.out.print("Elija un Cargo");
			int ingreso = sc.nextInt();
			if(Cargo.cargo.containsKey(ingreso) == true){
				//ingresa los valores apra el nuevo empleado
				Scanner sc = new Scanner(System.in);
				System.out.print("Ingrese nombre: ");
				String nombre = sc.nextLine();
				System.out.print("Ingrese dato: ");
				String dato = sc.nextLine();
				System.out.print("Ingrese nota: ");
				String nota = sc.nextLine();
				//crea el nuevo empleado
				Empleo e = new Empleo(ingreso, nombre, dato, nota);
				//lo agrega a la lista de neuvos empleados
				empleados.add(e);
				System.out.print("Desea agregarle otro empleado?: (y/n)");
				String repetir = sc.next();
				if(repetir.equals("n")){
					count++;
					}
			} else {
				System.out.println("Cargo incorrecto");
				count++;
			}
		}while(count==0);
	}
}//class	