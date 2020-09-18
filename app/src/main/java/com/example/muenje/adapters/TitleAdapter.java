package com.example.muenje.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.muenje.R;
import com.example.muenje.data.entities.Title;
import com.example.muenje.ui.pickerfragment.TitleClickedCallback;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

public class TitleAdapter extends RecyclerView.Adapter<TitleAdapter.TitleViewHolder> implements TitleClickedListener  {


    private List<Title> mData = new ArrayList<>();

    private TitleClickedCallback mCallback;

    public TitleAdapter(TitleClickedCallback callback){
        mCallback = callback;
    }

    @NonNull
    @Override
    public TitleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TitleViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_title,parent,false),this::titleClicked);
    }

    @Override
    public void onBindViewHolder(@NonNull TitleViewHolder holder, int position) {
        holder.bind(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public void titleClicked(Integer id) {
        mCallback.titleClicked(id);
    }

    public void setData(List<Title> titleList){
        mData = titleList;
        notifyDataSetChanged();
    }

    class TitleViewHolder extends RecyclerView.ViewHolder{

        MaterialButton mButton;
        Title mData;

        public TitleViewHolder(@NonNull View itemView,TitleClickedListener titleClickedListener) {
            super(itemView);
            mButton = itemView.findViewById(R.id.title_button);
            mButton.setOnClickListener((view) -> titleClickedListener.titleClicked(mData.getId()));
        }

        public void bind(Title title){
            mData = title;
            mButton.setText(mData.getTitle());
        }
    }
}
