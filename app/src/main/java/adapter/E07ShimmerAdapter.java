package adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.season9.R;

import java.util.List;

import app.Application;
import objects.ShimmerObjects;

public class E07ShimmerAdapter extends RecyclerView.Adapter<E07ShimmerAdapter.MyViewHolder> {


    Activity activity;
    List<ShimmerObjects> list;

    public E07ShimmerAdapter(Activity activity , List<ShimmerObjects> list){
        this.activity = activity;
        this.list  = list;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(Application.getContext()).inflate(R.layout.e07_row , parent , false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.image.setImageResource(list.get(position).getImg());
        holder.name.setText(list.get(position).getName());
        holder.name.setBackgroundColor(list.get(position).getBackground());
        holder.lastName.setText(list.get(position).getLastName());
        holder.lastName.setBackgroundColor(list.get(position).getBackground());
        holder.city.setText(list.get(position).getCity());
        holder.city.setBackgroundColor(list.get(position).getBackground());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        AppCompatImageView image;
        AppCompatTextView name , lastName , city;
         public MyViewHolder(@NonNull View itemView) {
             super(itemView);
             image    = itemView.findViewById(R.id.image);
             name     = itemView.findViewById(R.id.name);
             lastName = itemView.findViewById(R.id.LastName);
             city     = itemView.findViewById(R.id.city);
         }
     }
}
