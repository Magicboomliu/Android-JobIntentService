package com.example.myapplication

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Handler
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.app.JobIntentService

class JobIntentServiceExample: JobIntentService() {
//
    var handler: Handler = Handler()
    @RequiresApi(Build.VERSION_CODES.M)
    private var restart = Runnable { AlarmContext(applicationContext) }
    private val TAG:String = "JobIntentServiceExample"


    override fun onHandleWork(intent: Intent) {
        Log.d(TAG,"onHandleWork")
        if(isStopped){return}
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(TAG,"onStartCommand")
        return super.onStartCommand(intent, flags, startId)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate() {
        Log.d(TAG,"onCreate")
        super.onCreate()
        handler.post(restart)
    }

    override fun onDestroy() {
        Log.d(TAG,"onDestroy")
        super.onDestroy()
    }

    override fun onStopCurrentWork(): Boolean {
        Log.d(TAG,"onStopCurrentWork")
        return super.onStopCurrentWork()
    }
    @RequiresApi(Build.VERSION_CODES.M)
    private fun AlarmContext(context: Context) {
        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val i = Intent(context, StartAppOnBoot::class.java)
        i.addFlags(Intent.FLAG_EXCLUDE_STOPPED_PACKAGES)
        val alarmIntent = PendingIntent.getBroadcast(context, 0, i, 0)
        alarmManager.setExactAndAllowWhileIdle(
            AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + 5000,
            alarmIntent
        )
    }

    companion object{

       fun enqueueWork(context: Context,intent: Intent){
           enqueueWork(context,JobIntentServiceExample::class.java,123,intent)
       }


    }
}