package cl.ubb.proyectofastfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import cl.ubb.proyectofastfood.SDetalles;

public class Sandwiches extends AppCompatActivity {

    private ListView s_lista;
    private Adaptador adaptador;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sandwiches);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        context = this;

        ArrayList<sandwiches> lista = new ArrayList<sandwiches>();

        lista.add(chemilico);
        lista.add(barrosluco);
        lista.add(chacarero);
        lista.add(churrascoitaliano);
        lista.add(churrascomarino);

        adaptador = new Adaptador(this, lista);

        s_lista = (ListView) findViewById(R.id.s_lista);
        s_lista.setAdapter(adaptador);

        s_lista.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){

                sandwiches _sandwiches = (sandwiches) adaptador.getItem(position);
                SDetalles sDetalles = new SDetalles();
                sDetalles.setNombre(_sandwiches.getNombre());
                sDetalles.setDescripcion(_sandwiches.getDescripcion());
                sDetalles.setPrecio(_sandwiches.getPrecio());
                sDetalles.setImagen(_sandwiches.getImagen());

                startActivity(DescripcionSandwiches.getCallingIntent(context, sDetalles));


            }
        });

    }

    public class sandwiches{
        private String nombre;
        private int imagen;
        private String descripcion;
        private String precio;

        public sandwiches(){

        }

        public sandwiches (String nombre,int imagen, String descripcion, String precio) {
            this.nombre = nombre;
            this.imagen = imagen;
            this.descripcion = descripcion;
            this.precio = precio;
        }
        public String getNombre() {
            return nombre;
        }
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
        public int getImagen() {
            return imagen;
        }
        public void setImagen(int imagen) {
            this.imagen = imagen;
        }
        public String getDescripcion() {
            return descripcion;
        }
        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }
        public String getPrecio() {
            return precio;
        }
        public void setPrecio(String precio) {
            this.precio = precio;
        }
        @Override
        public String toString() {
            return nombre;
        }

    }
    sandwiches churrascoitaliano = new sandwiches("CHURRASCO ITALIANO",R.drawable.churrascoitaliano,"CONTIENE 400 GRAMOS DE BISTEC DE POSTA ROSADA, 2 PALTAS MADURAS, TOMATE Y MAYONESA QUE REPOSAN SOBRE DOS PANES FRICA.","$3300");
    sandwiches chacarero = new sandwiches("CHACARERO",R.drawable.chacarero,"CONTIENE 400 GRAMOS DE CHURRASCO EN LAMINAS, TOMATE, POROTOS VERDES Y AJÍ VERDE A ELECCIÓN, TODO ESTO EN DOS PANES FRICA.","$4000");
    sandwiches barrosluco = new sandwiches("BARROS LUCO",R.drawable.barrosluco,"CONTIENE 4 CHURRASCOS Y 4 REBANADAS DE QUESO CHANCO, CONTENIDOS DENTRO DE UNA MARRAQUETA.","$2500");
    sandwiches churrascomarino = new sandwiches("CHURRASCO MARINO",R.drawable.churrascomarino,"CONTIENE 400 GRAMOS DE MERLUZA FRITA , FINAS RODAJAS DE TOMATE, CEBOLLA EN PLUMA, HOJAS DE LECHUGA Y AJI VERDE PICADO, TODO ESTO EN PAN TIPO MARRAQUETA.","$3800");
    sandwiches chemilico = new sandwiches("CHEMILICO",R.drawable.chemilico,"CONTIENE MEDIA CEBOLLA EN PLUMA FRITA, UN HUEVO FRITO Y UN BISTEC, ESTO DENTRO DE DOS PANES FRICA.","$3000");
}