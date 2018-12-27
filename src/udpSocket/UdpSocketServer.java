package udpSocket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpSocketServer {
    public static void main(String[] args) {
        try {
            DatagramSocket server = new DatagramSocket(5060);
            DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
            System.out.println("初始化服务端UDPSocket,端口：5060,等待数据接收...");
            server.receive(packet);
            System.out.println(packet.getAddress().getHostName() + "(" + packet.getPort() + "):" + new String(packet.getData()));
            packet.setData("Hello Client".getBytes());
            packet.setPort(5070);
            packet.setAddress(InetAddress.getLocalHost());
            server.send(packet);
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}