package com.n1ar4.cmd;

import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

@SuppressWarnings("all")
public class SocketTest {

    public static void main(String args[]) throws Exception {
//        getAllClasses();
//        getAllFilters();
//        getAllServlets();
//        getAllValves();
//        getAllListeners();
        getBytecode();
    }

    public static void getBytecode() throws Exception {
        String host = "127.0.0.1";
        int port = 10032;
        Socket client = new Socket(host, port);
        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bao);
        oos.writeObject("<KILL-FILTER>Tomcat");
        client.getOutputStream().write(bao.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(client.getInputStream());
        byte[] data = (byte[]) ois.readObject();
        Files.write(Paths.get("test.class"), data);
    }

    public static void getAllClasses() throws Exception {
        String host = "127.0.0.1";
        int port = 10032;
        Socket client = new Socket(host, port);
        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bao);
        oos.writeObject("<ALL>");
        client.getOutputStream().write(bao.toByteArray());

        ObjectInputStream ois = new ObjectInputStream(client.getInputStream());
        ArrayList<String> arrayList = (ArrayList<String>) ois.readObject();
        for (String s : arrayList) {
            System.out.println(s);
        }
    }

    public static void getAllServlets() throws Exception {
        String host = "127.0.0.1";
        int port = 10032;
        Socket client = new Socket(host, port);
        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bao);
        oos.writeObject("<SERVLETS>");
        client.getOutputStream().write(bao.toByteArray());

        ObjectInputStream ois = new ObjectInputStream(client.getInputStream());
        ArrayList<String> arrayList = (ArrayList<String>) ois.readObject();
        for (String s : arrayList) {
            System.out.println(s);
        }
    }

    public static void getAllFilters() throws Exception {
        String host = "127.0.0.1";
        int port = 10032;
        Socket client = new Socket(host, port);
        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bao);
        oos.writeObject("<FILTERS>");
        client.getOutputStream().write(bao.toByteArray());

        ObjectInputStream ois = new ObjectInputStream(client.getInputStream());
        ArrayList<String> arrayList = (ArrayList<String>) ois.readObject();
        for (String s : arrayList) {
            System.out.println(s);
        }
    }

    public static void getAllListeners() throws Exception {
        String host = "127.0.0.1";
        int port = 10032;
        Socket client = new Socket(host, port);
        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bao);
        oos.writeObject("<LISTENERS>");
        client.getOutputStream().write(bao.toByteArray());

        ObjectInputStream ois = new ObjectInputStream(client.getInputStream());
        ArrayList<String> arrayList = (ArrayList<String>) ois.readObject();
        for (String s : arrayList) {
            System.out.println(s);
        }
    }

    public static void getAllValves() throws Exception {
        String host = "127.0.0.1";
        int port = 10032;
        Socket client = new Socket(host, port);
        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bao);
        oos.writeObject("<VALVES>");
        client.getOutputStream().write(bao.toByteArray());

        ObjectInputStream ois = new ObjectInputStream(client.getInputStream());
        ArrayList<String> arrayList = (ArrayList<String>) ois.readObject();
        for (String s : arrayList) {
            System.out.println(s);
        }
    }
}