package hipo.prop.app.axel.com.eva3_7_asintask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main extends AppCompatActivity {
    TextView textView_secuencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView_secuencia = findViewById(R.id.txtVwNumeros);
        Async claseAsync = new Async();
        claseAsync.execute(50,100);
    }

    private class Async extends AsyncTask<Integer, String, Void>{

        @Override
        protected Void doInBackground(Integer... params) {
            int inicio = params[0];
            int ult = params[1];
            for(; inicio < ult; inicio++){
                try{
                    Thread.sleep(300);
                    publishProgress(inicio + " - ");
                } catch(Exception e){}
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            textView_secuencia.append(values[0]);
        }
    }
}
