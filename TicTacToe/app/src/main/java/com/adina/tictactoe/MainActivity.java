package com.adina.tictactoe;

import static com.adina.tictactoe.R.drawable;
import static com.adina.tictactoe.R.drawable.black_border;
import static com.adina.tictactoe.R.drawable.white_card;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.adina.tictactoe.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    int[] boxPosition= new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
    ActivityMainBinding binding;
    int chance=1,i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.text1.setText(getIntent().getStringExtra("player1"));
        binding.text2.setText(getIntent().getStringExtra("player2"));
        checkPlayer();
        binding.image1.setOnClickListener(v -> onClickButton(binding.image1,0));
        binding.image2.setOnClickListener(v -> onClickButton(binding.image2,1));
        binding.image3.setOnClickListener(v -> onClickButton(binding.image3,2));
        binding.image4.setOnClickListener(v -> onClickButton(binding.image4,3));
        binding.image5.setOnClickListener(v -> onClickButton(binding.image5,4));
        binding.image6.setOnClickListener(v -> onClickButton(binding.image6,5));
        binding.image7.setOnClickListener(v -> onClickButton(binding.image7,6));
        binding.image8.setOnClickListener(v -> onClickButton(binding.image8,7));
        binding.image9.setOnClickListener(v -> onClickButton(binding.image9,8));
    }
    @SuppressLint("UseCompatLoadingForDrawables")
    private void checkPlayer(){
         if(chance%2!=0){
            binding.player2card.setBackground(getDrawable(white_card));
            binding.player1card.setBackground(getDrawable(black_border));
        }
        else{
            binding.player1card.setBackground(getDrawable(white_card));
            binding.player2card.setBackground(getDrawable(black_border));
        }
    }
    @SuppressLint("UseCompatLoadingForDrawables")
    private void onClickButton(ImageView imageView,int position){
        if(i==0&&boxPosition[position]==0) {
            if (chance % 2 != 0) {
                imageView.setImageDrawable(getDrawable(drawable.ximage));
                boxPosition[position] = 1;
            } else if (chance % 2 == 0) {
                imageView.setImageDrawable(getDrawable(drawable.oimage));
                boxPosition[position] = 2;
            }
            if (chance < 10) {
                checkResult();
                chance++;
                checkPlayer();
            }
            if (chance == 10) {
                checkResult();
                if(i==0){
                    Result_Dialog result_dialog = new Result_Dialog(MainActivity.this, MainActivity.this, "MATCH DRAW");
                    result_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    result_dialog.setCancelable(false);
                    result_dialog.show();
                }

            }
        }
    }

    private void checkResult() {
        combination(0,1,2);
        combination(3,4,5);
        combination(6,7,8);
        combination(0,3,6);
        combination(1,4,7);
        combination(2,5,8);
        combination(0,4,8);
        combination(2,4,6);
    }

    private void combination(int a,int b, int c) {
        if((boxPosition[a]==boxPosition[b])&&(boxPosition[b]==boxPosition[c])){
            if(boxPosition[a]==1){
                Result_Dialog result_dialog=new Result_Dialog(MainActivity.this,MainActivity.this,binding.text1.getText().toString()+" IS WINNER");
                result_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                result_dialog.setCancelable(false);
                result_dialog.show();
                i=1;
            }
            else if (boxPosition[a]==2){
                Result_Dialog result_dialog=new Result_Dialog(MainActivity.this,MainActivity.this,binding.text2.getText().toString()+" IS WINNER");
                result_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                result_dialog.setCancelable(false);
                result_dialog.show();
                i=2;
            }

        }
    }

    public void restart() {
        boxPosition= new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        chance=1;
        checkPlayer();
        i=0;
        binding.image1.setImageResource(R.drawable.white_card);
        binding.image2.setImageResource(R.drawable.white_card);
        binding.image3.setImageResource(R.drawable.white_card);
        binding.image4.setImageResource(R.drawable.white_card);
        binding.image5.setImageResource(R.drawable.white_card);
        binding.image6.setImageResource(R.drawable.white_card);
        binding.image7.setImageResource(R.drawable.white_card);
        binding.image8.setImageResource(R.drawable.white_card);
        binding.image9.setImageResource(R.drawable.white_card);
    }
}