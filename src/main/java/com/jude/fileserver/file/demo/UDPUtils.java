package com.jude.fileserver.file.demo;

import com.alibaba.fastjson.JSONObject;

import java.io.File;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public interface UDPUtils {

    //回复内容
    static void sendMessage(String reportMessage, InetAddress address, int port, DatagramSocket client){
        try{
            byte[] sendBuf = reportMessage.getBytes();
            DatagramPacket packet = new DatagramPacket(sendBuf, sendBuf.length, address, port);
            client.send(packet);
            System.out.println("消息发送成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static Document getAllFile(String path){
        Document document = new Document();
        File file = new File(path);
        document.setName(file.getName());
        if(file.isDirectory()){
            List<Document> documents = new ArrayList<>();
            Arrays.stream(Objects.requireNonNull(file.listFiles())).forEach(f -> {
                documents.add(getAllFile(f.getPath()));
            });
            document.setFileList(documents);
            document.setIsFile(false);
            return document;
        }
        document.setIsFile(true);
        return document;
    }

    public static void main(String[] args){
        String path = "D:\\影音";
        Document allFile = getAllFile(path);
        System.out.println(JSONObject.toJSONString(allFile));
    }
}
