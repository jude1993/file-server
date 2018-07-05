package com.jude.fileserver.file.demo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;

public class UDPClientA {
    public static void main(String[] args){
        try {
            //向server发起请求
            InetSocketAddress target = new InetSocketAddress("111.231.66.26", 2008);
            //创建数据socket
            DatagramSocket client = new DatagramSocket();
            //要发送的数据
            String message = "I am UDPClientA";
            byte[] sendbuf = message.getBytes();
            //组装数据包
            DatagramPacket packet = new DatagramPacket(sendbuf, sendbuf.length, target);
            //发送数据
            client.send(packet);
            //接受请求的回复，可能不是server回复的，有可能来自UDPClientB的请求内容
            receive(client);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //接受请求内容
    private static void receive(DatagramSocket client){
        try{
            for(;;){
                //数据缓冲区
                byte[] buf = new byte[1024];
                //数据包
                DatagramPacket packet = new DatagramPacket(buf, buf.length);
                //接受数据
                client.receive(packet);
                String receiveMessage = new String(packet.getData(), 0, packet.getLength());
                System.out.println(receiveMessage);
                int port = packet.getPort();
                InetAddress address = packet.getAddress();
                String reportMessage = "hello B I am A";
                //获取接受到请求内容后并去到地址与端口，然后获取到地址与端口回复内容
                UDPUtils.sendMessage(reportMessage,address,port,client);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void download(String name, DatagramSocket client){
        try(FileOutputStream fos = new FileOutputStream(name)) {
            byte[] buf = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            client.receive(packet);
            if(packet.getData().length>0){
                fos.write(packet.getData());
                fos.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
