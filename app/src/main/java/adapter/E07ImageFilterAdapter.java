package adapter;

import android.app.Activity;
import android.net.sip.SipSession;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.season9.R;

import java.util.ArrayList;
import java.util.List;

import app.Application;
import intefaces.ImageFilterListener;
import app.*;

public class E07ImageFilterAdapter extends RecyclerView.Adapter<E07ImageFilterAdapter.MyViewHolder> {

    List<String> list;
    Activity activity;
    ImageFilterListener listener;


    public E07ImageFilterAdapter(Activity activity , List<String> list , ImageFilterListener listener){

        this.activity = activity;
        this.list     = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(Application.getContext()).inflate(R.layout.e07_image_filter_row , parent , false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.name.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        LinearLayout parent;
        AppCompatTextView name;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            parent = itemView.findViewById(R.id.parent);
            name   = itemView.findViewById(R.id.name);

            parent.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            String filter = list.get(getAdapterPosition());
            listener.filterSelected(filter);

        }
    }
}
