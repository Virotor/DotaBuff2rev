package model;

import statistics.DataForGraphs;
import statistics.PlayerMatchStatistics;
import statistics.PlayerStatistics;
import statistics.SearchResponseByName;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
   static private  final int port = 7777;
  static   private  final String addres = "100.91.99.251";
    private  Socket socket;
    private  DataOutputStream os;
    private  DataInputStream is;
    private  BufferedReader r;

    private  PlayerMatchStatistics[] playerMatchStatistics;
    private DataForGraphs dataForGraphs;
    private PlayerStatistics playerStatistics;

    static private SearchResponseByName[] searchResponseByName= null;

    static private void connect(String parametr, String text) throws IOException {
    /*    InetAddress ip = InetAddress.getByName(addres);
        socket = new Socket(ip,port);
        ObjectOutputStream serializer = new ObjectOutputStream(socket.getOutputStream());
        System.out.println("Подключено к серверу");
        System.out.println("IP : " + socket.getInetAddress());
        System.out.println("PORT : " + socket.getPort());
        is = new DataInputStream(socket.getInputStream());//поток ввода
        os = new DataOutputStream(socket.getOutputStream());//поток вывода
        r = new BufferedReader(new InputStreamReader(System.in));
        os.writeUTF(parametr);
        os.flush();
        os.writeUTF(text);
        os.flush();*/
    }


    public PlayerStatistics playerStatisticsAndMatches(String id) throws IOException {
        try {
            InetAddress ip = InetAddress.getByName(addres);
            socket = new Socket(ip, port);
            ObjectOutputStream serializer = new ObjectOutputStream(socket.getOutputStream());
            System.out.println("Подключено к серверу");
            System.out.println("IP : " + socket.getInetAddress());
            System.out.println("PORT : " + socket.getPort());
            is = new DataInputStream(socket.getInputStream());//поток ввода
            os = new DataOutputStream(socket.getOutputStream());//поток вывода
            r = new BufferedReader(new InputStreamReader(System.in));
            Object msg = "1";
            serializer.writeObject(msg);
            serializer.writeObject(id);
            ObjectInputStream deserializer = new ObjectInputStream(socket.getInputStream());
            playerStatistics = (PlayerStatistics) deserializer.readObject();
            os.close();
            socket.close();
        }
        catch (IOException | ClassNotFoundException e ){
            throw new IOException("Не удалось установить интернет соединение");

        }
        return playerStatistics;
    }

    public  void playerMatchStatistics(String id) throws IOException {
        InetAddress ip = InetAddress.getByName(addres);
        try {
            socket = new Socket(ip, port);
            ObjectOutputStream serializer = new ObjectOutputStream(socket.getOutputStream());
            System.out.println("Подключено к серверу");
            System.out.println("IP : " + socket.getInetAddress());
            System.out.println("PORT : " + socket.getPort());
            is = new DataInputStream(socket.getInputStream());//поток ввода
            os = new DataOutputStream(socket.getOutputStream());//поток вывода
            r = new BufferedReader(new InputStreamReader(System.in));
            Object msg = "2";
            serializer.writeObject(msg);
            serializer.writeObject(id);
            playerMatchStatistics = new PlayerMatchStatistics[10];
            dataForGraphs = new DataForGraphs();
            Client.connect("2", id);
            ObjectInputStream deserializer = new ObjectInputStream(socket.getInputStream());
            dataForGraphs = (DataForGraphs) deserializer.readObject();
            playerMatchStatistics = (PlayerMatchStatistics[]) deserializer.readObject();
            os.close();
            socket.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new IOException("Не удалось установить интернет соединение");
        }

    }

    public  void searchResponseByName(String id) throws IOException {
        InetAddress ip = InetAddress.getByName(addres);
        searchResponseByName = null;
        try {
            socket = new Socket(ip, port);
            ObjectOutputStream serializer = new ObjectOutputStream(socket.getOutputStream());
            System.out.println("Подключено к серверу");
            System.out.println("IP : " + socket.getInetAddress());
            System.out.println("PORT : " + socket.getPort());
            is = new DataInputStream(socket.getInputStream());//поток ввода
            os = new DataOutputStream(socket.getOutputStream());//поток вывода
            r = new BufferedReader(new InputStreamReader(System.in));
            Object msg = "3";
            serializer.writeObject(msg);
            serializer.writeObject(id);
            ObjectInputStream deserializer = new ObjectInputStream(socket.getInputStream());
            searchResponseByName = (SearchResponseByName[]) deserializer.readObject();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                os.close();
                socket.close();
            } catch (Exception e) {
                throw new IOException("Не удалось подключиться к серверу");
            }
        }
    }


    public  PlayerMatchStatistics[] getPlayerMatchStatistics() {
        return playerMatchStatistics;
    }

    public  DataForGraphs getDataForGraphs() {
        return dataForGraphs;
    }


    public  PlayerStatistics getPlayerStatistics() {
        return playerStatistics;
    }

    public  SearchResponseByName[] getSearchResponseByName() {
        return searchResponseByName;
    }
}