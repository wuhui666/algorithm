import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: wuhui
 * @time: 2019/10/28 22:12
 * @desc:
 */
public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(8888);
        while (true){
            Socket socket=serverSocket.accept();
            ReceiveServerThread.socketList.add(socket);
            Thread receiveThread=new Thread(new ReceiveServerThread(socket));
            //Thread sendThread=new Thread(new SendClientThead(socket));
            receiveThread.start();
            //sendThread.start();
        }


    }
}
