package dataStructures;
import java.io.*;
import java.util.*;
 
public class Sorts {
	//Utilities:
	/**
	 * This function creates an array of random integers varying from 0 to 1000
	 * 
	 * @param length
	 * @return 
	 */
	public int[] bigArray(int length) {
        Random rd = new Random();
        int[] temp = new int[length];
        
        for(int i=0;i<length;i++) {
            temp[i]=rd.nextInt(1000);
        }
        return temp;
    }
    
	/**
	 * A function to efficiently print an int array using BufferedWriter
	 * @param array
	 * @throws IOException
	 */
    public void printArray(int[] array) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0;i<array.length;i++)
            bw.write(array[i]+" ");
        bw.write("\n");
        bw.flush();
    }
    
	//Sorting Algorithms:
	
    public void bubbleSort(int[] unsorted) {
 
        boolean swap;
        int temp;
        do {
            swap=false;
            for(int i=0;i<(unsorted.length-1);i++) {
                if(unsorted[i]>unsorted [i+1]){
                    temp=unsorted[i];
                    unsorted[i]=unsorted[i+1];
                    unsorted[i+1]=temp;
                    swap=true;
                }
            }
        }
        while(swap);
    }
    
    public void insertionSort(int[] unsorted) {
        int temp, indexHole;
        
        for(int i=1; i< unsorted.length; i++) {
            temp=unsorted[i];
            indexHole=i;
            
            while(indexHole>0 && unsorted[indexHole-1]>temp) {
                unsorted[indexHole]=unsorted[indexHole-1]; //Se corren todos los numeros una posición hacia adelante
                indexHole -=1; //equivalente a  indexHole-- se usa porque en python no hay ++
            }
            unsorted[indexHole]=temp;
        }
    }
    
    public int[] mergeSort(int[] unsorted) {
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
    
    public int[] merge(int[] a, int[] b) {
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
    
    
    
    public int[] countingSort(int[] unsorted) throws IOException {
		int max = Integer.MIN_VALUE;
		int[] aux;
		int index=0;
		for(int i=0;i<unsorted.length;i++)
			if(unsorted[i]>max)
				max=unsorted[i];

		aux = new int[max+1];
		for(int i=0;i<unsorted.length;i++) {
			aux[unsorted[i]] +=1;

		}

		for(int i=0;i<aux.length;i++) 
			for(int j=0;j<aux[i];j++) {
				unsorted[index] = i;
				index +=1;
			}
		return unsorted;
	}

    //Searching Algorithms:
    
    /**
     * This function performs an Iterative Binary Search of element x over array a. The function calculates the values for the upper and lower bounds
     * @param a The int array
     * @param x The number wich position one wants to find
     * @return the index of element x on array a, or -1 in case it doesn't exists
     */
    
	public int iterativeBinarySearch(int[] a,int x) {
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

	
	/**
	 * This fuction performs a recursive Binary Search of element x over array a. For the base step use lB=0 and uB=a.lenght 
	 * @param a
	 * @param x
	 * @param lB
	 * @param uB
	 * @return index of element x on array a or -1 in case it doesn't exists
	 */
	public int recursiveBinarySearch(int[] a, int x, int lB, int uB) {
		int middlePoint= (lB+uB)/2;
		if(lB==uB) {
			if(x==a[middlePoint]){
				return middlePoint;
			}else {
				return -1;
			}
		}else {
			if(x==a[middlePoint]) {
				return middlePoint;
			}else {
				if(x<a[middlePoint]) {
					return recursiveBinarySearch(a,x,lB,middlePoint);
				}else {
					return recursiveBinarySearch(a,x,middlePoint+1,uB);
				}
			}
		}
	}
    
    public static void main(String[] args) throws IOException {
        
        Sorts sorts = new Sorts();
        
        int[] a= sorts.bigArray(1000);
        int[] b= a.clone(),c= a.clone(),d=a.clone();
                
        sorts.printArray(a);
        int start = (int) System.nanoTime();
        sorts.bubbleSort(a);
        int end = (int) System.nanoTime();
        int duration = (int) (end-start);
        System.out.println("Execution Time: "+duration+" nanoseconds");
        sorts.printArray(a);
        
        sorts.printArray(b);
        start=(int) System.nanoTime();
        sorts.insertionSort(b);
        end=(int) System.nanoTime();
        duration = end-start;
        System.out.println("Execution Time: "+duration+" nanoseconds");
        sorts.printArray(b);
        
        sorts.printArray(c);
        start=(int) System.nanoTime();
        c=sorts.mergeSort(c);
        end=(int) System.nanoTime();
        duration = end-start;
        System.out.println("Execution Time: "+duration+" nanoseconds");
        sorts.printArray(c);
        
        int[] duration1 = new int[6];  

	

		sorts.printArray(d); 

		start=(int) System.nanoTime(); 

		d=sorts.countingSort(d); 

		end=(int) System.nanoTime(); 

		duration1[3] = end-start; 

		System.out.println("Counting Sort:"); 

		sorts.printArray(d); 

		System.out.println("Execution Time: "+duration1[3]+" nanoseconds"); 

		Random rd = new Random();
		int number2Search = rd.nextInt(10);
		int index;

		start=(int) System.nanoTime(); 

		index = sorts.iterativeBinarySearch(a,number2Search);

		end=(int) System.nanoTime(); 
		duration1[4] = end-start; 

		System.out.println("Number: "+number2Search+" found in position: "+index+"\nExecution Time: "+duration1[4]+" nanoseconds"); 
		start=(int) System.nanoTime(); 

		index = sorts.recursiveBinarySearch(a,number2Search,0,a.length);

		end=(int) System.nanoTime(); 
		duration1[5] = end-start; 

		System.out.println("Number: "+number2Search+" found in position: "+index+"\nExecution Time: "+duration1[5]+" nanoseconds");

    }
}

