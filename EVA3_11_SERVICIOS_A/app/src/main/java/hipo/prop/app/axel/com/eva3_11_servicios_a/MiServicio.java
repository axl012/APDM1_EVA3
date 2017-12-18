package hipo.prop.app.axel.com.eva3_11_servicios_a;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;

public class MiServicio extends Service {
    Intent inDatos;
    boolean flag = false;
    public MiServicio() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        inDatos = new Intent("UN_SERVICIO");
        inDatos.putExtra("MI_MENSAJE", "MISERVICIO - CREADO");
        sendBroadcast(inDatos);
    }

    @Override
    public void onStart(final Intent intent, int startId) {
        super.onStart(intent, startId);
        Thread miHilo = new Thread(){
            @Override
            public void run() {
                super.run();
                while(true){
                    try {
                        inDatos = new Intent("UN_SERVICIO");
                        inDatos.putExtra("MI_MENSAJE", "MI SERVICIO - CORRIENDO");
                        sendBroadcast(intent);
                        Thread.sleep(1000);
                        if (flag)
                            break;
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                    if (flag)
                        break;
                }
            }
        };
        miHilo.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
