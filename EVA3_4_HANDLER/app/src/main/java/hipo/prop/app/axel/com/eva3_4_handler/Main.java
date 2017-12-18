package hipo.prop.app.axel.com.eva3_4_handler;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Main extends AppCompatActivity {
    boolean destruir = false;
    TextView textView_datos;
    Handler manejador = new Handler(){
        @Override
        public void handleMessage(Message msg){
            super.handleMessage(msg);
            String mensaje = (String)msg.obj;
            int hilo = msg.what;
            textView_datos.append(hilo + " - " + mensaje);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView_datos = (TextView)findViewById(R.id.txtvwTexto);
        Runnable datos = new Runnable(){
            @Override
            public void run(){
                int i = 0;
                while(true){
                    try{
                        //textView_datos.append(i + " - ");
                        String mens = i + " - ";
                        Message mensaje = manejador.obtainMessage(1, mens);
                        manejador.sendMessage(mensaje);
                        Thread.sleep(1000);
                        i++;
                        if(destruir)
                            break;
                    } catch(Exception e){}
                }
            }
        };

        Thread runDatos = new Thread(datos);
        runDatos.start();
    }

    @Override
    protected void onStop(){
        super.onStop();
        destruir = true;
    }
}
