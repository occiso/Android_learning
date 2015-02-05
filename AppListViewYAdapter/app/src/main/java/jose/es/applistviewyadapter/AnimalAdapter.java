package jose.es.applistviewyadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AnimalAdapter extends ArrayAdapter {

    private Context context;
    private List<Animal> datos;

    public AnimalAdapter(Context context, int resource, int textViewResourceId, List objects) {
        super(context, resource, textViewResourceId, objects);
        this.context = context;
        this.datos = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        super.getView(position, convertView, parent);

        AnimalesHolder holder;

        //controlamos que no genere una vista por cada elemento
        //hay que crearla únicamente la primera vez
        if (convertView == null){
            convertView  = LayoutInflater.from(context).inflate(R.layout.listview_animals, null);

            holder = new AnimalesHolder();
            holder.imgAnimal = (ImageView) convertView.findViewById(R.id.imgAnimal);
            holder.tvContent = (TextView) convertView.findViewById(R.id.tvContent);
            holder.tvField = (TextView) convertView.findViewById(R.id.tvField);

            //guardamos la referencia de los controles en la vista
            convertView.setTag(holder);
        }
        //recuperamos los controles de la vista.
        holder = (AnimalesHolder) convertView.getTag();

        holder.imgAnimal.setImageResource(datos.get(position).getDrawableImageID());
        holder.tvContent.setText(datos.get(position).getNombre());
        holder.tvField.setText(String.valueOf(position));

        return convertView;
    }
}