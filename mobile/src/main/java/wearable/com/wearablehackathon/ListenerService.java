package wearable.com.wearablehackathon;

import android.widget.Toast;

import com.google.android.gms.wearable.MessageEvent;
import com.google.android.gms.wearable.WearableListenerService;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

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

        try {
            out = new PrintWriter(new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream())),
                    true
            );
        } catch (IOException e) {
            e.printStackTrace();
        }

        GlobalMessage globalMessage = null;
        if (messageEvent.getPath().equals("/message_path")) {
            final String message = new String(messageEvent.getData());

            globalMessage.setMyMessage(message);
            Toast.makeText(getApplicationContext(), message,
                    Toast.LENGTH_LONG).show();


        } else {
            super.onMessageReceived(messageEvent);
        }
    }

}