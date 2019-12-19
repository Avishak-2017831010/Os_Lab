
package dining_philosopher;

public class Forks {
    
    int forkId;
    private boolean status;
    
    Forks(int forkId)
    {
        this.forkId=forkId;
        this.status=true;
    }
    
    public synchronized void free()
    {
        status=true; 
    }
    public synchronized boolean pick(int philid) throws InterruptedException
    {
       int cnt=0;
       int wait=100000;
       
       while(!status)
       {
           Thread.sleep(10000);
           cnt++;
           
           if(cnt>wait)
           {
               return false;
           }
       }
       
       status=false;
       return true;
    }
    
}
