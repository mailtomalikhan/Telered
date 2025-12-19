package com.telered.tv;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

public class SplashScreen extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
          runUIThread();
    }

    private void runUIThread() {
        new Thread(() -> {
            try {
               Thread.sleep(5000); // delay for 5 seconds
               startActivity(new Intent(SplashScreen.this,MainActivity.class));
               finish();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

}