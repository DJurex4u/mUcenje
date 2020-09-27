package com.example.muenje.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.muenje.R;
import com.example.muenje.data.entities.Leaderboard;
import com.example.muenje.data.entities.SingleLeaderboardEntry;
import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;
import java.util.List;

public class LeaderboardEntryAdapter extends RecyclerView.Adapter<SingleLeaderboardEntryViewHolder>  {


    private List<SingleLeaderboardEntry> mSingleLeaderboardEntryList = new ArrayList<>();  

    @NonNull
    @Override
    public SingleLeaderboardEntryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SingleLeaderboardEntryViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_single_leaderboard_entry,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull SingleLeaderboardEntryViewHolder holder, int position) {
        holder.bind(mSingleLeaderboardEntryList.get(position));
    }

    @Override
    public int getItemCount() {
        Integer size = mSingleLeaderboardEntryList.size();
        return mSingleLeaderboardEntryList.size();
    }

    public void setData(List<SingleLeaderboardEntry> singleLeaderboardEntryList){
        mSingleLeaderboardEntryList = singleLeaderboardEntryList;
        notifyDataSetChanged();
    }
}

class SingleLeaderboardEntryViewHolder extends RecyclerView.ViewHolder {

    MaterialTextView usernameTextView;
    MaterialTextView pointsTextView;


    public SingleLeaderboardEntryViewHolder(@NonNull View itemView) {
        super(itemView);
        usernameTextView = itemView.findViewById(R.id.username_text_view);
        pointsTextView = itemView.findViewById(R.id.points_text_view);
    }

    public void bind(SingleLeaderboardEntry data){
        usernameTextView.setText(data.username);
        pointsTextView.setText(data.points.toString());
    }
}
