package com.anshumanprajapati.walmart.ijp.ijp2;

import java.util.List;
import java.util.Map;

public class Round2 {
}

class Sync{
    String name;

    public void updateName(String name){
        synchronized (name) {
            this.name = name;
        }
    }

    public void resetName(){
        synchronized (name) {
            this.name = "";
        }
    }
}



class Singleton{

    private  volatile  Database database;

    Database getDatabase(){
        if(this.database==null){
            synchronized (this){
                if(database==null) this.database = new Database();
            }
        }
        return this.database;
    }

}

class Database{

}


interface Product{

}





// user -> floor -> (button) -> lift -> (button)



class Floor{
    boolean isLift;
    Button button;
}

class Lift{
    int floorNumber;
    List<Button> buttons;
}

enum ButtonType{
    INSIDE_LIFT,
    OUTSIDE_LIFT
}

class Button{
    int floorNumber;
}


class ListController{

}




// user -> floor -> code ->
// mutiple code (same kind of product in a code)

class Item{
    String name;
    String desc;
}


class VentingMachine{
    Map<Integer, Item> codeItemMap;
}


class Office{

    Map<Integer, VentingMachine>  floorVendingMachineMap;

    // list out the product (read)

    // build cart (add to card)

    // process (pin/password)

    // response
}


class Cart{
    List<Item> items;

}




// feed database // billions of transaction

// stream
// -> adding 1 record  ( 100 records)


// -> 10
// -> 1, 2, .... 10











