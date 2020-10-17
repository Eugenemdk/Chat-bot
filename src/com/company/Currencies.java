package com.company;
import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.IOException;

public class Currencies {
    //Document where information will be stored
private Document document;

    public Currencies() {
        connect();
    }
//connecting to the page
    private void connect() {
        try {
document =  Jsoup.connect("https://minfin.com.ua/currency/banks/odessa/usd/").get();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //Get title of currency
    public String getTitle(){return document.title();}
    //Get Buy value of currency
    public String getInfo(){
        Elements element=document.getElementsByClass("mfcur-table-cur");
        return element.text();}
    public String getBuySellValue(){
        Elements element=document.getElementsByClass("mfm-text-nowrap");
        return element.text();}
    //Get Sell value of currency
   /* public String getSellValue(){
        Elements element=document.getElementsByClass("course");
        return element.text();}*/
    //Get NBU value of currency
    public String getNBUvalue(){
        Elements element=document.getElementsByClass("mfcur-nbu-full-wrap");
        return element.text();}

    }
