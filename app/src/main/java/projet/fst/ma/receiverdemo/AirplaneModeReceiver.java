package projet.fst.ma.receiverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class AirplaneModeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context contextoo, Intent intenttt) {

        // LOG pour voir si onReceive est appeléeeee
        Log.d("AIRPLANE", "onReceive appelé ! action = " + intenttt.getAction());

        if (Intent.ACTION_AIRPLANE_MODE_CHANGED.equals(intenttt.getAction())) {
            boolean isAirplaneOn = intenttt.getBooleanExtra("state", false);
            Log.d("AIRPLANE", "isAirplaneOn = " + isAirplaneOn);

            String messagee = isAirplaneOn
                    ? "Mode Avion ACTIVEEE"
                    : "Mode Avion DESACTIVEEE";

            Toast.makeText(contextoo, messagee, Toast.LENGTH_LONG).show();
        }
    }
}