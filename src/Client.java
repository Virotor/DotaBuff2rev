import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    private static final int port = 4444;
    private static final String addres = "bestdotabaffever.sytes.net";
    private static Socket socket;
    private static DataOutputStream os;
    private static DataInputStream is;
    private static BufferedReader r;

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


    public static PlayerStatistics playerStatisticsAndMatches(String id) {
        PlayerStatistics playerStatistics = new PlayerStatistics();
        try {
            InetAddress ip = InetAddress.getByName(addres);
            socket = new Socket("37.215.23.131",port);
            ObjectOutputStream serializer = new ObjectOutputStream(socket.getOutputStream());
            System.out.println("Подключено к серверу");
            System.out.println("IP : " + socket.getInetAddress());
            System.out.println("PORT : " + socket.getPort());
            is = new DataInputStream(socket.getInputStream());//поток ввода
            os = new DataOutputStream(socket.getOutputStream());//поток вывода
            r = new BufferedReader(new InputStreamReader(System.in));
            os.writeUTF("1");
            os.flush();
            os.writeUTF(id);
            os.flush();
            ObjectInputStream deserializer = new ObjectInputStream(socket.getInputStream());
            playerStatistics = (PlayerStatistics) deserializer.readObject();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                os.close();
                socket.close();
            } catch (Exception e) {
                System.out.println("MSG : " + e.getMessage());
            }
        }
        return playerStatistics;
    }

    public static void playerMatchStatistics(PlayerMatchStatistics[] playerMatchStatistics,DataForGraphs dataForGraphs,String id) throws IOException {
        InetAddress ip = InetAddress.getByName(addres);
        socket = new Socket(ip,port);
        ObjectOutputStream serializer = new ObjectOutputStream(socket.getOutputStream());
        System.out.println("Подключено к серверу");
        System.out.println("IP : " + socket.getInetAddress());
        System.out.println("PORT : " + socket.getPort());
        is = new DataInputStream(socket.getInputStream());//поток ввода
        os = new DataOutputStream(socket.getOutputStream());//поток вывода
        r = new BufferedReader(new InputStreamReader(System.in));
        os.writeUTF("2");
        os.flush();
        os.writeUTF(id);
        os.flush();
        playerMatchStatistics = new PlayerMatchStatistics[10];
        try {
            Client.connect("2", id);
            ObjectInputStream deserializer = new ObjectInputStream(socket.getInputStream());
            playerMatchStatistics = (PlayerMatchStatistics[]) deserializer.readObject();
            dataForGraphs =(DataForGraphs) deserializer.readObject();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                os.close();
                socket.close();
            } catch (Exception e) {
                System.out.println("MSG : " + e.getMessage());
            }
        }
    }
}