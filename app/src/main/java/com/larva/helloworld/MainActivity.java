package com.larva.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.larva.helloworld.Anim.AnimActivity;
import com.larva.helloworld.Anim.ObjectAnimActivity;
import com.larva.helloworld.broadcast.BroadActivity;
import com.larva.helloworld.datastorage.DataStorageActivity;

import static com.larva.helloworld.R.layout.activity_main;

public class MainActivity extends AppCompatActivity {

    private Button mBtnUi,mEvent,mBtnData,mBtnBroadCast,mBtnAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);
        mBtnUi = findViewById(R.id.btn_ui);
        mEvent = findViewById(R.id.btn_event);
        mBtnData = findViewById(R.id.btn_data);
        mBtnBroadCast = findViewById(R.id.btn_broadcast);
        mBtnAnim = findViewById(R.id.btn_anim);
        OnClick onClick = new OnClick();
        mBtnUi.setOnClickListener(onClick);
        mEvent.setOnClickListener(onClick);
        mBtnData.setOnClickListener(onClick);
        mBtnBroadCast.setOnClickListener(onClick);
        mBtnAnim.setOnClickListener(onClick);

        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
    }

    class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()) {
                case R.id.btn_ui:
                    intent = new Intent(MainActivity.this, UIActivity.class);
                    break;
                case R.id.btn_event:
                    intent = new Intent(MainActivity.this,EventActivity.class);
                    break;
                case R.id.btn_data:
                    intent = new Intent(MainActivity.this, DataStorageActivity.class);
                    break;
                case R.id.btn_broadcast:
                    intent = new Intent(MainActivity.this, BroadActivity.class);
                    break;
                case R.id.btn_anim:
                    intent = new Intent(MainActivity.this, AnimActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}