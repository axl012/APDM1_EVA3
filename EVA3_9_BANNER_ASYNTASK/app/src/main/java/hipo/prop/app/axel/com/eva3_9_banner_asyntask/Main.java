package hipo.prop.app.axel.com.eva3_9_banner_asyntask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;

public class Main extends AppCompatActivity {
    int img = 0;
    ImageView image;
    SeekBar seekbar;
    boolean destruir = false;
    Async banner = new Async();
    int delay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image = findViewById(R.id.image);
        seekbar = findViewById(R.id.seekbar);
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                delay = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        delay = seekbar.getProgress();
        banner.execute();


    }

    private class Async extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            while(true){
                try{
                    Thread.sleep(1000 - delay*8);
                    publishProgress();
                    if(destruir) break;
                }catch(Exception e){}
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
            switch (img) {
                case 0:
                    img++;
                    image.setImageResource(R.drawable.f1);
                    break;
                case 1:
                    img++;
                    image.setImageResource(R.drawable.f2);
                    break;
                default:
                    img = 0;
                    image.setImageResource(R.drawable.f3);
                    break;
            }
        }

    }

    @Override
    protected void onStop() {
        super.onStop();
        destruir = true;
    }
}
