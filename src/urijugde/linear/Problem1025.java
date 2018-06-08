package urijugde.linear;
import java.io.*;
import java.util.Scanner;
import dataStructures.Sorts;
/**
 * Problem 1025 Where is the marble?
 * @author jucat
 *
 */
public class Problem1025 {	
	public static void main(String args[]) {
		try {
			
			Scanner sc = new Scanner(System.in);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			int c = 1;//case n
			while(true) {
							
				int n=sc.nextInt();
				int Q=sc.nextInt();
				if(n==Q & n==0) break;
				bw.write("CASE #"+Integer.toString(c++)+":\n");
				
				int[] marbles = new int[n];
				
				for(int i=0;i<n;i++) 
					if(marbles[i]==0)	
						marbles[i]=sc.nextInt();
				
				marbles = Sorts.mergeSort(marbles);
				for(int i=0;i<Q;i++) {
					int q =sc.nextInt();
					int p = Sorts.iterativeBinarySearch(marbles,q);
					String output=(p!=-1)?" found at "+Integer.toString(p+1):" not found";
					bw.write(Integer.toString(q)+output+"\n");
				}
			}
			sc.close();
			bw.flush();
			
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
}
