package hipo.prop.app.axel.com.eva3_15_practica_camara;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Tiempo extends AppCompatActivity {
    Button boton1, boton2, boton3, boton4;
    Intent inSegundos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiempo);
        boton1 = findViewById(R.id.tiempo1);
        boton2 = findViewById(R.id.tiempo2);
        boton3 = findViewById(R.id.tiempo3);
        boton4 = findViewById(R.id.sintiempo);

        inSegundos = new Intent();
    }


    public void onClickboton(View v){
        if(v.getId() == R.id.tiempo1){
            setResult(3);
            finish();
        }else if(v.getId() == R.id.tiempo2){
            setResult(5);
            finish();
        }else if(v.getId() == R.id.tiempo3){
            setResult(10);
            finish();
        }else if(v.getId() == R.id.sintiempo){
            setResult(15);
            finish();
        }


    }
}
