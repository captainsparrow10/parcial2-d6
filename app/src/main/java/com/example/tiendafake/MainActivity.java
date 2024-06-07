package com.example.tiendafake;

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

import com.example.tiendafake.modals.EscribirNombre;

public class MainActivity extends AppCompatActivity {

    private String name;
    private TextView tvName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonNavigateToMenu = findViewById(R.id.btn_navigate_to_menu);
        Button buttonNavigateToSchedule = findViewById(R.id.btn_navigate_to_schedule);
        Button buttonNavigateToInformation= findViewById(R.id.btn_navigate_to_information);

        tvName = findViewById(R.id.tvName);

        name = getIntent().getStringExtra("name");
        if (name != null) {
            tvName.setText("Usuario actual: "+ name);
        }

        buttonNavigateToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToMenu();
            }
        });

        buttonNavigateToSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToSchedule();
            }
        });

        buttonNavigateToInformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToInformation();
            }
        });

        EdgeToEdge.enable(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void navigateToSchedule (){
        Intent intent = new Intent( this, Schedule.class );
        intent.putExtra("name", name);
        startActivity(intent);
    }

    public void navigateToMenu (){

        if (name != null) {
            Intent intent = new Intent( this, Menu.class );
            intent.putExtra("name", name);
            startActivity(intent);

        } else {
            Intent intent = new Intent( this, EscribirNombre.class );
            startActivity(intent);
        }


    }

    public void navigateToInformation (){
        Intent intent = new Intent( this, Information.class );
        intent.putExtra("name", name);
        startActivity(intent);
    }


}