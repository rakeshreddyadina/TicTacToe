package com.adina.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;


public class PlayerActivity extends AppCompatActivity {

    EditText player1,player2;
    MaterialButton start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        player1=findViewById(R.id.player1);
        player2=findViewById(R.id.player2);
        start=findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (player1.getText().toString().isEmpty()||player2.getText().toString().isEmpty()){
                    Toast.makeText(PlayerActivity.this, "Enter Player Names", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent=new Intent(PlayerActivity.this,MainActivity.class);
                    intent.putExtra("player1",player1.getText().toString());
                    intent.putExtra("player2",player2.getText().toString());
                    startActivity(intent);

                }
            }
        });
    }
}