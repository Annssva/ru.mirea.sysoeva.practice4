package ru.mirea.sysoeva.looper;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class MyLooper extends Thread{
    Handler handler;
    public int timeSleep = 19;

    @SuppressLint("HandlerLeak")
    @Override
    public void run() {
        Log.d("MyLooper", "run");
        Looper.prepare();
        handler = new Handler(){
            @Override
            public void handleMessage(Message msg){
                int age = msg.getData().getInt("AGE");
                try {
                    TimeUnit.SECONDS.sleep(age);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.d("MyLooper", "my age" + ": " + age);
                Log.d("MyLooper", "my work" + ": "+ msg.getData().getString("WORK"));
            }
        };
        Looper.loop();
    }
}
