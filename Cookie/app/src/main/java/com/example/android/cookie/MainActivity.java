package com.example.android.cookie;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void eatCookie(View v){
        TextView t = (TextView) findViewById(R.id.status_text_view);
        t.setText("I'm full!");

        ImageView i = (ImageView) findViewById(R.id.android_cookie_image_view);
        i.setImageResource(R.drawable.after_cookie);
    }
}
