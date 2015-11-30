/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketAddress;

/**
 *
 * @author Administrator
 */
public class UDOServer {
     private static DatagramSocket socket; //UDP套接字 
     
     public static void main(String [] args)throws IOException{
         InetAddress address = InetAddress.getLocalHost();  
         int port = 8080; 
         socket=new DatagramSocket(port); 
         String msg;
         //先准备一个空数据报文
         DatagramPacket inputPacket=new DatagramPacket(new byte[512],512);
          try {
              //阻塞语句，有数据就装包，以装完或装满为此.
              socket.receive(inputPacket);
              //从报文中取出字节数据并装饰成字符。
              msg=new String(inputPacket.getData(),
                             0,inputPacket.getLength(),"GB2312");
          } catch (IOException ex) {
            msg=null;
          }
          System.out.println("客户端发送的数据为：" + msg);  
          String number = "20131003506 尹子韶 ["+msg+"]";
          InetAddress clientAddress = inputPacket.getAddress(); //获得客户端的IP地址  
          int clientPort = inputPacket.getPort(); //获得客户端的端口号  
          SocketAddress sendAddress = inputPacket.getSocketAddress();  
//          String feedback = "Received";  
          byte[] backbuf = number.getBytes("GB2312");  
          DatagramPacket sendPacket = new DatagramPacket(backbuf, backbuf.length, sendAddress); //封装返回给客户端的数据  
          socket.send(sendPacket);  //通过套接字反馈服务器数据  
              
            socket.close();  //关闭套接字  
//          if(socket!=null)  
//             socket.close();//释放本地端口.
  


     }
}
