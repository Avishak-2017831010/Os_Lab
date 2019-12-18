
package boundedbuffer;


public class Consumer extends Thread {
    
    
    private Producer producer;

    public Consumer(Producer producer) {
        this.producer = producer;
    }
    
    public void run()
    {
        try
        {
            while(true)
            {
               int data= producer.consume();
                System.out.println("Consumed By :"+Thread.currentThread().getName()+"\n"+data);
            }
        }
        
        catch(Exception E)
        {
            
        }
    }
    
            
    
    
}
