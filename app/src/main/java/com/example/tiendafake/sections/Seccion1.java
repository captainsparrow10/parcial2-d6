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

import com.example.tiendafake.MainActivity;
import com.example.tiendafake.Menu;
import com.example.tiendafake.R;

public class Seccion1 extends AppCompatActivity {

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
            tvName.setText(name);
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