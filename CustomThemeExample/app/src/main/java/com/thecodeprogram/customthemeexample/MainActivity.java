package com.thecodeprogram.customthemeexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnApplyDarkTheme, btnApplyLightTheme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //it is important to make this operation before super function
        if( getIntent().getIntExtra("set_theme", 0) != 0){
            setTheme(getIntent().getIntExtra("set_theme", 0));
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnApplyDarkTheme = findViewById(R.id.btnApplyDarkTheme);
        btnApplyLightTheme = findViewById(R.id.btnApplyLightTheme);

        btnApplyDarkTheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeTheme(R.style.Theme_THE_DARK_THEME);
            }
        });

        btnApplyLightTheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeTheme(R.style.Theme_THE_LIGHT_THEME);
            }
        });

    }

    private void changeTheme(int theme)
    {
        this.finish();
        Intent intent = new Intent(this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("set_theme", theme);
        startActivity(intent);
    }
}
