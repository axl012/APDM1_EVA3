package hipo.prop.app.axel.com.eva3_3_uops_again;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Main extends AppCompatActivity {
    TextView txtVwTexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtVwTexto = findViewById(R.id.txtViwTexto);
        Runnable datos = new Runnable(){
            @Override
            public void run(){
                int i = 0;
                try {
                    while(true){
                        txtVwTexto.append(i + " - ");
                        Thread.sleep(1000);
                        i++;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Toast.makeText(Main.this, "No se puede modificar un view del hilo principal", Toast.LENGTH_SHORT).show();
                }
            }
        };
        new Thread(datos).start();
    }
}
