import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author: wuhui
 * @time: 2019/10/28 22:29
 * @desc:
 */
public class ReceiveClientThread implements Runnable {
    Socket socket;
    public ReceiveClientThread(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        DataInputStream dataInputStream = null;
        try {
            dataInputStream = new DataInputStream( socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true){
            try {
                System.out.println(dataInputStream.readUTF());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
