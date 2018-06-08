package dataStructures.bioinformatic;

public class SequenceQueue {
    
    Sequence head = null;
    
    public boolean isEmpty()
    {
        return head == null ? true : false;
    }
    
    public void enqueue(Sequence newNode)
    {
        if(isEmpty())
            head = newNode;
        else
        {
            Sequence temp = head;
            while(temp.next != null)
                temp=temp.next;
            temp.next = newNode;
        }
    }
    public String dequeue()
    {
        Sequence temp = head;
        head = head.next;
        String info = temp.toString();
        temp = null;
        //Not truly recommended
        System.gc();
        return info;
    }
}

