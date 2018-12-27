package udpSocket;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpSocketClient {
    public static void main(String[] args){
        try {
            DatagramSocket client = new DatagramSocket(5070);
            DatagramPacket packet = new DatagramPacket(new byte[1024],1024);
            System.out.println("初始化客户端UDPSocket,端口：5070,准备发送数据...");
            packet.setPort(5060);
            packet.setAddress(InetAddress.getLocalHost());
            packet.setData("Hello Server".getBytes());
            client.send(packet);
            client.receive(packet);
            System.out.println(packet.getAddress().getHostName() + "(" + packet.getPort() + "):" + new String(packet.getData()));
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}