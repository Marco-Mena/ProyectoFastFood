package cl.ubb.proyectofastfood;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import cl.ubb.proyectofastfood.SDetalles;

public class DescripcionSandwiches extends AppCompatActivity {

    private TextView tvNombre, tvDescripcion, tvPrecio;
    private ImageView ivImagen;
    private SDetalles sDetalles;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcion);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        try {
            sDetalles = (SDetalles) getIntent().getExtras().getSerializable("model");
        } catch (Exception e) {
            finish();
        }

        tvNombre = (TextView) findViewById(R.id.tv_nombre);
        ivImagen = (ImageView) findViewById(R.id.iv_imagen);
        tvDescripcion = (TextView) findViewById(R.id.tv_descripcion);
        tvPrecio = (TextView) findViewById(R.id.tv_precio);

        tvNombre.setText(sDetalles.getNombre());
        tvDescripcion.setText(sDetalles.getDescripcion());
        tvPrecio.setText(sDetalles.getPrecio());
        ivImagen.setImageResource(sDetalles.getImagen());
    }

    public static Intent getCallingIntent(Context context, SDetalles sDetalles){
        Intent intent = new Intent(context, DescripcionSandwiches.class);
        intent.putExtra("model",sDetalles);
        return intent;
    }
}