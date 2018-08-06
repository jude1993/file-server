package com.jude.file.file.server;

import com.alibaba.fastjson.JSONObject;
import com.jude.file.file.bean.RequestMessage;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class FileServer {

    public static void main(String[] args){
        try {
            DatagramSocket server = new DatagramSocket(1993);
            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            server.receive(packet);
            String message = new String(packet.getData());
            RequestMessage requestMessage = JSONObject.parseObject(message, RequestMessage.class);
            switch(requestMessage.getType()){
                case "register" : ;

            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void resourceCataloug(){

    }
}
