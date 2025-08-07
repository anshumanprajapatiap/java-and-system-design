package com.anshumanprajapati.solid.openclose;

import com.anshumanprajapati.solid.singleresponsibility.Invoice;

public class DatabaseInvoiceDao implements InvoiceDao{
    @Override
    public void save(Invoice invoice) {
        // save to DB
    }
}
