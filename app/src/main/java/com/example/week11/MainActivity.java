package com.example.week11;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import com.example.week11.adaptadores.ProductoAdaptador;
import com.example.week11.helpers.QueueUtils;
import com.example.week11.modelos.productos;

public class MainActivity extends AppCompatActivity {
    QueueUtils.QueueObject queue = null;
    ListView productosList;
    ProductoAdaptador ProductoAdaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        queue = QueueUtils.getInstance(this.getApplicationContext());
        productosList = findViewById(R.id.productosList);
        ProductoAdaptador = new ProductoAdaptador(this, productos.getCollection(), queue.getImageLoader());
        productosList.setAdapter(ProductoAdaptador);
    }
}
