package com.jude.file.file.demo;

import org.springframework.stereotype.Service;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

@Service
public class UDPServer {
    public static void main(String[] args){
        try{
            //数据socket
            DatagramSocket server = new DatagramSocket(2008);
            //缓冲区大小
            byte[] buff = new byte[1024];
            //数据包
            DatagramPacket packet = new DatagramPacket(buff, buff.length);

            //要发送的信息
            String sendMessageA = "";
            String sendMessageB = "";

            //客户端端口号
            int portA = 0;
            int portB = 0;

            //客户端ip地址
            InetAddress addressA = null;
            InetAddress addressB = null;

            //循环接受链接
            for(;;){
                //接受数据
                server.receive(packet);
                //接受到的数据
                String receiveMessage = new String(packet.getData(), 0, packet.getLength());
                System.out.println(receiveMessage);

                //接受到数据
                if(receiveMessage.contains("A")){
                    portA = packet.getPort();
                    addressA = packet.getAddress();
                    sendMessageA = "host:" + addressA.getHostAddress() + ",port:"+portA;
                }
                //接受到B
                if(receiveMessage.contains("B")){
                    portB = packet.getPort();
                    addressB = packet.getAddress();
                    sendMessageB = "host:" +addressB.getHostAddress()+",port:"+portB;
                }
                //两个都接受到后分别A,B地址交换互发
                if(!sendMessageA.equals("")&&!sendMessageB.equals("")){
                    UDPUtils.sendMessage(sendMessageA,addressB,portB,server);
                    UDPUtils.sendMessage(sendMessageB,addressA,portA,server);
                    sendMessageA = "";
                    sendMessageB = "";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void init(){}
}
