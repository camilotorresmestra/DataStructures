package dataStructures.bioinformatic;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class SequenceList {
    
    Sequence head = null;
    
    public boolean isEmpy()
    {
        return head == null ? true : false;
    }
    
    public void printList()
    {   
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Sequence temp = head;
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
        catch(Exception ex){ex.printStackTrace();}
    }
    
    public void insertAtBegin(Sequence newNode)
    {
        newNode.next = head;
        head = newNode;
    }
    
    public void insertAtEnd(Sequence newNode)
    {
        if(isEmpy())
            head = newNode;
        else
        {
            Sequence temp = head;
            while(temp.next != null)
                temp=temp.next;
            temp.next = newNode;
        }
    }
    public void deleteAtBegin()
    {
        Sequence temp = head;
        head = head.next;
        temp = null;
        System.gc();
    }
    public void deleteAtEnd()
    {
        Sequence temp = head.next;
        Sequence pre = head;
        while(temp.next != null)
            pre=pre.next;
        System.gc();
        pre.next=null;
        
    }
    
    public void insertAtBetwen(Sequence newNode,int n)
    {
        Sequence temp = head;
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
    public void insertAtindex(Sequence newNode, int index)
    {
        Sequence temp = head;
        for(int i = 0 ; i<index-1;i++)
            temp.next = newNode;
        newNode.next = temp.next;
        temp.next = newNode;
    }
    
    public void deleteAtIndex(int n)
    {
        Sequence temp = head;
        Sequence toDelete;
        for(int i=0;i<n-1;i++)
            temp = temp.next;
        toDelete = temp.next;
        temp.next = temp.next.next;
        toDelete = null;
        System.gc();
        
    }
    
    public void reverse()
    {
        SequenceStack pila = new SequenceStack();
        Sequence temp = head;
        
        while(temp != null)
        {
            pila.push(temp.clone());
            temp = temp.next;
        }
        head = pila.head;
    }
    
    public int length(){
        int counter=0;
        Sequence temp = head;
        while(temp != null){
            counter+=1;
            temp=temp.next;
        }
        return counter;
    }
    
    public Sequence get (int index){
        if( index< this.length()){
            Sequence temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;                
            }
            return temp;
        }
        return null;
    }
    
}
