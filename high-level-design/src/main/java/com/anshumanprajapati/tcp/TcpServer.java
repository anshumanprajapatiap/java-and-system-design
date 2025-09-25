package com.anshumanprajapati.tcp;

import java.io.*;
import java.net.*;
import java.util.concurrent.ConcurrentHashMap;



public class TcpServer {
    static class Response{
        Object value;
        String message;
        boolean status;
        Response(Object obj, String message, boolean stat){
            this.value = obj;
            this.message = message;
            this.status = stat;
        }

        public String toString(){
            return "Value: " + value + ", message: "+ message +  ", status: " + status;
        }
    }
    private static ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<>();

    public static void main(String[] args) throws IOException {
        int port = 5001;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("TCP Server is running on port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress());

                // Handle client in a new thread so multiple clients can connect
                new Thread(() -> {
                    try {
                        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                        String message;
                        while ((message = in.readLine()) != null) {
                            System.out.println("Received: " + message);
                            Response res =  processCmd(message);
                            out.println("Server received: " + res.toString());
                        }

                        clientSocket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        }
    }


    public static Response processCmd(String cmdString){
        String[] cmd = cmdString.split(" ");
        if(cmd[0].equalsIgnoreCase("get")){

            if(cmd.length==2){
                if(map.containsKey(cmd[1])){
                    System.out.println(map.get(cmd[1]));
                    return new Response(map.get(cmd[1]), "Success", true);
                }
                return new Response(null, "Not available", true);
            }
            return new Response(null, "Invalid args", false);

        }
        else if(cmd[0].equalsIgnoreCase("put")){
            if(cmd.length==3){
                map.put(cmd[1], cmd[2]);
                return new Response(map.get(cmd[1]), "key " + cmd[1] + " - Success", true);
            }
            return new Response(null, "Invalid args", false);
        }
        return new Response(null, "Invalid args", false);
    }
}
