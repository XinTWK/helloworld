package com.larva.helloworld.jump;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.larva.helloworld.R;

public class BActivity extends AppCompatActivity {

    private TextView mTvTitle;
    private Button mBtnFinish,mBtnJump;

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        Log.d("BActivity","----onCreate----");
        Log.d("BActivity","taskid:"+getTaskId()+"  ,hash:"+hashCode());
        logtaskName();

        mTvTitle = findViewById(R.id.tv_title);
        mBtnFinish = findViewById(R.id.btn_finish);
        mBtnJump = findViewById(R.id.btn_2);
        mBtnJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BActivity.this,AActivity.class);
                startActivity(intent);
            }
        });

        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name");
        int number = bundle.getInt("number");

        mTvTitle.setText(name+","+number);

        mBtnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                Bundle bundle1 = new Bundle();
                bundle1.putString("title","我回來了");
                intent.putExtras(bundle1);
                setResult(Activity.RESULT_OK,intent);
                finish();
            }
        });
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d("BActivity","----onNewIntent----");
        Log.d("BActivity","taskid:"+getTaskId()+"  ,hash:"+hashCode());
        logtaskName();
    }

    private void logtaskName(){
        try {
            ActivityInfo info = getPackageManager().getActivityInfo(getComponentName(), PackageManager.GET_META_DATA);
            Log.d("BActivity",info.taskAffinity);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

}
