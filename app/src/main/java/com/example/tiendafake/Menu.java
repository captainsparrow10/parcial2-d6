package com.example.tiendafake;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.tiendafake.sections.Seccion1;
import com.example.tiendafake.sections.Seccion2;
import com.example.tiendafake.sections.Seccion3;
import com.example.tiendafake.sections.Seccion4;
import com.example.tiendafake.sections.Seccion5;

public class Menu extends AppCompatActivity {

    private String name;
    private TextView tvName;
    private Button btInicio;
    private RelativeLayout seccion1;
    private RelativeLayout seccion2;

    private RelativeLayout seccion3;

    private RelativeLayout seccion4;

    private RelativeLayout seccion5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvName = findViewById(R.id.tvName);
        btInicio = findViewById(R.id.mBt2);
        seccion1 = findViewById(R.id.seccion1);
        seccion2 = findViewById(R.id.seccion2);
        seccion3 = findViewById(R.id.seccion3);
        seccion4 = findViewById(R.id.seccion4);
        seccion5 = findViewById(R.id.seccion5);

        name = getIntent().getStringExtra("name");
        if (name != null) {
            tvName.setText("Usuario actual" + name);
        }

        btInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToMain();
            }
        });

        seccion1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToSection1();
            }
        });
        seccion2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToSection2();
            }
        });
        seccion3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToSection3();
            }
        });
        seccion4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToSection4();
            }
        });
        seccion5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToSection5();
            }
        });

    }

    public void navigateToMain (){
        Intent intent = new Intent( this, MainActivity.class );
        intent.putExtra("name", name);
        startActivity(intent);
    }

    public void navigateToSection1 (){
        Intent intent = new Intent( this, Seccion1.class );
        intent.putExtra("name", name);
        startActivity(intent);
    }
    public void navigateToSection2 (){
        Intent intent = new Intent( this, Seccion2.class );
        intent.putExtra("name", name);
        startActivity(intent);
    }
    public void navigateToSection3 (){
        Intent intent = new Intent( this, Seccion3.class );
        intent.putExtra("name", name);
        startActivity(intent);
    }
    public void navigateToSection4 (){
        Intent intent = new Intent( this, Seccion4.class );
        intent.putExtra("name", name);
        startActivity(intent);
    }
    public void navigateToSection5 (){
        Intent intent = new Intent( this, Seccion5.class );
        intent.putExtra("name", name);
        startActivity(intent);
    }
}