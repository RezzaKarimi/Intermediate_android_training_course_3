package app;

import android.util.Log;
import android.widget.Toast;

import com.prathameshmore.toastylibrary.Toasty;

public class app {
    public static final Toasty toast = new Toasty(Application.getContext());

    public static class main{
        public static final String Tag = "SEASON9";
    }

    public static void l(String message){
        Log.e(main.Tag , message);
    }

    public static void t(String message){
        Toast.makeText(Application.getContext() , message , Toast.LENGTH_SHORT).show();
    }
    public static void toasty(String message){
        //not original Toasty
        toast.primaryToasty(Application.getContext() , message , Toast.LENGTH_SHORT , Toasty.BOTTOM|Toasty.CENTER);
//        toast.dangerToasty(Application.getContext() , message , Toast.LENGTH_SHORT , Toasty.BOTTOM|Toasty.CENTER);
//        toast.darkToasty(Application.getContext() , message , Toast.LENGTH_SHORT , Toasty.BOTTOM|Toasty.CENTER);
//        toast.infoToasty(Application.getContext() , message , Toast.LENGTH_SHORT , Toasty.BOTTOM|Toasty.CENTER);
//        toast.lightToasty(Application.getContext() , message , Toast.LENGTH_SHORT , Toasty.BOTTOM|Toasty.CENTER);
//        toast.secondaryToasty(Application.getContext() , message , Toast.LENGTH_SHORT , Toasty.BOTTOM|Toasty.CENTER);
//        toast.successToasty(Application.getContext() , message , Toast.LENGTH_SHORT , Toasty.BOTTOM|Toasty.CENTER);
//        toast.warningToasty(Application.getContext() , message , Toast.LENGTH_SHORT , Toasty.BOTTOM|Toasty.CENTER);
    }
}
