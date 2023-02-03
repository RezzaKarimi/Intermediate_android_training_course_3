package objects;

import android.app.Activity;
import android.widget.RelativeLayout;

import com.example.season9.R;

public class CustomToastObject {
    private int backGroundColor = R.color.design_default_color_primary_dark;
    private int textColor = R.color.white ;
    private int icon = R.drawable.ic_baseline_create_24;
    private int iconColor = R.color.white ;
    private String text = "";

    public CustomToastObject( int backGroundColor , int textColor , int icon , int iconColor , String text){
        this.backGroundColor = backGroundColor;
        this.textColor       = textColor;
        this.icon            = icon;
        this.iconColor       = iconColor;
        this.text            = text;
    }

    public int getBackGroundColor(){
        return this.backGroundColor;
    }
    public int getTextColor(){
        return this.textColor;
    }
    public int getIcon(){
        return this.icon;
    }
    public int getIconColor(){
        return this.iconColor;
    }
    public String getText(){
        return this.text;
    }

}
