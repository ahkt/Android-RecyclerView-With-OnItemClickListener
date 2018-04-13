package com.example.kamere.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Kamere on 4/12/2018.
 */

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.FruitViewHolder> {

    Context context;
    List<Fruits> fruitsList;

    public FruitAdapter(Context context, List<Fruits> fruitsList) {
        this.context = context;
        this.fruitsList = fruitsList;
    }


    @Override
    public FruitViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate our view holder
       LayoutInflater inflater = LayoutInflater.from(context);
       View view1 = inflater.inflate(R.layout.fruits_list_data,null);
       return new FruitViewHolder(view1);
    }

    @Override
    public void onBindViewHolder(FruitViewHolder holder, int position) {

        Fruits fruits = fruitsList.get(position);
        holder.fName.setText(fruits.getName());
        holder.fDesc.setText(fruits.getDesc());
        holder.fImage.setImageDrawable(context.getResources().getDrawable(fruits.getImage()));
    }

    @Override
    public int getItemCount() {
        return fruitsList.size();
    }

    public class FruitViewHolder extends RecyclerView.ViewHolder {
        TextView fName,fDesc;
        ImageView fImage;


        public FruitViewHolder(View itemView) {
            super(itemView);
            fName = itemView.findViewById(R.id.fname);
            fDesc = itemView.findViewById(R.id.fdesc);
            fImage = itemView.findViewById(R.id.fImage);

        }
    }
}
