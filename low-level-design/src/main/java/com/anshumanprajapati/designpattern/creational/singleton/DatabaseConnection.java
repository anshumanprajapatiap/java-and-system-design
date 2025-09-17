package com.anshumanprajapati.designpattern.creational.singleton;


public class DatabaseConnection {

    static private volatile MyConnection connection;

    private DatabaseConnection(String databaseName){
        connection = new MyConnection(databaseName);
    }

    public static MyConnection getConnection(String databaseName){
        if(connection==null) {
            synchronized (MyConnection.class) {
                if (connection == null) {
                    new DatabaseConnection(databaseName);
                }
            }
        }
        return connection;
    }
}
