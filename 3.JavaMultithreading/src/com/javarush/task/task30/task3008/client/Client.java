package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;
import java.net.Socket;

import static com.javarush.task.task30.task3008.MessageType.NAME_ACCEPTED;
import static com.javarush.task.task30.task3008.MessageType.NAME_REQUEST;

public class Client {
    protected Connection connection;
    private volatile boolean clientConnected = false;

    protected String getServerAddress(){
        ConsoleHelper.writeMessage("Enter server address: ");
        return ConsoleHelper.readString();
    }

    protected int getServerPort(){
        ConsoleHelper.writeMessage("Enter server port: ");
        return ConsoleHelper.readInt();
    }

    protected String getUserName(){
        ConsoleHelper.writeMessage("Enter user name: ");
        return ConsoleHelper.readString();
    }

    protected boolean shouldSendTextFromConsole(){
        return true;
    }

    protected SocketThread getSocketThread(){
        return new SocketThread();
    }

    protected void sendTextMessage(String text){
        try {
            connection.send(new Message(MessageType.TEXT, text));
        }catch (IOException e){
            ConsoleHelper.writeMessage("Smth wrong...");
            clientConnected = false;
        }
    }

    public void run(){
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();
        synchronized (this){
            try {
                wait();
            }catch (InterruptedException e){
                ConsoleHelper.writeMessage("Error in client thread...");
                System.exit(1);
            }
            if (clientConnected) ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду ‘exit’."); else ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
            while (clientConnected){
                String msg = ConsoleHelper.readString();
                if (msg.equalsIgnoreCase("exit")) {
                    clientConnected = false;
                    break;
                }
                if (shouldSendTextFromConsole()) sendTextMessage(msg);
            }
        }
    }

    public static void main(String[] args){
        new Client().run();
    }

    public class SocketThread extends Thread{
        protected void processIncomingMessage(String message){
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName){
            ConsoleHelper.writeMessage("New user: " + userName + " is added to this chat.");
        }

        protected void informAboutDeletingNewUser(String userName){
            ConsoleHelper.writeMessage("The user: " + userName + " left this chat.");
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected){
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this){
                Client.this.notify();
            }
        }

        protected void clientHandshake() throws IOException, ClassNotFoundException{
            Message message;

            while (!clientConnected) {
                try {
                    message = connection.receive();
                } catch (ClassNotFoundException e) {
                    throw new IOException("Unexpected MessageType");
                }
                if (message.getType() == MessageType.NAME_REQUEST) {
                    connection.send(new Message(MessageType.USER_NAME, getUserName()));
                } else {
                    if (message.getType() == MessageType.NAME_ACCEPTED) {notifyConnectionStatusChanged(true);}
                    else throw new IOException("Unexpected MessageType");}

            }
        }

        protected void clientMainLoop() throws IOException, ClassNotFoundException{
            Message message;

            while (true) {

                try {
                    message = connection.receive();
                } catch (ClassNotFoundException e) {
                    break;
                }
                if (message.getType() == MessageType.TEXT) processIncomingMessage(message.getData());
                else {
                    if (message.getType() == MessageType.USER_ADDED) informAboutAddingNewUser(message.getData());
                    else {
                        if (message.getType() == MessageType.USER_REMOVED) informAboutDeletingNewUser(message.getData());
                        else break;
                    }
                }
            }
            throw new IOException("Unexpected MessageType");
        }

        @Override
        public void run() {
            try {
                Client.this.connection = new Connection(new Socket(getServerAddress(), getServerPort()));
                clientHandshake();
                clientMainLoop();
            }catch (Exception e){
                notifyConnectionStatusChanged(false);
            }
        }


    }
}
