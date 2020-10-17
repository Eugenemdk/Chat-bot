package com.company;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

//SendMessage - class for sending messages
//setCharId- shows Id of person,who has written to bot
//update.getMessage().getChatId()-Id of the same person
public class Bot extends TelegramLongPollingBot {
    Currencies currency=new Currencies();
    private  long chat_id;
    //When bot gets message,this function executes
    @Override
    public void onUpdateReceived(Update update) {
        //Refresh User Info
    update.getUpdateId();

        SendMessage sendMessage=new SendMessage().setChatId(update.getMessage().getChatId());
        chat_id=update.getMessage().getChatId();
        sendMessage.setText(input(update.getMessage().getText()));
        //Error Handling
        //update-user
        //execute- send message

            try{
                execute(sendMessage);
            }catch(TelegramApiException e){
                e.printStackTrace();
            }
        }

    //Get Bot name
    @Override
    public String getBotUsername() {
        return "HelloMyCEOBot";
    }
//Get Bot token
    @Override
    public String getBotToken() {
        return "1213988325:AAFqoqwF006ecD07aSLjFwIfLojARPGabw8";
    }
    public String input(String message){
        if(message.contains("Hi") || message.contains("Hello") || message.contains("Привет")){
            return "Hello CEO";
        }else if(message.contains("Currency")){
            return getInfoCourse();
        }
        return message;
    }

    public String getInfoCourse(){
        String info=currency.getTitle()+"\n\nCurrencies: "+currency.getInfo()+"\nBuy/Sell: "+currency.getBuySellValue()+"\n\nNational Bank of Ukraine value \n:"+currency.getNBUvalue();
        return info;
    }
}
