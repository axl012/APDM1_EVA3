package hipo.prop.app.axel.com.eva3_2_uops_hilos;

import android.os.Bundle;
import android.util.Log;

/**
 * Created by axel012 on 10/31/2017.
 */

public class MiConteo2 implements Runnable {
    @Override
    public void run() {
        for(int i = 0; i < 1000; i++){
            try{
                Log.e("Runnable", "Hola con runnable");
                Thread.sleep(200);
            } catch(Exception e){}
        }
    }
}
