import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * @author: wuhui
 * @time: 2019/10/29 10:29
 * @desc:
 */
public class ReceiveServerThread implements Runnable{
    // 静态储存连接的客户端
    public static List<Socket> socketList=new ArrayList<>();

    Socket socket;
    public ReceiveServerThread(Socket socket) {
        this.socket = socket;

    }

    @Override
    public void run() {
        DataInputStream dataInputStream = null;
        DataOutputStream dataOutputStream = null;
        String content =null;
        SimpleDateFormat smf=new SimpleDateFormat("HH:mm");
        while (true){
            try {
                dataInputStream = new DataInputStream( socket.getInputStream());
                content=dataInputStream.readUTF();

            } catch (IOException e) {
                e.printStackTrace();
            }
            String time=smf.format(new Date());

            String prefix="from "+socket.getRemoteSocketAddress()+" "+time+": ";
            System.out.println(prefix);
            System.out.println(content);
            for (int i = 0; i < socketList.size(); i++) {
                if (socketList.get(i).isClosed()){
                    continue;
                }
                try {
                    dataOutputStream=new DataOutputStream(socketList.get(i).getOutputStream());
                    dataOutputStream.writeUTF(prefix);
                    dataOutputStream.writeUTF(content);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
