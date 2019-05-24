import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    private static final int port = 7777;
    private static final String addres = "192.168.43.227";
    private static Socket socket;
    private static DataOutputStream os;
    private static DataInputStream is;
    private static BufferedReader r;

    private static PlayerMatchStatistics[] playerMatchStatistics;
    private static DataForGraphs dataForGraphs;
    static private Boolean isReady;
    private static PlayerStatistics playerStatistics;

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


    public static PlayerStatistics playerStatisticsAndMatches(String id) throws IOException {
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
        Client.isReady = true;
        return playerStatistics;
    }

    public static void playerMatchStatistics(String id) throws IOException {
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

    public static void searchResponseByName(String id) throws IOException {
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


    public static PlayerMatchStatistics[] getPlayerMatchStatistics() {
        return playerMatchStatistics;
    }

    public static DataForGraphs getDataForGraphs() {
        return dataForGraphs;
    }

    public static Boolean getIsReady() {
        return isReady;
    }

    public static void setIsReady(Boolean isReady) {
        Client.isReady = isReady;
    }

    public static PlayerStatistics getPlayerStatistics() {
        return playerStatistics;
    }

    public static SearchResponseByName[] getSearchResponseByName() {
        return searchResponseByName;
    }
}