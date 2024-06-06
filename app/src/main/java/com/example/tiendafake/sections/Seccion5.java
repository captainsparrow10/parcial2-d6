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

public class Seccion5 extends AppCompatActivity {

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
        setContentView(R.layout.activity_seccion5);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        playout = findViewById(R.id.productcard);

        products = new ArrayList<>();
        products.add(new Product(R.drawable.zapatillas1, 1, "Zapatilla 1", "12"));
        products.add(new Product(R.drawable.zapatillas2, 2, "Zapatilla 2", "50"));
        products.add(new Product(R.drawable.zapatillas3, 3, "Zapatilla 3", "10"));
        products.add(new Product(R.drawable.zapatillas1, 4, "Zapatilla 4", "12"));
        products.add(new Product(R.drawable.zapatillas5, 5, "Zapatilla 5", "9"));
        products.add(new Product(R.drawable.zapatillas6, 6, "Zapatilla 6", "12"));
        products.add(new Product(R.drawable.zapatillas7, 7, "Zapatilla 7", "20"));
        products.add(new Product(R.drawable.zapatillas8, 8, "Zapatilla 8", "12"));
        products.add(new Product(R.drawable.zapatillas9, 9, "Zapatilla 9", "1152"));
        products.add(new Product(R.drawable.zapatillas10, 10, "Zapatilla 10", "12"));

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