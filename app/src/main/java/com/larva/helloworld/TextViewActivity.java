package com.larva.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class TextViewActivity extends AppCompatActivity {

    private TextView mTv4;
    private TextView mTv5;
    private TextView mTv6;
    private TextView mTv7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);
        mTv4 = findViewById(R.id.tv_4);
        mTv4.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG); //刪除線
        mTv4.getPaint().setAntiAlias(true); //去除鋸齒

        mTv5 = findViewById(R.id.tv_5);
        mTv5.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG); //下橫線

        mTv6 = findViewById(R.id.tv_6);
        mTv6.setText(Html.fromHtml("<u>喇叭雞在睡覺</u>"));

        mTv7 = findViewById(R.id.tv_7);
        mTv7.setSelected(true);
    }
}