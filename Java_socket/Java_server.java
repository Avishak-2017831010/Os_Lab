/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_server;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Avi
 */
public class Java_server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        String line,line1;
        ServerSocket s1 = new ServerSocket(9989);
        Socket ss = s1.accept();
        Scanner sc = new Scanner(ss.getInputStream());
        line = sc.nextLine();
        System.out.println(line);
        line1 = "Received Successfully";
        PrintStream p = new PrintStream(ss.getOutputStream());
        p.println(line1);
    }
    
}
