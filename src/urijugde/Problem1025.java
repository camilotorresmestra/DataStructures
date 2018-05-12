package urijugde;
import java.io.*;
import java.util.Scanner;

public class Problem1025 {	
	
    public static int[] mergeSort(int[] unsorted) {
        int size;
        
        if(unsorted.length>1) {
            
            size=unsorted.length/2;
            int[] left_array = new int[size];
            int[] right_array = new int[unsorted.length-size];//si es impar lo crea de tamaño size+1
            
            //LLenando el arreglo izquierdo
            for(int i=0;i<size;i++) 
                left_array[i]=unsorted[i];
            
            //LLenando el arreglo derecho            
            for(int i=size;i<unsorted.length;i++)
                right_array[i-size]=unsorted[i];
            
            left_array = mergeSort(left_array);
            right_array = mergeSort(right_array);
            
            return merge(left_array,right_array);
        }
        return unsorted;
    }
    
    public static int[] merge(int[] a, int[] b) {
        int size = a.length + b.length; 
        int[] c = new int[size];
        
        int indexA=0, indexB=0, indexC =0;
        
        while(indexA<a.length && indexB<b.length) {
            if(a[indexA]<b[indexB]) {
                c[indexC]=a[indexA];
                indexA++;
            }else {
                c[indexC]=b[indexB];
                indexB++;
            }
            indexC++;
        }
        
        while(indexA<a.length) {
            c[indexC]=a[indexA];
            indexA++;
            indexC++;
        }
        
        while(indexB<b.length) {
            c[indexC]=b[indexB];
            indexB++;
            indexC++;
        }
        
        return c;
    }
	

    /**
     * This function performs an Iterative Binary Search of element x over array a. The function calculates the values for the upper and lower bounds
     * @param a The int array
     * @param x The number wich position one wants to find
     * @return the index of element x on array a, or -1 in case it doesn't exists
     */
	public static int iterativeBinarySearch(int[] a,int x) {
		int lowerBound=0, upperBound=a.length-1, index=-1;

		do {
			int middlePoint=(lowerBound+upperBound)/2;
			if(x==a[middlePoint]) {
				index=middlePoint;
				break;
			}else if(x<a[middlePoint]) {
				upperBound=middlePoint-1;
			}else {
				lowerBound=middlePoint+1;
			}

		}while(lowerBound<upperBound);

		if((lowerBound==upperBound)&&(a[lowerBound]==x))
			index=lowerBound;
		return index;

	}
	
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
				
				marbles = mergeSort(marbles);
				for(int i=0;i<Q;i++) {
					int q =sc.nextInt();
					int p = iterativeBinarySearch(marbles,q);
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
