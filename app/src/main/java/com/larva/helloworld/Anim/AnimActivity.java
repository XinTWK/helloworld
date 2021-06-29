package com.larva.helloworld.Anim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.larva.helloworld.R;

public class AnimActivity extends AppCompatActivity {

    private Button mBtnObjectAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim);
        mBtnObjectAnim = findViewById(R.id.btn_objectanim);
        mBtnObjectAnim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AnimActivity.this,ObjectAnimActivity.class);
                startActivity(intent);
            }
        });
    }
}