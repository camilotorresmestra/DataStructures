package dataStructures;
import java.io.*;
public class Recursion {
	public static int factorial(int n) { //Se usa la clase estática porque la clase no genera objetos
		if(n <= 1) return 1;
		else return n * factorial(n-1);
	}

	public static int fibonacci(int n) { //Se usa la clase estática porque la clase no genera objetos
		if(n <=1) return n;
		else return fibonacci(n-1)+fibonacci(n-2);
	}
	
	//Recursión:Se encuentra un patrón y un caso base.
	//ES INEFICIENTE: Si se calculase fibonacci(5) tendría que
	//llamarse muchas veces a un número que ha sido calculado previamente.
	//El método utilizado de manera extremadamente ineficiente. 
	//Se requieren en total 15 llamados a la función.
	
	public static int pascal(int n, int k) { //Se usa la clase estática porque la clase no genera objetos
	     if(k==0 || k==n) return 1;
	     else return pascal(n-1,k-1)+pascal(n-1,k);
	}
	
	public static void printPascal(int n) throws Exception{
		for(int i=0; i<n; i++) {
			for(int j=0; j <=i; j++) { //el j se coloca con respecto a i para que se imprima formando un triángulo
				System.out.print(pascal(i,j)+" "); //Se usa print, en lugar de println
	        }
	        System.out.println();
		}
	}
	
	public static void main(String args[]) {
		try {

			System.out.println(factorial(5));
			//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			bw.write(fibonacci(1));
			bw.flush();

			//EJEMPLO 3:
			//Usando println:
			
			int n=20;
			printPascal(n);
			//usando BufferedReader:
			for(int i=0; i<n; i++) {
				for(int j=0; j <=i; j++) {
					bw.write(pascal(i,j)+" ");
				}
				bw.write("\n");
			}
			bw.flush();
		}
		catch(Exception e){
			throw new RuntimeException(e);
		}
	}


}
