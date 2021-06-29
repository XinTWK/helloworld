package com.larva.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.larva.helloworld.util.ToastUtil;
import com.larva.helloworld.widget.CustomDialog;

public class CustomDialogActivity extends AppCompatActivity {

    private Button mBtnDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);
        mBtnDialog = findViewById(R.id.btn_custom_dialog);
        mBtnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomDialog customDialog = new CustomDialog(CustomDialogActivity.this,R.style.CustomDialog);
                customDialog.setTitle("提示").setMessage("確認刪除此項?")
                        .setCancel("取消", new CustomDialog.IOnCancelListener() {
                            @Override
                            public void onCancel(CustomDialog dialog) {
                                ToastUtil.showMsg(CustomDialogActivity.this,"Cancel...");
                            }
                        }).setConfirm("確認", new CustomDialog.IOnConfirmListener() {
                            @Override
                            public void onConfirm(CustomDialog dialog) {
                                ToastUtil.showMsg(CustomDialogActivity.this,"Confirm...");
                            }
                        }).show();
                }
            });
        }
    }