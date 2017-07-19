package com.jon_dhc.teletype;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Removing action bar and title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Removing Navigation Bar
        FullscreenCall();
        //Setting content
        setContentView(R.layout.activity_main);

        //Typewriter animation
        final TypeWriter tw = (TypeWriter) findViewById(R.id.tv);
        Button btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tw.setText("");
                tw.setCharacterDelay(150);
                tw.animateText("What would you like me to do?");
            }
        });
    }

    public void FullscreenCall(){       //Method to hide navigation bar (Immersive mode)
        View decorView = getWindow().getDecorView();
        int UiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decorView.setSystemUiVisibility(UiOptions);
    }
}
