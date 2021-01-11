package com.danielcirilo.ejerciciopreferences;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.preference.CheckBoxPreference;

import android.os.Bundle;


public class PreferencesActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private CheckBoxPreference checkBoxPreference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);

        getSupportFragmentManager().beginTransaction()
                .replace(android.R.id.content, new PreferenceFragment());
        toolbar = findViewById(R.id.appbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Override

    public boolean onSupportNavigateUp() {

        onBackPressed();

        return false;

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}