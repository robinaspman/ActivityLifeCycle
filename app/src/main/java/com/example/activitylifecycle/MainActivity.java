package com.example.activitylifecycle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button showGuess;
    private EditText enterGuess;
    private final int REQUEST_CODE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showGuess = findViewById(R.id.button_guess);
        enterGuess = findViewById(R.id.guess_field);

        showGuess.setOnClickListener(view -> {

            String guess = enterGuess.getText().toString().trim();

            if (!guess.isEmpty()) {
                Intent intent = new Intent(MainActivity.this, ShowGuess.class);
                intent.putExtra("guess", guess);
                intent.putExtra("name", "bond");
                intent.putExtra("age", 34);
                startActivityForResult(intent, REQUEST_CODE);
                //startActivity(intent);
            } else {
                Toast.makeText(this, "Enter guess", Toast.LENGTH_SHORT).show();
            }
//            startActivity(new Intent(MainActivity.this, ShowGuess.class));
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE) {
            assert data != null;
            String message = data.getStringExtra("message");
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
    }

    //    @Override
//    protected void onStart() {
//        super.onStart();
//        Log.d("Cycle", "onStart: ");
//        Toast.makeText(this, "OnStart() Called", Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        Log.d("Cycle", "onResume: ");
//        Toast.makeText(this, "OnResume() Called", Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        Log.d("Cycle", "onPause: ");
//        Toast.makeText(this, "OnPause() Called", Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        Log.d("Cycle", "onStop: ");
//        Toast.makeText(this, "OnStop() Called", Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        Log.d("Cycle", "onDestroy: ");
//        Toast.makeText(this, "OnDestroy() Called", Toast.LENGTH_SHORT).show();
//    }
}