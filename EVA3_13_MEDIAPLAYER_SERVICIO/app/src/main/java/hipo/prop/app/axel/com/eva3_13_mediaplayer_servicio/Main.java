package hipo.prop.app.axel.com.eva3_13_mediaplayer_servicio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main extends AppCompatActivity {
    Intent inRolas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inRolas = new Intent(this, MisRolas.class);
        startService(inRolas);
    }

    public void onClick(View v){
        try{
            stopService(inRolas);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
