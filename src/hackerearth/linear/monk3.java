package hackerearth.linear;

import java.io.*;

import dataStructures.*;

public class monk3 {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String L1=br.readLine();
		int N = Integer.parseInt(L1.substring(0, 1));
		if(N>=1 && N<=1000000){
			int[] x = new int[N];
			int[] y = new int[N];
			
			int [] A= new int[N];
			String line = br.readLine();
			String [] aux = line. split(" ");
			for(int i=0; i<aux.length;i++){
				A[i] = Integer.parseInt(aux[i]);				
			}
			

			Stack s = new Stack();
			//we push the first element into the stack
			s.push(A[0]);
			
			for(int i=0;i<N;i++) {
				while(!s.isEmpty() & (int)s.peek(0)<A[i]) {
					x[(int)s.peek(0)]=i;
					s.pop();
				}
				s.push(i);
			}
			
			while(!s.isEmpty()) {
				x[(int)s.peek(0)-1]=-1;
				s.pop();
			}
			
			s.push(N);
			//Se invierte el arreglo:
			for(int i=N-1;i>=1;i--) {
				while(!s.isEmpty() & (int)s.peek(0)<A[i]) {
					y[(int)s.peek(0)-1]=i;
					s.pop();
				}
				s.push(i);
			}
			
			while(!s.isEmpty()) {
				y[(int) s.peek(0)]=-1;
				s.pop();
			}
			for(int i=0;i<N;i++) {
				int sum = y[i]+x[i];
				bw.write(Integer.toString(sum)+" ");
			}
			
			bw.flush();
			
		}
	}
}
