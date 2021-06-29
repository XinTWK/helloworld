package com.larva.helloworld.jump;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.larva.helloworld.R;

public class AActivity extends AppCompatActivity {

    private Button mBtnJump;
    private Button mBtnJump2;

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        Log.d("AActivity","----onCreate----");
        Log.d("AActivity","taskid:"+getTaskId()+"  ,hash:"+hashCode());
        logtaskName();
        mBtnJump = findViewById(R.id.jump);
        mBtnJump2 = findViewById(R.id.jump_2);
        mBtnJump2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AActivity.this,AActivity.class);
                startActivity(intent);
            }
        });
        mBtnJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 顯示1
                Intent intent = new Intent(AActivity.this,BActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("name","喇叭雞");
                bundle.putInt("number",88);
                intent.putExtras(bundle);
                startActivity(intent);
//                startActivityForResult(intent,0);

                // 顯示2
//                Intent intent = new Intent();
//                intent.setClass(AActivity.this,BActivity.class);
//                startActivity(intent);

                // 顯示3
//                Intent intent = new Intent();
//                intent.setClassName(AActivity.this,"com.larva.helloworld.jump.BActivity");
//                startActivity(intent);

                // 顯示4
//                Intent intent = new Intent();
//                intent.setComponent(new ComponentName(AActivity.this,"com.larva.helloworld.jump.BActivity"));
//                startActivity(intent);

                // 隱式
//                Intent intent = new Intent();
//                intent.setAction("com.larva.test00.BActivity");
//                startActivity(intent);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode,int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(AActivity.this,data.getExtras().getString("title"),Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d("AActivity","----onNewIntent----");
        Log.d("AActivity","taskid:"+getTaskId()+"  ,hash:"+hashCode());
        logtaskName();
    }

    private void logtaskName(){
        try {
            ActivityInfo info = getPackageManager().getActivityInfo(getComponentName(), PackageManager.GET_META_DATA);
            Log.d("AActivity",info.taskAffinity);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}
