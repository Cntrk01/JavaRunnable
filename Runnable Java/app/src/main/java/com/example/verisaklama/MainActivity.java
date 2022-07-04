package com.example.verisaklama;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    int number;
    Runnable runnable;
    Handler handler;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView);
        number=0;
        button=findViewById(R.id.start);

    }
    public void start(View view){
        int i=0;
        while (i<100){
            textView.setText("Time : "+i);
            i++;
            textView.setText("Time : "+i);
            try {
                Thread.sleep(1000); //böyle yapınca donacak uygulama.Çünkü kullanıcı arayüzüne
                //müdahele ediyoruz.Bunu arka bir threadde yapacaksın ki kullancı da görmeyecek hemde donma olmayaca
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    public void stop(View view){
        button.setEnabled(true);
        handler.removeCallbacks(runnable);
        textView.setText("Time : "+number);
        Toast.makeText(this,"Sayaç Durduruldu",Toast.LENGTH_LONG).show();

    }
    public void reset(View view){
        button.setEnabled(true);
        handler.removeCallbacks(runnable);
        number=0;
        Toast.makeText(this,"Sayaç Sıfırlandı",Toast.LENGTH_LONG).show();
        textView.setText("Time : "+number);
    }
}