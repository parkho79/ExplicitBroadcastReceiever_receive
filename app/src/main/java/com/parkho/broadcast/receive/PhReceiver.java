package com.parkho.broadcast.receive;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class PhReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context a_context, Intent a_intent) {
        Toast.makeText(a_context, a_intent.getAction(), Toast.LENGTH_LONG).show();
    }

}