package com.anshumanprajapati.designpattern.creational.singleton;

import java.sql.DatabaseMetaData;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        DatabaseConnection db = new DatabaseConnection("mydb");

        int n=1000;
        for(int i=0; i<n; i++){
            new Thread(
                    ()->{
                        System.out.println(db.getConnection());
                    }
            ).run();

        }



    }
}
