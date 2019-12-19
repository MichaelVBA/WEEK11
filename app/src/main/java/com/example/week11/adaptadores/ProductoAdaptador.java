package com.example.week11.adaptadores;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.example.week11.R;
import com.example.week11.modelos.productos;

import java.util.List;

public class ProductoAdaptador extends ArrayAdapter<com.example.week11.modelos.productos> {
        Context context;
    ImageLoader queue;
private class ViewHolder {
    NetworkImageView image;
    TextView Precio;
    TextView Nombre;

    private ViewHolder() {
    }
}
    public ProductoAdaptador(Context context, List<productos> items, ImageLoader _queue) {
     super(context,0,items);
        this.context = context;
        this.queue = _queue;

    }
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        final productos rowItem = (productos) getItem(position);
        LayoutInflater mInflater = (LayoutInflater) this.context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.productos, null);
            holder = new ViewHolder();
            holder.image = (NetworkImageView)convertView.findViewById(R.id.image);
            holder.Precio = (TextView) convertView.findViewById(R.id.Precio);
            holder.Nombre = (TextView) convertView.findViewById(R.id.Nombre);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.Precio.setText(rowItem.Precio);
        holder.Nombre.setText(rowItem.Nombre);
        if ( rowItem.getSmallImage() != null ) { //<----- El modelo debe poseer esta function
            holder.image.setImageUrl(rowItem.getSmallImage(), queue);
        }
        return convertView;
    }
}
