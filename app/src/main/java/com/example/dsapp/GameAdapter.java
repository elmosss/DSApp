package com.example.dsapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import shared.Game;

public class GameAdapter extends RecyclerView.Adapter<GameAdapter.ViewHolder> {

    private List<Game> games;

    public GameAdapter(List<Game> games) {
        this.games = games;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView gameName;
        Button playButton;

        public ViewHolder(View itemView) {
            super(itemView);
            gameName = itemView.findViewById(R.id.gameName);
            playButton = itemView.findViewById(R.id.playButton);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.game_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Game g = games.get(position);
        holder.gameName.setText(g.getGameName());
    }

    @Override
    public int getItemCount() {
        return games.size();
    }
}
