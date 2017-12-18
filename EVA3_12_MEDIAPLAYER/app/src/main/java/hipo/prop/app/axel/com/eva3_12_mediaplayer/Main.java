package hipo.prop.app.axel.com.eva3_12_mediaplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main extends AppCompatActivity {
    MediaPlayer mpReproductor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mpReproductor = MediaPlayer.create(getApplicationContext(), R.raw.cancion);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(mpReproductor != null){
            mpReproductor.start();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mpReproductor != null){
            mpReproductor.stop();
            mpReproductor.release();
        }
    }
}
