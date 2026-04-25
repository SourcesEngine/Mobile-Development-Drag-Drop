package com.example.swapperandchecker;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText field1, field2;
    Button btnSwap, btnCheck;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
        field1 = findViewById(R.id.textField1);
        field2 = findViewById(R.id.textField2);

        btnSwap = findViewById(R.id.btnSwap);
        btnCheck = findViewById(R.id.btnCheck);

        btnSwap.setOnClickListener(v -> {
            String temp = field1.getText().toString();
            field1.setText(field2.getText().toString());
            field2.setText(temp);
        });

        btnCheck.setOnClickListener(v -> {
            String val1 = field1.getText().toString();
            String val2 = field2.getText().toString();
            String result = val1.equals(val2) ? "SAME" : "NOT THE SAME";

            Intent intent = new Intent(MainActivity.this, MessageActivity.class);
            intent.putExtra("res_key", result);
            startActivity(intent);
        });


    }
}