package ru.mirea.sysoeva.data_thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    TextView tvInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvInfo = findViewById(R.id.textView);
        final Runnable runn1 = new Runnable() {
            public void run() {
                tvInfo.setText("runn1");
            }
        };
        final Runnable runn2 = new Runnable() {
            public void run() {
                tvInfo.setText("runn2");
            }
        };
        final Runnable runn3 = new Runnable() {
            public void run() {
                tvInfo.setText("runn3");
            }
        };
        Thread t = new Thread(new Runnable() {
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(2);
                    runOnUiThread(runn1);
                    /* данный метод апускает определённое действие потока сразу же, если оно происходит в этом потоке, если нет, то добавляется в очередь */
                    TimeUnit.SECONDS.sleep(1);
                    tvInfo.postDelayed(runn3, 2000);
                    /* этот метод добавляет действие в очередь с указанной задержкой */
                    tvInfo.post(runn2);
                    /* cамый простой метод, который дпросто обавляет действие в очередь в данном потоке */
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
    }
}