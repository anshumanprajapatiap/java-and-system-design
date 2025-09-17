package com.anshumanprajapati.walmart.ijp.ijp3;

import java.util.ArrayList;
import java.util.List;

public class Round2 {
}


/*
 Trans    Entiy -> {list of trans}
  transId
  photoId
  phonenumber
  firstname
  lastname
  address line 1
  address line
  city
 */

// list<transaction> -> building input -> sparkApplication -> response -> parse it back -> Btables
// comp -> photoid_firstname_lastname


/*
    metadata
        rule1 -> config1 and config2
        rule2 -> config2  and config3

    config

        config1
        config2
        config3


 */


class GenerateRule{
    String basePath;
    String pathMetaData;

    // Rule1, List<Config> -> con1 and con2

}

class Config{
//
}


interface  Rules{
    public boolean isFraud(Trans trans);
}

class Rule1 implements  Rules{
    public boolean isFraud(Trans trans){
        if(trans.amount>100) return false;
        return true;
    }
}

class Rule2 implements  Rules{
    public boolean isFraud(Trans trans){
        if(trans.name.length() > 20) return false;
        return true;
    }
}

// transaction list -> rules -> transaction is fraud or not -> alerting
class AlertItem{
    String name;
    String phoneNumber;
    String email;
    String msg;
}
class Trans{
    String id;
    double amount;
    String name;
}

class App{
    Fraud fraud;
    public void run(){
        this.fraud = new Fraud("/path/to/file");

    }

    public boolean detechTransaction(Trans trans){
        return fraud.detectTrans(trans);
    }
}

class Fraud{
    List<Rules> listOfRules = new ArrayList<>();
    Fraud(String path){
        // read from json
        // and build the rules;

        listOfRules.add(new Rule1());
        listOfRules.add(new Rule2());

    }

    public boolean detectTrans(Trans trans){
        // FIX SIZE THREAD POOL
        return true;
    }


    public List<Rules> buildRule(){
        List<Rules>  rules =  new ArrayList<>();
        return rules;
    }
//    {
//        "rules" : [
//               "rule1" : {
//                "firstname": {
//                    "length": 10
//                     }
//                 }
//                ]
//    }

}

class AlertStrategyFactory{

    AlertingStrategy sms;
    AlertingStrategy mail;

    AlertStrategyFactory(){
        this.sms = new SMSAlertingStrategy();
        this.mail = new MailAlertingStrategy();
    }


    AlertingStrategy getStrategy(String strategy){
        if(strategy.equals("SMS")){
            return sms;
        }else if(strategy.equals("MAIL")){
            return mail;
        }
        return null;
    }
}



class Alert{
    AlertingStrategy strategy;

    Alert(AlertingStrategy strategy){
        this.strategy = strategy;
    }

    void sendAlert(AlertItem item){
        strategy.sendAlert(item);
    }

}


interface AlertingStrategy{
    public void sendAlert(AlertItem item);
}


class SMSAlertingStrategy implements  AlertingStrategy{
    public void sendAlert(AlertItem item){
        //send sms alert to
    }
}


class MailAlertingStrategy implements  AlertingStrategy{
    public void sendAlert(AlertItem item){
        //send mail alert to
    }
}
