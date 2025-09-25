package com.anshumanprajapati.tcp;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TcpClient {


    public static void main(String[] args) {
        String host = "127.0.0.1"; // localhost
        int port = 5001;

        try (Socket socket = new Socket(host, port)) {

            Scanner sc = new Scanner(System.in);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            while(true){
                String line = sc.nextLine();
                // Send message
                System.out.println(line);
                out.println(line);

                // Receive response
                String response = in.readLine();
                System.out.println("Server says: " + response);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
