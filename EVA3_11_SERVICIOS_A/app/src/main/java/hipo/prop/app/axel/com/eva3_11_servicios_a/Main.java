package hipo.prop.app.axel.com.eva3_11_servicios_a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main extends AppCompatActivity {

    Intent inServicio;
    TextView txtVwMostrar;
    BroadcastReceiver bcrMiBroadcast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtVwMostrar = findViewById(R.id.txtVwMostrar);
        inServicio = new Intent(this,MiServicio.class);
        startService(inServicio);
        IntentFilter infFiltro = new IntentFilter("UN_SERVICIO");
        bcrMiBroadcast =  new MiBroadcastReciever();
        registerReceiver(bcrMiBroadcast, infFiltro);
    }

    public void onClick(View v){
        try{
            stopService(inServicio);
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public class MiBroadcastReciever extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            String sCade = intent.getStringExtra("MI_MENSAJE");
            txtVwMostrar.append(sCade + "\n");
        }
    }
}
