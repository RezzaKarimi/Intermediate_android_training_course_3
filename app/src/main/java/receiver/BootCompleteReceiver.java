package receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.season9.E08BootCompleteReceiver;

import app.*;

public class BootCompleteReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {



        if("android.intent.action.BOOT_COMPLETED".equals(intent.getAction())){
            app.t("BOOT");
            context.startActivity(new Intent(context , E08BootCompleteReceiver.class));
        }
    }




}