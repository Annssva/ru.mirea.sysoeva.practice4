package ru.mirea.sysoeva.test;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;

import androidx.annotation.NonNull;
import androidx.loader.content.AsyncTaskLoader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MyLoader extends AsyncTaskLoader<String> {
    private String editText;
    public String result;
    public static final String ARG_WORD = "word";

    public MyLoader(@NonNull Context context, Bundle args) {
        super(context);
        if (args != null)
            editText = args.getString(ARG_WORD);
    }
    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }
    @Override
    public String loadInBackground() {
        result = "";

        List<String> textShuffle = Arrays.asList(editText);
        Collections.shuffle(textShuffle);
        SystemClock.sleep(5000);
        result = textShuffle.toString();
        return result;
    }
}
