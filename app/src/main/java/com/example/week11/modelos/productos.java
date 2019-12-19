package com.example.week11.modelos;

import java.util.ArrayList;

public class productos {
    public String Precio ;
    public String Nombre;
    public  String image;

    public String getSmallImage(){
        return  this.image;
    }

    public productos(String _Precio, String _Nombre, String _image) {
        this.Precio = _Precio;
        this.Nombre = _Nombre;
        this.image=_image;

    }


    public static ArrayList getCollection() {
        ArrayList<productos> collection = new ArrayList<>();
        collection.add(new productos("18", "Leopardo","https://mymodernmet.com/wp/wp-content/uploads/2019/09/100k-ai-faces-3.jpg"));
        collection.add(new productos("19", "Tigre", "https://mymodernmet.com/wp/wp-content/uploads/2019/09/100k-ai-faces-8.jpg"));
        collection.add(new productos("27", "Leon","https://mymodernmet.com/wp/wp-content/uploads/2019/09/100k-ai-faces-7.jpg"));
        collection.add(new productos("28", "Gato","https://mymodernmet.com/wp/wp-content/uploads/2019/09/100k-ai-faces-4.jpg"));
        return collection;
    }
}
