package com.example.week11;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import com.example.week11.adaptadores.ProductoAdaptador;
import com.example.week11.helpers.QueueUtils;
import com.example.week11.modelos.productos;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    QueueUtils.QueueObject queue = null;
    ListView productosList;
    ProductoAdaptador ProductoAdaptador;
        ArrayList<productos> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        queue = QueueUtils.getInstance(this.getApplicationContext());
        items = new ArrayList<>();
        productos.injectContactsFromCloud(queue, items, this);
        productosList = findViewById(R.id.productosList);
        ProductoAdaptador = new ProductoAdaptador(this, items, queue.getImageLoader());
        productosList.setAdapter(ProductoAdaptador);
        productos.sendRequestPOST(queue, this);
    }
    public void refreshList(){
        if ( ProductoAdaptador!= null ) {
            ProductoAdaptador.notifyDataSetChanged();
        }
    }
}
