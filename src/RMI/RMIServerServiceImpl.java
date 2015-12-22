/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Administrator
 */
public class RMIServerServiceImpl extends UnicastRemoteObject implements RMIServerService{
    //默认构造方法
                public RMIServerServiceImpl( )throws RemoteException{ }

    @Override
            public String echo(String msg)throws RemoteException{
                    return "来自RMI的："+msg;
           }

    @Override
            public String echo(String yourNo,byte[] yourName) throws RemoteException{
                        return "来自RMI的："+yourNo;
//这是一个课堂记分程序return "来自RMI的："+msg;
            }
}