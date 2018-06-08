package hackerearth.linear;
import java.io.*;
import java.util.*;
import dataStructures.Stack;
import dataStructures.Node;

public class monk1 {
	public static void main(String args[]) {
		try {
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc= new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Stack monkCoins = new Stack();
		Stack harryCoins = new Stack();
		int N=sc.nextInt();
		for(int i=0;i<N;i++) {
			harryCoins.push(new Node(sc.nextDouble()));
		}
		harryCoins.reverse();
		int Q=sc.nextInt();
		int X=sc.nextInt();
		
		String output= "-1";
		sc.nextLine();
		for(int i=0;i<Q;i++) {
			
			String instruction = sc.nextLine();
			if(instruction.equals("Harry")) {
				monkCoins.push(harryCoins.pop());
				if (monkCoins.total==X) output=Integer.toString(monkCoins.size);
			}else if(instruction.equals("Remove")) {
				monkCoins.pop();
			}
		}
		sc.close();
		bw.write(output);
		bw.flush();
		
				
		}
		catch(Exception ex) {
			throw new RuntimeException(ex);
		}
	}
}
