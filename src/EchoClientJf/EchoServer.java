package EchoClientJf;

import java.io.*;
import java.net.*;

public class EchoServer {
  private int port=8008;
  private ServerSocket serverSocket;

  public EchoServer() throws IOException {
    serverSocket = new ServerSocket(port);//开启8008号监听端口。
    System.out.println("服务器启动");
  }

  private PrintWriter putWriter(Socket socket)throws IOException{
    OutputStream socketOut = socket.getOutputStream();//获取输出流的地址。
    return new PrintWriter(new OutputStreamWriter(socketOut,"GB2312"),true);
     //
  }
  private BufferedReader getReader(Socket socket)throws IOException{
    InputStream socketIn = socket.getInputStream();//告诉我们输入流的地址
    return new BufferedReader(new InputStreamReader(socketIn,"GB2312"));
  }
  public String echo(String msg){
       return "来自服务器: "+msg;
  }

  public void service() {//单客户版本,即每次只能和一个客户建立通信连接。
    while (true) {
      Socket socket=null;
      try {
        socket = serverSocket.accept(); 
         //等待客户连接，有连接就生成一个套接字。阻塞语句.
        System.out.println("New connection accepted ："+socket.getInetAddress());
        BufferedReader br =getReader(socket);//带字符串读的网络输入流。
        PrintWriter pw = putWriter(socket);//带字符串写的网络输出流。

        String msg = null;
        while ((msg = br.readLine())!= null) //从输入流中读入一行字符串。阻塞语句.
         {
             System.out.println(msg);//本地显示。
             pw.println(echo(msg));//向输出流中输出一行字符串。
             pw.println("2:"+echo(msg));//向输出流中输出一行字符串。
             if (msg.equals("bye")) //如果客户发送的消息为“bye”，就结束通信
              break;
        }
      }catch (IOException e) {
         e.printStackTrace();
      }finally {
         try{
           if(socket!=null)socket.close();  //断开连接
         }catch (IOException e) {e.printStackTrace();}
      }
    }
  }

  public static void main(String args[])throws IOException {
    new EchoServer().service();
  }
}

