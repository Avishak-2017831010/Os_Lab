/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dining_philosopher;

import java.util.Scanner;

public class Dining_Philosopher {
    
    
    Phil[] phil;
    Forks[] forks;
    Thread[] threads;
    int n;
    Scanner Sc;
   
    public static void main(String[] args) { 
        
       Dining_Philosopher obj=new Dining_Philosopher();
       obj.init();
       obj.startThinkEat();
    }

    private void init() {
       Sc=new Scanner(System.in);
       n=Sc.nextInt();
       phil=new Phil[n];
       forks=new Forks[n];
       threads=new Thread[n];
       
       for(int i=0;i<n;i++)
       {
           phil[i]=new Phil(i+1);
           forks[i]=new Forks(i+1);
           
       }
       
    }

    private void startThinkEat() {
        
        for(int i=0;i<n;i++)
        {
            final int ind=i;
            threads[i]=new Thread(new Runnable(){
                @Override
                public void run() {
                    
                    try{
                           phil[ind].start(forks[ind],(ind-1>0)?forks[ind-1]:forks[n-1]);
                }
                    
                    catch(Exception e)
                    {
                        
                    }
                }
                
            });
            
            threads[i].start();
            
        }
    }
    
}
