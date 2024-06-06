package com.example.tiendafake.sections;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tiendafake.MainActivity;
import com.example.tiendafake.Menu;
import com.example.tiendafake.R;
import com.example.tiendafake.adapters.ProductAdapter;
import com.example.tiendafake.models.Product;

import java.util.ArrayList;

public class Seccion1 extends AppCompatActivity {

    ArrayList<Product> products;
    ProductAdapter adapter;
    RecyclerView playout;

    private String name;
    private TextView tvName;
    private Button bMenu;

    private Button inicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_seccion1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        playout = findViewById(R.id.productcard);

        products = new ArrayList<>();
        products.add(new Product(R.drawable.pelota1, 1, "Pelota 1", "12"));
        products.add(new Product(R.drawable.pelota2, 2, "Pelota 2", "50"));
        products.add(new Product(R.drawable.pelota3, 3, "Pelota 3", "10"));
        products.add(new Product(R.drawable.pelota4, 4, "Pelota 4", "12"));
        products.add(new Product(R.drawable.pelota5, 5, "Pelota 5", "9"));
        products.add(new Product(R.drawable.pelota6, 6, "Pelota 6", "12"));
        products.add(new Product(R.drawable.pelota7, 7, "Pelota 7", "20"));
        products.add(new Product(R.drawable.pelota8, 8, "Pelota 8", "12"));
        products.add(new Product(R.drawable.pelota9, 9, "Pelota 9", "1152"));
        products.add(new Product(R.drawable.pelota10, 10, "Pelota 10", "12"));

        adapter = new ProductAdapter(products, this);
        playout.setAdapter(adapter);
        playout.setLayoutManager(new GridLayoutManager(this, 2));


        bMenu = findViewById(R.id.seccion1Btn);
        inicio = findViewById(R.id.btnInicio);
        inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToMain();
            }
        });
        bMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToMenu();
            }
        });



        tvName = findViewById(R.id.tvName);

        name = getIntent().getStringExtra("name");
        if (name != null) {
            tvName.setText("Usuario: " +name);
        }


    }

    public void navigateToMain (){
        Intent intent = new Intent( this, MainActivity.class );
        intent.putExtra("name", name);
        startActivity(intent);
    }

    public void navigateToMenu (){
        Intent intent = new Intent( this, Menu.class );
        intent.putExtra("name", name);
        startActivity(intent);
    }
}