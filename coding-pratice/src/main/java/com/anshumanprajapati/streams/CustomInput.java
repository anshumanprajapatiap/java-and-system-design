package com.anshumanprajapati.streams;

import java.io.*;

public class CustomInput {

    static String data = "1 anshuman 4000000 \n" +
            "2 mayank 5000000 \n" +
            "3 anshuman 4000000 \n" +
            "4 anshuman 4000000 \n" +
            "5 anshuman 4000000 \n" +
            "6 anshuman 4000000 \n" +
            "7 anshuman 4000000 \n" +
            "8 anshuman 4000000 \n";

    public static void main(String[] args) {
        InputStream inputStream = new ByteArrayInputStream(data.getBytes());

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Process each line
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
