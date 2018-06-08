package dataStructures.bioinformatic;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;


public class SequenceStack {
    Sequence head = null;
    
    public boolean isEmpty()
    {
        return head == null ? true : false;
    }
    
    public void push(Sequence newNode)
    {	
        isEmpty();
        newNode.next = head;
        head = newNode;
    }
    
    public String pop()
    {
        Sequence temp = head;
        if(!isEmpty()) {
        	head = head.next;

        	String info = temp.toString();
        	temp = null;
        	System.gc();
        	return info;
        }else {
        	return null;
        }
        
    }
    
    public String peek(int index)
    {
        Sequence temp = new Sequence();
        temp = head;
        String info;
        for(int i = 0 ; i<index-1;i++)
            temp = temp.next;
        
        info = temp.toString();
        return info;
    }
    
    public void reverse()
    {
        Sequence temp = new Sequence();
        temp = head;
        head = null;
        while(!isEmpty())
            temp = temp.next;
    }
    
    public void printStack()
    {   
        BufferedWriter bw = 
                new BufferedWriter(new OutputStreamWriter(System.out));
        
        try
        {
            bw.write("Grades:\n");
            while(!isEmpty())
            {
                bw.write(pop());
            
            }
            bw.flush();
        }
        catch(Exception ex){ex.printStackTrace();}
    }
}

