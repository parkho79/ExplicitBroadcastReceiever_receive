package com.parkho.broadcast;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;

import com.parkho.broadcast.receive.PhReceiver;
import com.parkho.broadcast.receive.R;

public class PhMainActivity extends AppCompatActivity {

    private PhReceiver mReceiver = new PhReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Broadcast 동적 등록
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.parkho.broadcat.send.parkho");
        intentFilter.addAction("com.parkho.broadcat.receive.parkho");
        registerReceiver(mReceiver, intentFilter);

        // 내부 broadcast
        findViewById(R.id.btn_broadcast).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View a_view) {
                Intent intent = new Intent("com.parkho.broadcat.receive.parkho");
                sendBroadcast(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        // Broadcast 등록 해제
        unregisterReceiver(mReceiver);
    }
}