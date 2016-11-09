package com.example.tyler.countersaver;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public int count;
    public TextView text;
    private SharedPreferences preferenceSettings;
    public SharedPreferences.Editor preferenceEditor;
    private static final int PREFERENCE_MODE_PRIVATE = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferenceSettings = getPreferences(PREFERENCE_MODE_PRIVATE);
        preferenceEditor = preferenceSettings.edit();

        count = preferenceSettings.getInt("count", 0);
        text = (TextView) findViewById(R.id.textView);
        text.setText(Integer.toString(count));
    }

    public void advance(View view){
        count++;
        text.setText(Integer.toString(count));
    }

    public void saveCount(View view){
        preferenceEditor.putInt("count", count);
        preferenceEditor.apply();
    }

}
