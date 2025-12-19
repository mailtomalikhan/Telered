package com.telered.tv;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;

public class MainActivity extends FragmentActivity {

    CardView cardStream1, cardStream2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        cardStream1 = findViewById(R.id.cardStream1);
        cardStream2 = findViewById(R.id.cardStream2);

        setupFocusAnimation(cardStream1);
        setupFocusAnimation(cardStream2);

        cardStream1.requestFocus();
        cardStream1.setNextFocusUpId(R.id.cardStream2);
        cardStream1.setNextFocusDownId(R.id.cardStream2);
        cardStream1.setNextFocusLeftId(R.id.cardStream2);
        cardStream1.setNextFocusRightId(R.id.cardStream2);

        cardStream2.setNextFocusUpId(R.id.cardStream1);
        cardStream2.setNextFocusDownId(R.id.cardStream1);
        cardStream2.setNextFocusLeftId(R.id.cardStream1);
        cardStream2.setNextFocusRightId(R.id.cardStream1);


        cardStream1.setOnClickListener(v ->
                startActivity(new Intent(this, StreamActivity.class)
                        .putExtra("streamURL",
                                "https://rtv.fullhd-streaming.com:19360/telered/telered.m3u8"))
        );

        cardStream2.setOnClickListener(v ->
                startActivity(new Intent(this, StreamActivity.class)
                        .putExtra("streamURL",
                                "https://rtv.fullhd-streaming.com:19360/telesistemas/telesistemas.m3u8"))
        );
//        cardStream1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View view, boolean b) {
//                if(cardStream1.hasFocus()){
//                    cardStream1.setBackgroundResource(R.color.focus_background);
//                }else {
//                    cardStream1.setBackgroundResource(R.color.fastlane_background);
//                }
//            }
//        });
//        cardStream2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View view, boolean b) {
//                if(cardStream2.hasFocus()){
//                    cardStream2.setBackgroundResource(R.color.focus_background);
//                }else {
//                    cardStream2.setBackgroundResource(R.color.fastlane_background);
//                }
//            }
//        });
    }
    private void setupFocusAnimation(View view) {
        view.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                v.animate()
                        .scaleX(1.15f)
                        .scaleY(1.15f)
                        .setDuration(200)
                        .start();
                v.setElevation(20f); // optional shadow
            } else {
                v.animate()
                        .scaleX(1.0f)
                        .scaleY(1.0f)
                        .setDuration(200)
                        .start();
                v.setElevation(5f);
            }
        });
    }


}
