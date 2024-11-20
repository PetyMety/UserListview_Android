package com.example.customlistview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ListOfUsersActivity extends AppCompatActivity {

    public Button backButton;
    private ListView listView;
    private UsersAdapter adapter;
    private ArrayList<Users> users;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_of_users);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        init();
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(ListOfUsersActivity.this, MainActivity.class);
                startActivity(intent);

                finish();
            }
        });


    }


    public void init(){
        backButton  = findViewById(R.id.backButton);
        listView = findViewById(R.id.listView);
        users = MainActivity.getUsers();
        adapter = new UsersAdapter(users, ListOfUsersActivity.this);
        listView.setAdapter(adapter);
    }

}