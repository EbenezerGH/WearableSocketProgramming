package wearable.com.wearablehackathon;

import android.widget.Toast;

import com.google.android.gms.wearable.MessageEvent;
import com.google.android.gms.wearable.WearableListenerService;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by ackoneb on 12/6/14.
 */


public class ListenerService extends WearableListenerService {
    private Socket socket;
    private PrintWriter out;

    private static final int SERVERPORT = 2000;
    private static final String SERVER_IP = "1.2.3.4";

    @Override
    public void onMessageReceived(MessageEvent messageEvent) {

        GlobalMessage globalMessage = null;
        if (messageEvent.getPath().equals("/message_path")) {
            final String message = new String(messageEvent.getData());

            globalMessage.setMyMessage(message);
            Toast.makeText(getApplicationContext(), message,
                    Toast.LENGTH_LONG).show();

            new Thread(new ClientThread()).start();

            try {
                out = new PrintWriter(new BufferedWriter(
                        new OutputStreamWriter(socket.getOutputStream())),
                        true

                );

                out.println(message);
            } catch (IOException e) {
                e.printStackTrace();
            }


        } else {
            super.onMessageReceived(messageEvent);
        }
    }
    class ClientThread implements Runnable {

        @Override
        public void run() {

            try {
                InetAddress serverAddr = InetAddress.getByName(SERVER_IP);
                socket = new Socket(serverAddr, SERVERPORT);

            } catch (UnknownHostException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        }

    }

}