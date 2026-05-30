package projet.fst.ma.receiverdemo;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private AirplaneModeReceiver air__planeReceiverr;
    private boolean is__ReceiverRegisteredd = false;
    private Button btnToggle__Airplanee, btn_SendCustomm;
    private TextView tvv__Statuss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        air__planeReceiverr = new AirplaneModeReceiver();
        tvv__Statuss = findViewById(R.id.tv__Statussss);
        btnToggle__Airplanee = findViewById(R.id.btn_Toggle_Airplaneee);
        btn_SendCustomm = findViewById(R.id.boutton_Send_Custom);

        btnToggle__Airplanee.setOnClickListener(v -> toggleAirplaneReceiver());
        btn_SendCustomm.setOnClickListener(v -> sendCustomBroadcast());
    }

    private void toggleAirplaneReceiver() {
        if (!is__ReceiverRegisteredd) {
            IntentFilter filter = new IntentFilter();
            filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);

            // RECEIVER_EXPORTED obligatoire pour les broadcasts système
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                registerReceiver(air__planeReceiverr, filter, Context.RECEIVER_EXPORTED);
            } else {
                registerReceiver(air__planeReceiverr, filter);
            }

            is__ReceiverRegisteredd = true;
            tvv__Statuss.setText("Receiver Mode Avion : Activeeee");
            btnToggle__Airplanee.setText("Desactiver Receiver Avion");
            Toast.makeText(this, "Receiver enregistre !", Toast.LENGTH_SHORT).show();
        } else {
            unregisterReceiver(air__planeReceiverr);
            is__ReceiverRegisteredd = false;
            tvv__Statuss.setText("Receiver Mode Avion : Desactiveee");
            btnToggle__Airplanee.setText("Activer Receiver Avion");
        }
    }

    private void sendCustomBroadcast() {
        Intent intent = new Intent("projet.fst.ma.receiverdemo.CUSTOM_EVENT");
        intent.putExtra("message", "Bonsoir depuis le custom broadcast !");
        intent.setPackage(getPackageName());
        sendBroadcast(intent);
        Toast.makeText(this, "Custom Broadcast envoyeee !", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        if (is__ReceiverRegisteredd) {
            unregisterReceiver(air__planeReceiverr);
        }
        super.onDestroy();
    }
}