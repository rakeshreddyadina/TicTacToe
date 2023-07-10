package com.adina.tictactoe;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.DialogCompat;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class Result_Dialog extends Dialog {

    private final MainActivity mainActivity;
    private final String message;

    public Result_Dialog(@NonNull Context context, MainActivity mainActivity, String message) {
        super(context);
        this.mainActivity=mainActivity;
        this.message=message;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_dialog);
        TextView textView=findViewById(R.id.textView);
        MaterialButton restart=findViewById(R.id.restart);
        textView.setText(message);
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.restart();
                dismiss();
            }
        });
    }
}