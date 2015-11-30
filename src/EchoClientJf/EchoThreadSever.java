package EchoClientJf;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class EchoThreadSever {
  private int port=8008;
  private ServerSocket serverSocket;
  private ExecutorService executorService;  //线程池
  private final int POOL_SIZE=15;  //单个CPU时线程池中工作线程的数目

  
  public EchoThreadSever() throws IOException {

serverSocket = new ServerSocket(port);//启动服务器

    //创建线程池
    //Runtime的availableProcessors()方法返回当前系统的CPU的数目
    //系统的CPU越多，线程池中工作线程的数目也越多
    executorService= Executors.newFixedThreadPool(
	    Runtime.getRuntime().availableProcessors() * POOL_SIZE);

    System.out.println("服务器启动");
  }

  public void service() {
        
     while (true) {
      Socket socket=null;
      try {
        socket = serverSocket.accept(); //监听客户请求, 处于阻塞状态.
        //接受一个客户请求,从线程池中拿出一个线程专门处理该客户.
        executorService.execute(new Handler1(socket));
      }catch (IOException e) { e.printStackTrace(); }
    }
  }

  public static void main(String args[])throws IOException {
    new EchoThreadSever().service();
  }
}
class Handler1 implements Runnable{//定义内部类（一个线程类）
  private Socket socket;
  
  public Handler1(Socket socket){
    this.socket=socket;
      }
  private PrintWriter getWriter(Socket socket)throws IOException{
    OutputStream socketOut = socket.getOutputStream();
    return new PrintWriter(new OutputStreamWriter(socketOut,"GB2312"),true);
  }

  private BufferedReader getReader(Socket socket)throws IOException{
    InputStream socketIn = socket.getInputStream();
    return new BufferedReader(new InputStreamReader(socketIn,"GB2312"));
  }

  public void run(){
    try {
      System.out.println("New connection accepted " +
      socket.getInetAddress() + ":" +socket.getPort());

      BufferedReader br =getReader(socket);
      PrintWriter pw = getWriter(socket);

      String msg = null;
      while ((msg = br.readLine()) != null) {
        
        pw.println("ThreadServer: "+msg);//send to client.

        if (msg.contains("bye".subSequence(0, 2))){
         System.out.println( socket.getInetAddress() + ":" +"Exit");
            break;
        }
      }
    }catch (IOException e) {
       e.printStackTrace();
    }finally {
       try{
         if(socket!=null)socket.close();
       }catch (IOException e) {e.printStackTrace();}
    }
  }

}
