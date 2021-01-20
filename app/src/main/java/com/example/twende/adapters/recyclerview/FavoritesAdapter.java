package com.example.twende.adapters.recyclerview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.twende.R;
import com.example.twende.model.FavoritesModel;
import com.example.twende.model.Repo;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class FavoritesAdapter extends RecyclerView.Adapter<FavoritesAdapter.ViewHolder> {

    private static final String TAG = "FavoritesAdapter";

    private Context mCtx;
    ArrayList<FavoritesModel> favoritesArrayList;

    public FavoritesAdapter(Context mCtx, ArrayList<FavoritesModel> favoritesArrayList) {
        this.mCtx = mCtx;
        this.favoritesArrayList = favoritesArrayList;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.item_repository, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final FavoritesModel favoritesModel = favoritesArrayList.get(position);

        holder.setDetails(favoritesModel);
    }

    @Override
    public int getItemCount() {
        return favoritesArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public TextView repoName;
        public TextView repoDescription;
        public FloatingActionButton fab;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            repoName = itemView.findViewById(R.id.repoName);
            repoDescription = itemView.findViewById(R.id.repoDescription);
            fab = itemView.findViewById(R.id.floatingActionButtonItem);

        }

        void setDetails(FavoritesModel favoritesModel) {
            repoName.setText(favoritesModel.getRepo_name());
            repoDescription.setText(favoritesModel.getRepo_description());
            fab.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFFFFFFF")));
            fab.setImageTintList(ColorStateList.valueOf(Color.parseColor("#D50000")));
        }
    }
}
