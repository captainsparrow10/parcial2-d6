package com.example.tiendafake;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonNavigateToMenu = findViewById(R.id.btn_navigate_to_menu);
        Button buttonNavigateToSchedule = findViewById(R.id.btn_navigate_to_schedule);
        Button buttonNavigateToInformation= findViewById(R.id.btn_navigate_to_information);

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
        startActivity(intent);
    }

    public void navigateToMenu (){
        Intent intent = new Intent( this, Menu.class );
        startActivity(intent);
    }

    public void navigateToInformation (){
        Intent intent = new Intent( this, Information.class );
        startActivity(intent);
    }


}