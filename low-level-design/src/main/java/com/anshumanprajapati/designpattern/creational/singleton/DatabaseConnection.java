package com.anshumanprajapati.designpattern.creational.singleton;


public class DatabaseConnection {

    volatile MyConnection connection;
    String databaseName;

    DatabaseConnection(String databaseName){
        this.databaseName = databaseName;
    }

    MyConnection getConnection(){
        if(connection==null) {
            synchronized (MyConnection.class) {
                if (connection == null) {
                    connection = new MyConnection(databaseName);
                }
            }
        }
        return connection;
    }



}
