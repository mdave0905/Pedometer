package md.pedometer.Components;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import md.pedometer.BuildConfig;
import md.pedometer.util.API26Wrapper;
import md.pedometer.util.Logger;

public class AppUpdateReceiever extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(BuildConfig.DEBUG) Logger.log("app updated");
        if(Build.VERSION.SDK_INT>=26){
            API26Wrapper.startForegroundService(context,new Intent(context,SensorListener.class));
        }
        else{
           context.startService(new Intent(context,SensorListener.class));
        }
    }
}
