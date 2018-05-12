package urijugde;
import java.io.*;

public class problem1281 {
	public static void main(String args[])  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			int N = Integer.parseInt(br.readLine()),M,P;	
			double[] prices;
			String[] products;
			
			for(int i=0;i<N;i++) {
				double total =0.0;
				M=Integer.parseInt(br.readLine());
				prices= new double[M];
				products = new String[M];
				
				for(int j=0;j<M;j++) {
					String[] temp = br.readLine().split(" ");
					products[j]=temp[0];
					prices[j]=Double.parseDouble(temp[1]);
				}
				
				P = Integer.parseInt(br.readLine());
				for(int j=0;j<P;j++) {
					String[] productQuantity = br.readLine().split(" ");
					int q = Integer.parseInt(productQuantity[1]);
					//Búsqueda lineal a través de la lista de productos:
					long start=System.nanoTime();
					System.out.println();
					
					for(int k=0;k<M;k++) {
						if(productQuantity[0].equals(products[k])) {
							total +=q*prices[k];
							break;
						}
					}
					long end=System.nanoTime();
					bw.write("LINEAR SEARCH EXECUTION TIME: "+Long.toString(end-start)+"\n");
					bw.flush();
					
				}
				
				bw.write("R$ "+ Double.toString(total)+"\n");
				bw.flush();
			}
			
		}catch(Exception ex) {
			throw new RuntimeException(ex);
		}
	}
}
