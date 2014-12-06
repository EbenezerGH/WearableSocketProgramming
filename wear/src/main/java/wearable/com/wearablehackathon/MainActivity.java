package wearable.com.wearablehackathon;

import android.app.Activity;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

    private TextView mTextView;
    private static String TAG = "switching";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {

            @Override
            public void onLayoutInflated(WatchViewStub stub) {
                mTextView = (TextView) stub.findViewById(R.id.text);
            }
        });//End of setOnLayoutInflatedListener




    }//End of onCreate


    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.switch1:
                Log.d(TAG, "switch 1 was pressed");
                break;
            case R.id.switch2:
                Log.d(TAG, "switch 2 was pressed");
                break;
            case R.id.switch3:
                Log.d(TAG, "switch 3 was pressed");
                break;

        }

    }
}


