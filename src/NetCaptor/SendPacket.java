/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package NetCaptor;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import jpcap.JpcapCaptor;
import jpcap.JpcapSender;
import jpcap.NetworkInterface;
import jpcap.packet.EthernetPacket;
import jpcap.packet.IPPacket;
import jpcap.packet.TCPPacket;
import jpcap.packet.UDPPacket;
/**
 *
 * @author Administrator
 */
public class SendPacket {
        private JpcapSender sender;
        public SendPacket() throws IOException{
         NetworkInterface[] devices = JpcapCaptor.getDeviceList();
         sender = JpcapSender.openDevice(devices[3]);

        }
        public static void main (String []args) throws IOException{
            new SendPacket().sendTCPPacket();
        }

    private void sendTCPPacket() throws UnknownHostException, UnsupportedEncodingException {
      TCPPacket  tcp=new TCPPacket(8000,80,56,78,false,false,false,false,true,false,true,true,20,10);
      tcp.setIPv4Parameter(0,false,false,false,0,false,false,false,0,1010101,100, IPPacket.IPPROTO_TCP, InetAddress.getByName("192.168.207.91"), InetAddress.getByName ("192.168.207.90"));
      tcp.data=("20131003506 尹子韶").getBytes("GB2312");
      EthernetPacket ether=new EthernetPacket();
      ether.frametype=EthernetPacket.ETHERTYPE_IP;
      tcp.datalink=ether;
      ether.src_mac=new byte[]{(byte)68,(byte)55,(byte)230,(byte)197,(byte)197,(byte)174};
       ether.dst_mac=new byte[]{(byte)00,(byte)17,(byte)93,(byte)156,(byte)148,(byte)00};
       sender.sendPacket(tcp);

    }
}
