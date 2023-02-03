package app;

import android.content.Context;

import com.prathameshmore.toastylibrary.Toasty;

public class Application extends android.app.Application {
    public static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }

    public static Context getContext(){
        return context;
    }
}
