package com.example.owner.activities.admin

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class PaytenQRReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val response = intent!!.getStringExtra("ResponseResult")

        val i = Intent(context, GetQRCodeActivity::class.java)
        i.putExtra("ResponseResult", response)
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        i.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
        context!!.startActivity(i)

    }

}