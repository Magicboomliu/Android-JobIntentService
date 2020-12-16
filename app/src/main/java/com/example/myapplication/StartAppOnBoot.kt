package com.example.myapplication

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class StartAppOnBoot : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
            Log.d("JobIntentServiceExample","Boot boardcast received")
            try{
                val i = Intent(context,JobIntentServiceExample::class.java)
                if (context != null) {
                    JobIntentServiceExample.enqueueWork(context,i)
                }

            }catch(e: Exception){
                Log.d("JobIntentServiceExample",e.toString())
            }

            Log.d("JobIntentServiceExample","Service Started")

    }
}