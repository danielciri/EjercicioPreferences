package com.danielcirilo.ejerciciopreferences;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.preference.PreferenceManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private Intent preferencesIntent;
    private TextView tvUser;
    private TextView tvContrasenya;
    private TextView tvServicio;
    private TextView tvCifrado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.appbar);
        tvUser = findViewById(R.id.tvUsuario);
        tvContrasenya = findViewById(R.id.tvPasswd);
        tvServicio = findViewById(R.id.tvService);
        tvCifrado = findViewById(R.id.tvCifrado);

        setSupportActionBar(toolbar);
        SharedPreferences preferences =
                getSharedPreferences("preferencias", Context.MODE_PRIVATE);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_preferencias : {
                preferencesIntent = new Intent(this, PreferencesActivity.class);
                startActivity(preferencesIntent);
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    private void putPereferences(){

    }

    private void displaySharedPreferences() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        String username = prefs.getString("user", "Default NickName");
        String passw = prefs.getString("password", "Default Password");
        boolean serviceSwitch = prefs.getBoolean("service", false);
        String service = (serviceSwitch) ? "Si" : "No";
        boolean encryptionCheck = prefs.getBoolean("encryption", false);
        String encryption = (encryptionCheck) ? "Si" : "No";
        String listPrefs = prefs.getString("values_encryption", "Default list prefs");
        StringBuilder sb = new StringBuilder();
        sb.append(encryption).append(" (").append(listPrefs).append(")");

        tvUser.setText(username);
        tvContrasenya.setText(passw);
        tvServicio.setText(service);
        tvCifrado.setText(sb.toString());
    }

    @Override
    protected void onResume() {
        super.onResume();
        displaySharedPreferences();
    }
}