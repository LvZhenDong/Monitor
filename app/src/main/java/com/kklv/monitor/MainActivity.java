package com.kklv.monitor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.kklv.monitor.service.FxService;

public class MainActivity extends AppCompatActivity {

    private Button mBtnStart;
    private Button mBtnRemove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindId();
        initView();
    }

    private void bindId() {
        mBtnStart = (Button) findViewById(R.id.btn_start);
        mBtnRemove = (Button) findViewById(R.id.btn_remove);

    }

    private void initView(){
        mBtnStart.setOnClickListener(serviceBtnOnClickListener);
        mBtnRemove.setOnClickListener(serviceBtnOnClickListener);
    }

    private View.OnClickListener serviceBtnOnClickListener =new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v == mBtnStart) {
                Intent intent = new Intent(MainActivity.this, FxService.class);
                startService(intent);


            } else if (v == mBtnRemove) {
                Intent intent = new Intent(MainActivity.this, FxService.class);
                stopService(intent);
            }
        }
    };
}
