package hipo.prop.app.axel.com.eva3_13_mediaplayer_servicio;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MisRolas extends Service {
    MediaPlayer mpReproductor;

    @Override
    public void onCreate() {
        super.onCreate();
        mpReproductor = MediaPlayer.create(getApplicationContext(), R.raw.cancion);

    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        if(mpReproductor != null){
            mpReproductor.start();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mpReproductor != null){
            mpReproductor.stop();
            mpReproductor.release();
        }
    }

    public MisRolas() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
