
package dining_philosopher;

import java.util.Random;


public class Phil {
    
    private int PhiloId;
    private Forks R,L;
    
    
    
    
    public Phil(int PhiloId)
    {
        this.PhiloId=PhiloId;
    }
    
    public void start(Forks L,Forks R) throws InterruptedException
    {
        this.L=L;
        this.R=R;
        
        while(true)
        {
            if(new Random().nextBoolean())
            {
                eat();
            }
            
            else
            {
                think();
            }
        }
    }
    
    
    
    public void think() throws InterruptedException
    {
        System.out.println("The Philosopher :"+PhiloId+" is thinking now");
        Thread.sleep(new Random().nextInt(1000)+100);
        System.out.println("The Philosopher :"+PhiloId+" has stopped thinking");
    }
    public void eat() throws InterruptedException
    {
        boolean rightpick=false;
        boolean leftpick=false;
        
        System.out.println("The Philosopher :"+PhiloId+" wants to eat now");
        System.out.println("The Philosopher :"+PhiloId+" picked up the left fork"+L.forkId);
        leftpick=L.pick(PhiloId); 
        
        if(!leftpick)
            return;
        
        System.out.println("The Philosopher :"+PhiloId+" picked up the right fork"+R.forkId);
        rightpick=R.pick(PhiloId);
        
        if(!rightpick)
        {
            L.free();
            return;
        }
        
        System.out.println("The Philosopher "+ PhiloId +" is eating Now");
        Thread.sleep(new Random().nextInt(1000)+100);
        
        L.free();
        R.free();
        
        
        System.out.println("The Phisopher "+PhiloId+" put the forks down");
        
        
        
    }
    
    
    
}
