package com.example.muenje.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.muenje.R;
import com.example.muenje.data.entities.SingleAchievement;
import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;
import java.util.List;

public class AchievementsAdapter extends RecyclerView.Adapter<AchievementViewHolder> {

    private List<SingleAchievement> mData = new ArrayList<>();

    @NonNull
    @Override
    public AchievementViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AchievementViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_achievement,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull AchievementViewHolder holder, int position) {
        holder.bind(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setData(List<SingleAchievement> singleAchievementList){
        mData = singleAchievementList;
        notifyDataSetChanged();
    }
}

class AchievementViewHolder extends RecyclerView.ViewHolder{

    final MaterialTextView achievementDisplayName;

    public AchievementViewHolder(@NonNull View itemView) {
        super(itemView);
        achievementDisplayName = itemView.findViewById(R.id.item_achievement_textView);
    }

    public void bind(SingleAchievement singleAchievement){
        achievementDisplayName.setText(singleAchievement.displayName);
    }
}
