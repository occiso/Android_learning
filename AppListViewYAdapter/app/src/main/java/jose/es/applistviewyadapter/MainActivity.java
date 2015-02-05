package jose.es.applistviewyadapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {
    private List<Animal> animales;
    private AnimalAdapter adapter;
    private ListView lsAnimales;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.onclickEvents();

    }

    private void onclickEvents(){
        findViewById(R.id.buttonList).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listarAnimales();
            }
        });

        findViewById(R.id.buttonGrid).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent act = new Intent(this, MainActivityGrid.class);
                Intent act = new Intent(MainActivity.this, MainActivityGrid.class);
                startActivity(act);
            }
        });

    }


    private void listarAnimales(){
        animales = new ArrayList<Animal>();
        this.rellenarArrayList();
        adapter = new AnimalAdapter(this, R.layout.listview_animals ,R.id.tvContent, animales);
//        adapter = new AnimalAdapter(this, R.layout.listview_animals ,animales); // peta.

        lsAnimales = (ListView)findViewById(R.id.lvItems);
        lsAnimales.setAdapter(adapter);

        lsAnimales.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) findViewById(R.id.tvItemField)).setText(animales.get(position).getNombre());
                ((TextView) findViewById(R.id.tvItemContent)).setText(String.valueOf(position));
            }
        });
    }



    private void rellenarArrayList() {
        animales.add(new Animal("aguila", R.drawable.aguila));
        animales.add(new Animal("ballena", R.drawable.ballena));
        animales.add(new Animal("caballo", R.drawable.caballo));
        animales.add(new Animal("camaleon", R.drawable.camaleon));
        animales.add(new Animal("canario", R.drawable.canario));
        animales.add(new Animal("cerdo", R.drawable.cerdo));
        animales.add(new Animal("delfin", R.drawable.delfin));
        animales.add(new Animal("gato", R.drawable.gato));
        animales.add(new Animal("iguana", R.drawable.iguana));
        animales.add(new Animal("lince", R.drawable.lince));
        animales.add(new Animal("lobo", R.drawable.lobo_9));
        animales.add(new Animal("morena", R.drawable.morena));
        animales.add(new Animal("orca", R.drawable.orca));
        animales.add(new Animal("perro", R.drawable.perro));
        animales.add(new Animal("vaca", R.drawable.vaca));
    }
}
