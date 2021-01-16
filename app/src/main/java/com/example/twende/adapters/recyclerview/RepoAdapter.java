package com.example.twende.adapters.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.twende.MainActivity;
import com.example.twende.R;
import com.example.twende.model.Repo;

import java.util.ArrayList;
import java.util.List;

public class RepoAdapter extends RecyclerView.Adapter<RepoAdapter.ViewHolder> {

    private static final String TAG = "CategoryAdapter";

    private List<Repo> repos;
    private Context mCtx;

    public RepoAdapter(Context mCtx, List repos ) {
        this.repos = repos;
        this.mCtx = mCtx;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.item_repository, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final Repo repo = repos.get(position);

        holder.setDetails(repo);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Toast.makeText(mCtx, repo.get_name(), Toast.LENGTH_SHORT).show();
                MainActivity.onItemClick(repo.getName(), repo.getDescription(), repo.getForks(), repo.getStars(), repo.getWatchers());

            }
        });

    }

    @Override
    public int getItemCount() {
        return repos.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public TextView repoName;
        public TextView repoDescription;


        ViewHolder(@NonNull View itemView) {
            super(itemView);

            repoName = itemView.findViewById(R.id.repoName);
            repoDescription = itemView.findViewById(R.id.repoDescription);

        }

        void setDetails(Repo repo) {

            repoName.setText(repo.getName());
            repoDescription.setText(repo.getDescription());

        }
    }
}
