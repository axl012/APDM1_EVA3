package hipo.prop.app.axel.com.eva3_10_servicios;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main extends AppCompatActivity {
    Button btnElboton;
    Intent inServicio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnElboton = findViewById(R.id.btndetener);
        inServicio = new Intent(this, MiServicio.class);
        startService(inServicio);
    }

    public void onClick(View v){
        try {
            stopService(inServicio);
        }catch(Exception e){
           e.printStackTrace();
        }
    }
}
