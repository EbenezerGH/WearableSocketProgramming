package wearable.com.wearablehackathon;

import android.widget.Toast;

import com.google.android.gms.wearable.MessageEvent;
import com.google.android.gms.wearable.WearableListenerService;

/**
 * Created by ackoneb on 12/6/14.
 */
public class ListenerService extends WearableListenerService {

    @Override
    public void onMessageReceived(MessageEvent messageEvent) {
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