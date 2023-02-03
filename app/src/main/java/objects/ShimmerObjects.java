package objects;

import com.example.season9.R;

import app.Application;

public class ShimmerObjects {
    int img;
    int background = Application.getContext().getResources().getColor(R.color.white);
    String name , lastName , city;

    public ShimmerObjects (int img , String name , String lastName , String city){
        this.img      = img;
        this.name     = name;
        this.lastName = lastName;
        this.city     = city;
    }

    public int getImg(){
        return this.img;
    }

    public int getBackground(){
        return this.background;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCity() {
        return city;
    }


}
