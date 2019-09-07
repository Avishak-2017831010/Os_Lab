import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;
public class server {
    public static void main(String[] args) throws SocketException, IOException {
        
         DatagramSocket serverSocket = new DatagramSocket(5006);
         Scanner sc = new Scanner(System.in);
         boolean bye=false;
      //int c=5;
      while(true) //instead of c i want to use true
        {
          byte[] receivebuffer = new byte[1024];
          byte[] sendbuffer  = new byte[1024];
          DatagramPacket recvdpkt = new DatagramPacket(receivebuffer, receivebuffer.length);
          serverSocket.receive(recvdpkt);
          InetAddress IP = recvdpkt.getAddress();
          int portno = recvdpkt.getPort();
          String clientdata = new String(recvdpkt.getData());
          System.out.println("\nClient : "+ clientdata);
          System.out.print("\nServer : ");
          String serverdata = sc.nextLine();
          //BufferedReader serverRead = new BufferedReader(new InputStreamReader (System.in) );
          //String serverdata = serverRead.readLine();
          
          sendbuffer = serverdata.getBytes();
          DatagramPacket sendPacket = new DatagramPacket(sendbuffer, sendbuffer.length, IP,portno);
          serverSocket.send(sendPacket); 

          if(serverdata.equalsIgnoreCase("bye"))
          {
              System.out.println("connection ended by Avishak");
              break;
          }
          
          
      }
        serverSocket.close();
    }
}