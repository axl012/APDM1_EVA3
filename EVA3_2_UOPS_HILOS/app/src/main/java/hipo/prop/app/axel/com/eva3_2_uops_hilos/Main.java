package hipo.prop.app.axel.com.eva3_2_uops_hilos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main extends AppCompatActivity implements Runnable{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MiConteo hilo = new MiConteo();
        //hilo.run(); //manda a llamar la clase run
        hilo.start(); //ejecuta el run usando hilo de ejecución

        MiConteo2 hilo2 = new MiConteo2();
        Thread thread = new Thread(hilo2);
        thread.start();
    }

    @Override
    public void run() {

    }
}
