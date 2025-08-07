package com.anshumanprajapati.solid.singleresponsibility;

public class Invoice {

    private Marker marker;
    private int quantity;

    public Invoice(Marker marker, int quantity){
        this.marker = marker;
        this.quantity = quantity;
    }

    public int calculateTotal(){
        int price  = ((marker.price) * this.quantity);
        return price;
    }

//    public void printInvoice(){
//
//    }
//    public void saveToDB(){
//
//    }
}

class InvoicePrinter{
    Invoice invoice;
    public InvoicePrinter(Invoice invoice){
        this.invoice = invoice;
    }

    public void printInvoice(){

    }
}


class InvoiceDao{
    Invoice invoice;
    public InvoiceDao(Invoice invoice){
        this.invoice = invoice;
    }

    public void saveToDB(){

    }
}
