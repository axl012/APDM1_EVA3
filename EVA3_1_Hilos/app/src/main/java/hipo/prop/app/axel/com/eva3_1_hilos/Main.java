package hipo.prop.app.axel.com.eva3_1_hilos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Runnable rnHilo = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Log.e("Hilo", "Holooooo");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread thHilo = new Thread(rnHilo);
        thHilo.start();

        //Thread -->
        Thread thread2 = new Thread(){
            @Override
            public void run() {
                super.run();
                while(true){
                    Log.e("HILO2","IMPRIMIENDO");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        thread2.start();
    }
}
