package dataStructures;
import java.io.*;

public class List {
    
    public Node head = null;
 
    
    public int length() {
        int counter=0;
        if(!this.isEmpty()) {
	        Node temp =head;
	        while(temp!=null) {
	            temp=temp.next;
	            counter++;
	        }
        }
        return counter;
    }
    /**
     * Performs Linear Search and retrieves the 
     * index of the Node with the given value or -1
     * if it does not exist
     * @param v
     * @return 
     */
    public int linearSearch(double v) {
    	int pos=0;
    	Node temp = this.head;
    	while(temp!=null) {
    		if(temp.value==v)
    			return pos;
    		temp=temp.next;
    		pos++;
    	}
    	return -1;
    }
    public Node get(int index) {
        if(index < this.length() && index>=0) {
            Node temp = head;
            for(int i =0;i<index;i++) {
                temp = temp.next;
            }
            return temp;
        }
        return null;
    }

    public boolean isEmpty()
    {
        return head == null ? true : false;
    }
    
    public void printList()
    {   
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Node temp = head;
        try
        {
            bw.write("Grades:\n");
            while(temp != null)
            {
                bw.write(temp.toString()+"\n");
                temp = temp.next;
            }
            bw.flush();
        }
        catch(Exception ex){throw new RuntimeException(ex);}//https://epere4.blogspot.com.co/2007/07/por-qu-la-gente-hace-eprintstacktrace.html
    }
    
    public void insertAtBegin(Node newNode)
    {
        newNode.next = head;
        head = newNode;
    }
    
    public void insertAtEnd(Node newNode){
        if(isEmpty())
            head = newNode;
        else
        {
            Node temp = head;
            while(temp.next != null)
                temp=temp.next;
            temp.next = newNode;
        }
    }
    public void deleteAtBegin()
    {
    	Node temp = head;
        head = temp.next;
        temp = null;
        System.gc();
    }
    public void deleteAtEnd()
    {
        Node temp = head.next;
        Node pre = head;
        while(temp.next != null)
            pre=pre.next;
        System.gc();
        pre.next=null;
        
    }
    
    public void insertAtBetwen(Node newNode,int n)
    {
        Node temp = head;
        for(int i=0;i<n;i++)
        {
           temp = temp.next;
           if(temp == null) break;
        }
        if(temp == null) System.out.println("La  posicion no existe");
        else
        {
            newNode.next = temp.next;
            temp.next = newNode;
        }
               
    }
    public void insertAtindex(Node newNode, int index)
    {
        Node temp = this.get(index-1);
        if(temp!=null) {
	        newNode.next = temp.next;
	        temp.next = newNode;
        }
    }
    
    public void deleteAtIndex(int n)
    {
        Node temp = this.get(n-1);
        if(temp!=null) {
	        @SuppressWarnings("unused")
			Node toDelete=temp.next;
	        temp.next = temp.next.next;
	        toDelete = null;
        }
    }
    
    public void reverse()
    {
        Stack pila = new Stack();
        Node temp = head;
        
        while(temp != null)
        {
            pila.push(temp.clone());
            temp = temp.next;
        }
        head = pila.head;
        
        
    }
    
    public void sort(List unsorted) {
    	   	
    	if (unsorted == null || unsorted.length()==0)
    		return;
    	
    	int number=unsorted.length();
    	quicksort(0,number-1, unsorted);
    }
    
    public void quicksort(int lowerBound, int upperBound, List unsorted) {
    	int i = lowerBound, j=upperBound;
    	double pivot = unsorted.get(lowerBound+(upperBound-lowerBound)/2).value;
    	
    	while(i<=j) {
    		while(unsorted.get(i).value<pivot) {
    			i+=1;
    		}
    		while(unsorted.get(j).value>pivot) {
    			j-=1;
    		}
    		
    		if(i<=j) {
    			swap(i,j);
    			i+=1;j+=1;
    		}
    	}
    	
    	if(lowerBound<j) 
    		quicksort(lowerBound,j,unsorted);
    	if(i<upperBound) 
    		quicksort(i,upperBound, unsorted);
    	
    }
    
    public void swap(int i, int j) {
    	
		Node previ=this.get(i-1), prevj=this.get(j-1);
		Node Ni=previ.next, Nj=prevj.next;
		
		previ.next=Nj;
		prevj.next=Ni;
	}
    
	/**
	 * returns a sublist with elements ranging from index begin to end
	 * @param begin
	 * @return
	 */
	public List sublist(int begin)
	{
		List subList = new List();
		
		if(begin < this.length())
		{
			Node temp = head;
			
			for(int i = 0; i < begin; i++)
				temp = temp.next;
			
			while(temp != null)
			{
				subList.insertAtEnd(temp.clone());
				temp = temp.next;
			}
		}
		
		return subList;
	}
	
	/**
	 * Returns a sublist between two indexes
	 * @param begin
	 * @param end
	 * @return
	 */
	public List sublist(int begin, int end)
	{
		List subList = new List();
		if(end<this.length() && end>begin) {
			for(int i=0;i<=end;i++) {
				if(begin < this.length())
				{
					Node temp = head;
					
					for(int j = 0; j < begin; j++)
						temp = temp.next;
					
					while(temp != null)
					{
						subList.insertAtEnd(temp.clone());
						temp = temp.next;
					}
				}
			}
		}
		
		return subList;
	}
	
	/**
	 * Creates a new List by creating copis of each of its elements.
	 * @return
	 */
	public List cloneList()
	{
		List clone = new List();
		Node a=this.head;
		a = clone.head;
		
		for(int i=0; i<this.length();i++) {
			a.next=this.get(i+1);
			a=a.next;
		}
		return clone;		
	}
	
	public boolean contains(int u) {
		return linearSearch(u)>-1;
	}
	
	public void concat(List list) {
		Node temp = list.head;
		while(temp!=null) {
			Node aux = temp.clone();
			this.insertAtEnd(aux);
			temp=temp.next;
		}

	}
}

