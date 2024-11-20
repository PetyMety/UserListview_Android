package com.example.customlistview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button registerButton;
    private Button listOfUsersButton;
    private static ArrayList<Users> users;
    private TextInputLayout emailTextinputLayout;
    private TextInputLayout passwordTextinputLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();
        registerButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view){
                    String email = emailTextinputLayout.getEditText().getText().toString();
                    String password = passwordTextinputLayout.getEditText().getText().toString();

                    Users user = new Users(email, password);
                    users.add(user);
                    Toast.makeText(MainActivity.this, "Sikeres regisztráció", Toast.LENGTH_SHORT).show();
            }
        });

        listOfUsersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, ListOfUsersActivity.class);
                startActivity(intent);

                finish();
            }
        });

    }

    public void init(){
        registerButton = findViewById(R.id.registerButton);
        listOfUsersButton = findViewById(R.id.listOfUsersButton);
        emailTextinputLayout = findViewById(R.id.emailTextInputLayout);
        passwordTextinputLayout = findViewById(R.id.passwordTextInputLayout);
        users = new ArrayList<>();

    }

    public static ArrayList<Users> getUsers() {
        return users;
    }



}