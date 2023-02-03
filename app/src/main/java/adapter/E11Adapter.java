package adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.season9.R;
import com.ramotion.foldingcell.FoldingCell;

import java.util.List;

import app.Application;

public class E11Adapter extends RecyclerView.Adapter<E11Adapter.MyViewHolder> {

    List<String> list;
    Activity activity;

    public E11Adapter(Activity activity , List<String> list){
        this.activity = activity;
        this.list     = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(Application.getContext()).inflate(R.layout.e11_row , parent , false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.name.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        AppCompatTextView name , LastName , other;
        FoldingCell fw;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            LastName = itemView.findViewById(R.id.LastName);
            other = itemView.findViewById(R.id.other);
            fw       = itemView.findViewById(R.id.folding_cell);

            fw.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    fw.toggle(false);
                }
            });
        }
    }
}
