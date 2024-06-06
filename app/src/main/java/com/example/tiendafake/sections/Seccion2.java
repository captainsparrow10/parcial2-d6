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

public class Seccion2 extends AppCompatActivity {

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
        setContentView(R.layout.activity_seccion2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        playout = findViewById(R.id.productcard);

        products = new ArrayList<>();
        products.add(new Product(R.drawable.deportivo1, 1, "Deportivo 1", "12"));
        products.add(new Product(R.drawable.deportivo2, 2, "Deportivo 2", "50"));
        products.add(new Product(R.drawable.deportivo3, 3, "Deportivo 3", "10"));
        products.add(new Product(R.drawable.deportivo4, 4, "Deportivo 4", "12"));
        products.add(new Product(R.drawable.deportivo5, 5, "Deportivo 5", "9"));
        products.add(new Product(R.drawable.deportivo6, 6, "Deportivo 6", "12"));
        products.add(new Product(R.drawable.deportivo7, 7, "Deportivo 7", "20"));
        products.add(new Product(R.drawable.deportivo8, 8, "Deportivo 8", "12"));
        products.add(new Product(R.drawable.deportivo9, 9, "Deportivo 9", "1152"));
        products.add(new Product(R.drawable.deportivo10, 10, "Deportivo 10", "12"));

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