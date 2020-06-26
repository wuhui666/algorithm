import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author: wuhui
 * @time: 2019/10/28 22:12
 * @desc:
 */
public class SendClientThead implements Runnable{
    Socket socket;

    public SendClientThead(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        DataOutputStream dataOutputStream = null;
        try {
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scanner scanner=new Scanner(System.in);
        while (true){
            try {
                dataOutputStream.writeUTF(scanner.nextLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
