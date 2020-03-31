package cl.ubb.proyectofastfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button sandwichButton;
    private Button sobrenosotrosButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sandwichButton = findViewById(R.id.sandwich);
        sobrenosotrosButton = findViewById(R.id.descripcion);

        Log.d("FastFood", "onCreate()");
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d("FastFood","onStart()");
    }


    @Override
    protected void onResume(){
        super.onResume();
        Log.d("FastFood","onResume()");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d("FastFood","onPause()");
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.d("FastFood","onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("FastFood","onDestroy()");
    }

    public void sandwich(View view){
        Intent sandwich = new Intent(this, Sandwiches.class);
        startActivity(sandwich);
    }

    public void descripcion(View view){
        Intent descripcion = new Intent(this, Sobre_nosotros.class);
        startActivity(descripcion);
    }
}