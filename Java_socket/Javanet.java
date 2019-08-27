/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javanet;
import java.net.*;
import java.io.*;
import java.util.Scanner;

//10.100.51.115
public class Javanet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
       
        int number,temp;
        String line,line2;
        Scanner sc = new Scanner(System.in);
        
        Socket s = new Socket("10.100.169.84",9989);
        Scanner sc1 = new Scanner(s.getInputStream());
        System.out.println("Enter your message:");
        line = sc.nextLine();
        PrintStream p = new PrintStream(s.getOutputStream());
        p.println(line);
        line2 = sc1.nextLine();
        System.out.println(line2);
        
        
        
        
        
    }
    
}
