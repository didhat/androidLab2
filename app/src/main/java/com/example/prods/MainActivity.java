package com.example.prods;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ShoppingAdapter shopAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.productList);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        shopAdapter = new ShoppingAdapter(new ArrayList<>());
//        productAdapter = new ProductAdapter(new ArrayList<>(), new ArrayList<>());
        recyclerView.setAdapter(shopAdapter);

        super.onCreate(savedInstanceState);
    }

    public void save(View view) {
        EditText productNameEditText = findViewById(R.id.productName);
        String productName = productNameEditText.getText().toString();
        productNameEditText.setText("");


        shopAdapter.addNote(productName);
    }

}