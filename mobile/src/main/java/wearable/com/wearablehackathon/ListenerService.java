package wearable.com.wearablehackathon;

import android.media.MediaPlayer;
import android.widget.Toast;

import com.google.android.gms.wearable.MessageEvent;
import com.google.android.gms.wearable.WearableListenerService;

/**
 * Created by ackoneb on 12/6/14.
 */


public class ListenerService extends WearableListenerService {
    MediaPlayer mediaPlayer;

    @Override
    public void onMessageReceived(MessageEvent messageEvent) {
        mediaPlayer = MediaPlayer.create(this, R.raw.alarm);
        if (messageEvent.getPath().equals("/message_path")) {
            final String message = new String(messageEvent.getData());

            Toast.makeText(getApplicationContext(), message,
                    Toast.LENGTH_LONG).show();


            if (message.equals("1"))
                mediaPlayer.start();
            if (message.equals("2"))
                mediaPlayer.stop();


        } else {
            super.onMessageReceived(messageEvent);
        }
    }


}

