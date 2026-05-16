package com.example.dsapp.network;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class NetworkClient {
    public static final String HOST = "192.168.1.249";
    public static final int PORT = 4321;

    public static Object sendRequest(Object request) throws Exception {
        try (Socket sock = new Socket(HOST, PORT);  //sindesi me tcp socket ston master
             ObjectOutputStream out = new ObjectOutputStream(sock.getOutputStream());
             ObjectInputStream in = new ObjectInputStream(sock.getInputStream())) {

            out.flush();

            out.writeObject(request);
            out.flush();

            return in.readObject();
        }
    }
}