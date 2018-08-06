package com.jude.file.file.demo;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;

public class UDPClientB {
    public static void main(String[] args) {
        try {
            //向server发起请求
            InetSocketAddress target = new InetSocketAddress("111.231.66.26", 2008);
            //创建客户端socket
            DatagramSocket client = new DatagramSocket();
            //消息
            String message = "I am UDPClientB";
            byte[] sendbuf = message.getBytes();
            //数据包
            DatagramPacket packet = new DatagramPacket(sendbuf, sendbuf.length, target);
            //发送数据包
            client.send(packet);
            //接受server的内容回复
            byte[] buf = new byte[1024];
            DatagramPacket repacket = new DatagramPacket(buf, buf.length);
            client.receive(repacket);
            //处理server回复的内容，然后向内容中的地址与端口发起请求(打洞)
            String receiveMessage = new String(repacket.getData(), 0, repacket.getLength());
            String[] params = receiveMessage.split(",");
            String host = params[0].substring(5);
            String port = params[1].substring(5);
            System.out.println(host + ":" + port);
            sendMessage(host, port, client);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        //向UDPClientA 发起请求(在NAT上打孔)
        private static void sendMessage(String host, String port, DatagramSocket client) {
            try {
                //创建与A的链接
                InetSocketAddress target = new InetSocketAddress(host, Integer.parseInt(port));
                for (; ; ) {
                    //向A发送消息
                    String message = "hello A I am B";
                    byte[] sendbuf = message.getBytes();
                    DatagramPacket packet = new DatagramPacket(sendbuf, sendbuf.length, target);
                    client.send(packet);
                    //接受UDPClientA回复的内容
                    receive(client);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    //接受到UDPClientA的回复内容，穿透完成
    private static void receive(DatagramSocket client){
        try{
            for(;;){
                //将接受到的内容打印
                byte[] buf = new byte[1024];
                //数据包
                DatagramPacket repacket = new DatagramPacket(buf, buf.length);
                client.receive(repacket);

                String receiveMessage = new String(repacket.getData(),0,repacket.getLength());
                System.out.println(receiveMessage);
                //记得重新收地址与端口，然后在意新的地址发送内容到UDPClientA，就这样互发就可以了
                int port = repacket.getPort();
                InetAddress address = repacket.getAddress();
                String reportMessage = "B got A message";

                //发送消息
                UDPUtils.sendMessage(reportMessage,address,port,client);
            }
        }catch (Exception e){
         e.printStackTrace();
        }

}

}



















