package com.example.vit_appdevelopment.Inheritance;

public class Gst extends IncomeTax{
    String mobilePhone;
    @Override
    int calculateTax(int income) {
        int oldTax =  super.calculateTax(income);
        int newTax = 1000;
        return oldTax+newTax;
    }
}
