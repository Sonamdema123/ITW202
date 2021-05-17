package com.example.todo_18;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class SportAdapter extends RecyclerView.Adapter<SportAdapter.ViewHolder> {
    private ArrayList<Sport>mSportData;
    private Context mContext;//context is a class,

    SportAdapter(Context context, ArrayList<Sport> sportsData){
        this.mSportData = sportsData;
        this.mContext = context;
    }

    @NonNull
    @Override

    public SportAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //LayoutInflater used to link java file with list_item xml
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SportAdapter.ViewHolder holder, int position) {
        //get current sport
        Sport currentSport = mSportData.get(position);
        //populate the TextView with data
        holder.bindTo(currentSport);

    }

    @Override
    public int getItemCount() {
        return mSportData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //member variable for the TextView
        private TextView mTitleText;
        private TextView mInfoText;
        private ImageView mSportsImage;

        ViewHolder(View itemView) {
            super(itemView);

            //initialize the view
            mTitleText = (TextView)itemView.findViewById(R.id.title);
            mInfoText = (TextView) itemView.findViewById(R.id.subTitle);
            mSportsImage = itemView.findViewById(R.id.sportsImage);

        }
        void bindTo(Sport currentSport){

            mTitleText.setText(currentSport.getTitle());
            mInfoText.setText(currentSport.getInfo());
            Glide.with(mContext).load(currentSport.getImageResource()).into(mSportsImage);
        }
    }
}
