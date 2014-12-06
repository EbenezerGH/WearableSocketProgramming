package wearable.com.wearablehackathon;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.TextView;

public class MessageReceiver extends BroadcastReceiver {
    private static final String TAG = "switching";

    private TextView mTextView;

    @Override
    public void onReceive(Context context, Intent intent) {
        String message = intent.getStringExtra("message");
        // Display message in UI
        mTextView.setText(message);
        Log.d(TAG, "A Message was received");
    }
}
