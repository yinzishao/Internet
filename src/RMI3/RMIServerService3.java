/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI3;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Administrator
 */
public interface RMIServerService3 extends Remote{
        
        public String echo(String msg) throws RemoteException;
        //用于客户加入群组的远程方法，在name中包含自己的学号和姓名
        public String addClientToOnLine(RMIClientService client,String name) 
                    throws RemoteException;
        //退出群组的远程方法
        public String delClientFromOnLine(RMIClientService client) 
                                                   throws RemoteException;
        //用于客户发送聊天信息的远程方法
        public void sendMessageToServer(String msg)throws RemoteException;

    
}
