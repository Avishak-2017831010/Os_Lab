
package boundedbuffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Producer extends Thread {
    
    private static final int size=3;
    Queue<Integer>q=new LinkedList<>();
    
    public void run()
    {
        try{
            
            while(true)
            {
                produce();
            }
            
        }
        
        catch(Exception e)
        {
            
        }
    }
    
    int i=0;

    private synchronized void  produce() throws InterruptedException {
        
        while(q.size()==size)
        {
            wait();
        }
        
        int data=i++;
        q.add(data);
        System.out.println("Produced "+data);
        notify();
    }
    
    public synchronized int consume() throws InterruptedException 
    {
        notify();
        while(q.isEmpty())
        {
            wait();
        }
        
        int c=q.peek();
        q.remove();
        return c;
        
    }
    
    
    
    
    
    
}
