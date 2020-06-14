package com.example.terrariapotions.View.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.terrariapotions.Model.Potion;
import com.example.terrariapotions.R;

import java.util.ArrayList;
import java.util.List;

public class PotionAdapter extends RecyclerView.Adapter<PotionAdapter.ViewHolder> {
    private ArrayList<Potion> potionList;

    public PotionAdapter(ArrayList<Potion> potionList){
        this.potionList= potionList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.potion_item, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Potion potion = potionList.get(position);
        holder.potionDesc.setText(potion.getDescription());
        holder.potionName.setText(potion.getName());

        if (potion.getImgId() != 0) {
            holder.potionImg.setImageResource(potion.getImgId());
        }
    }

    @Override
    public int getItemCount() {
        return potionList.size();
    }

    public void setPotionList(List<Potion> potions) {
        this.potionList = (ArrayList<Potion>) potions;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView potionName, potionDesc;
        private ImageView potionImg;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            potionName = itemView.findViewById(R.id.potion_name);
            potionDesc = itemView.findViewById(R.id.potion_desc);
            potionImg = itemView.findViewById(R.id.potion_img);
        }

        @Override
        public void onClick(View v) {

        }
    }
}
