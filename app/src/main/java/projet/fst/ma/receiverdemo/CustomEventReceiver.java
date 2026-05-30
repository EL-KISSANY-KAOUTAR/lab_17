package projet.fst.ma.receiverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class CustomEventReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context contextoo, Intent intenttt) {
        if ("projet.fst.ma.receiverdemo.CUSTOM_EVENT".equals(intenttt.getAction())) {
            String messagee = intenttt.getStringExtra("message");
            Toast.makeText(contextoo, "Custom reçu : " + messagee, Toast.LENGTH_LONG).show();
        }
    }
}