package com.erlik.kronemetre;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
 private TextView  timer;
 private Button start,stop;
 int number;
 Runnable runnable;;
 Handler handler;


 private Switch switchD;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timer=(TextView) findViewById(R.id.Txt_times);
        start=(Button) findViewById(R.id.Btn_bas);
        stop=(Button) findViewById(R.id.Btn_dur);
        switchD=(Switch)findViewById(R.id.switch1);
         number=0;

    }
    public  void TimerStart(View view)
    {
        Toast.makeText(this,"Başladı",Toast.LENGTH_LONG).show();
        handler =new Handler();
        runnable=new Runnable() {
            @Override
            public void run() {
                timer.setText(" "+number);
                number++;
                timer.setText(" "+number);
                handler.postDelayed(runnable,1000);
            }
        };

        handler.post(runnable);
        start.setEnabled(false);


    }
    public  void TimerStop(View view)
    {
        Toast.makeText(this,"İptal edildi",Toast.LENGTH_LONG).show();
        start.setEnabled(true);
        handler.removeCallbacks(runnable);
        number=0;
        timer.setText(" "+number);

    }


}