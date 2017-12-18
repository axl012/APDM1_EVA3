package hipo.prop.app.axel.com.eva3_8_asytaskpost;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView imgVwBanner;
    SeekBar barrita;
    int vel;
    //int seekBarValue= barrita.getProgress();
    Handler Manejador = new Handler();
    int cont;
    Runnable ForeGround = new Runnable() {
        @Override
        public void run() {
            if(cont ==1){imgVwBanner.setImageResource(R.drawable.f1); }
            if(cont ==2){imgVwBanner.setImageResource(R.drawable.f2); }
            if(cont ==3){imgVwBanner.setImageResource(R.drawable.f3); }
            cont++;
            if(cont>3){ cont =1;}

        }
    };

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgVwBanner =  findViewById(R.id.imgVwBanner);
        barrita = findViewById(R.id.barrita);
       // barrita.setMin(200);
       // barrita.setMax(1000);
        barrita.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                vel = barrita.getProgress();
                //Toast.makeText(MainActivity.this, "elocidad"+vel, Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        Runnable BackGround = new Runnable() {
            @Override
            public void run() {
                while (true){
                    Manejador.post(ForeGround);
                    try {
                        Thread.sleep(vel);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

            }
        };

        Thread Start = new Thread(BackGround);
        Start.start();

    }
}

