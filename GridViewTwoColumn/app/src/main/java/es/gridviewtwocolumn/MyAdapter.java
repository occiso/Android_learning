package es.gridviewtwocolumn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends BaseAdapter {
    private List<Item> items = new ArrayList<>();
    private LayoutInflater inflater;

    public MyAdapter(Context context) {
        inflater = LayoutInflater.from(context);

        items.add(new Item("bread", R.drawable.bread));
        items.add(new Item("carne", R.drawable.carne));
        items.add(new Item("Hamburguesa con salsa a la mayonesa rica de la buena", R.drawable.hamburguer));
        items.add(new Item("Judías", R.drawable.judes));
        items.add(new Item("pasta", R.drawable.pasta));
        items.add(new Item("Ensalada", R.drawable.salad));
        items.add(new Item("Salmorejo", R.drawable.salmorejo));
        items.add(new Item("Spagueti", R.drawable.spaguetti));
        items.add(new Item("tofu", R.drawable.tofu));
        items.add(new Item("postre", R.drawable.postre));
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return items.get(i).drawableId;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;
        ImageView picture;
        TextView name;

        if (v == null) {
            v = inflater.inflate(R.layout.square, viewGroup, false);
            v.setTag(R.id.picture, v.findViewById(R.id.picture));
            v.setTag(R.id.text, v.findViewById(R.id.text));
        }

        picture = (ImageView) v.getTag(R.id.picture);
        name = (TextView) v.getTag(R.id.text);

        Item item = (Item) getItem(i);

        picture.setImageResource(item.drawableId);
        name.setText(item.name);

        return v;
    }

    private class Item {
        final String name;
        final int drawableId;

        Item(String name, int drawableId) {
            this.name = name;
            this.drawableId = drawableId;
        }
    }
}