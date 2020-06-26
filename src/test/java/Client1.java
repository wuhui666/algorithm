import java.io.IOException;
import java.net.Socket;

/**
 * @author: wuhui
 * @time: 2019/10/28 22:39
 * @desc:
 */
public class Client1 {
    public static void main(String[] args) throws IOException {
        Socket socket=new Socket("127.0.0.1",8888);

        Thread receiveThread=new Thread(new ReceiveClientThread(socket));
        Thread sendThread=new Thread(new SendClientThead(socket));

        receiveThread.start();
        sendThread.start();
    }
}
