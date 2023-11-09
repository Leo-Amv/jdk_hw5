package ru.gb;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        LogHandler logHandler = new LogHandler("./Chat_Log");

        ChatWindow chat1 = new ChatWindow("user_1", logHandler); //поток чата 1
        ChatWindow chat2 = new ChatWindow("user_2", logHandler); //потом чата 2
        ChatWindow chat3 = new ChatWindow("user_3", logHandler); //поток чата 3


        synchronized(logHandler){
            while (true){
                if (logHandler.dataChanged()){
                    chat1.initWindow();
                    chat2.initWindow();
                    chat3.initWindow();
                    logHandler.setDataChanged(false);
                }
            }
        }
    }
}