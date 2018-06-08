/**
 * 
 */
package urijugde.linear;
import java.io.*;

public class Problem1211 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int counter =0;
		char[] phoneArray = br.readLine().toCharArray();
		for (int i=0; i<N-1; i++) {
			char[] phone2 = br.readLine().toCharArray();
			//int start = (int)System.nanoTime();
			for(int j=0;j<phoneArray.length;j++) {
				if (phone2[j]==phoneArray[j]) {
					counter++ ;
				}else {
					j=phoneArray.length;
					phoneArray = phone2;
				}
			}
			//int end =(int) System.nanoTime();
			//bw.write("EXECUTION TIME: "+Integer.toString(end-start)+"\n");
			
		}
		
		bw.write(Integer.toString(counter));
		bw.flush();
	}
}
