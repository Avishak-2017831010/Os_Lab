/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundedbuffer;

/**
 *
 * @author Avi
 */
public class BoundedBuffer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Producer producer=new Producer();
        producer.setName("Pro-1");
        producer.start();
        Consumer consumer=new Consumer(producer);
        consumer.setName("Con-1");
        consumer.start();
        
        
        
        
        
        
        
        // TODO code application logic here
    }
    
}
