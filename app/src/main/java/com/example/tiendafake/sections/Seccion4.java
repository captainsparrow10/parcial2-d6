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
import androidx.recyclerview.widget.RecyclerView;

import com.example.tiendafake.MainActivity;
import com.example.tiendafake.Menu;
import com.example.tiendafake.R;
import com.example.tiendafake.adapters.ProductAdapter;
import com.example.tiendafake.models.Product;

import java.util.ArrayList;

public class Seccion4 extends AppCompatActivity {

    private String name;
    private TextView tvName;
    private Button bMenu;
    private Button inicio;
    ArrayList<Product> products;
    ProductAdapter adapter;
    RecyclerView playout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_seccion4);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        playout = findViewById(R.id.productcard);

        products = new ArrayList<>();
        products.add(new Product(R.drawable.gorra1, 1, "Gorra 1", "12"));
        products.add(new Product(R.drawable.gorra2, 2, "Gorra 2", "50"));
        products.add(new Product(R.drawable.gorra3, 3, "Gorra 3", "10"));
        products.add(new Product(R.drawable.gorra4, 4, "Gorra 4", "12"));
        products.add(new Product(R.drawable.gorra5, 5, "Gorra 5", "9"));
        products.add(new Product(R.drawable.gorra6, 6, "Gorra 6", "12"));
        products.add(new Product(R.drawable.gorra7, 7, "Gorra 7", "20"));
        products.add(new Product(R.drawable.gorra8, 8, "Gorra 8", "12"));
        products.add(new Product(R.drawable.gorra9, 9, "Gorra 9", "1152"));
        products.add(new Product(R.drawable.gorra10, 10, "Gorra 10", "12"));

        adapter = new ProductAdapter(products, this);
        playout.setAdapter(adapter);
        playout.setLayoutManager(new GridLayoutManager(this, 2));

        tvName = findViewById(R.id.tvName);

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

        name = getIntent().getStringExtra("name");
        if (name != null) {
            tvName.setText(name);
        }
    }

    public void navigateToMenu (){
        Intent intent = new Intent( this, Menu.class );
        intent.putExtra("name", name);
        startActivity(intent);
    }

    public void navigateToMain (){
        Intent intent = new Intent( this, MainActivity.class );
        intent.putExtra("name", name);
        startActivity(intent);
    }
}