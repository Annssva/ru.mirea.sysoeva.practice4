package ru.mirea.sysoeva.workmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WorkRequest uploadWorkRequest =
                new OneTimeWorkRequest.Builder(UploadWorker.class)
                        .build();
        WorkManager
                .getInstance(this)
                .enqueue(uploadWorkRequest);
    }
    public void onClickPlayMusic(View view) {
        startService(
                new Intent(MainActivity.this, PlayerService.class));
    }
    public void onClickStopMusic(View view) {
        stopService(
                new Intent(MainActivity.this, PlayerService.class));
    }
}