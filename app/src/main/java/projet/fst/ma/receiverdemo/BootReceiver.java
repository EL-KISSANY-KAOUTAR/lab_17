package projet.fst.ma.receiverdemo;



import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BootReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context contextoo, Intent intenttt) {
        if (Intent.ACTION_BOOT_COMPLETED.equals(intenttt.getAction())) {
            Toast.makeText(contextoo, "Téléphone démarré - Receiver statique activé !", Toast.LENGTH_LONG).show();
        }
    }
}
