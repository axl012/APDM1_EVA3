package hipo.prop.app.axel.com.eva3_2_uops_hilos;

import android.os.Bundle;
import android.util.Log;

/**
 * Created by axel012 on 10/31/2017.
 */

public class MiConteo extends Thread {

    @Override
    public void run() {
        super.run();
        for(int i = 0; i < 1000; i++){
            try{
                Log.e("thread", "Hola con Thread");
                Thread.sleep(200);
            } catch(Exception e){}
        }
    }
}


