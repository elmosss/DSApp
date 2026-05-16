package com.example.dsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.app.AlertDialog;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dsapp.network.NetworkClient;

import java.util.List;

import protocol.PlayRequest;
import protocol.PlayResponse;
import shared.Game;
import shared.Player;

public class GameAdapter extends RecyclerView.Adapter<GameAdapter.ViewHolder> {

    private List<Game> games;
    private Player player;
    private Context context;

    public GameAdapter(Context context, List<Game> games, Player player) {
        this.context = context;
        this.games = games;
        this.player = player;
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
                .inflate(R.layout.game_item, parent, false); //pairnei to xml layout kai to metatrepei se view
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Game g = games.get(position);
        holder.gameName.setText(g.getGameName()); //dinei onomata sta games

        holder.playButton.setOnClickListener(v -> {//otan patithei to play gia kapoio ap ta games
            EditText betInput = new EditText(context);
            betInput.setHint("Enter bet amount");

            new AlertDialog.Builder(context) //dimiourgia popup gia na dothei custom bet amount ap ton xristi
                    .setTitle("Play " + g.getGameName())
                    .setMessage("Give bet amount:")
                    .setView(betInput)
                    .setPositiveButton("PLAY", (dialog, which) -> {

                        String betText =
                                betInput.getText().toString().trim();

                        if (betText.isEmpty()) {  //an o xristis den grapsei tipota os bet emfanizei to parakato

                            Toast.makeText(
                                    context,
                                    "Give bet amount",
                                    Toast.LENGTH_SHORT
                            ).show();

                            return;
                        }

                        double betAmount =
                                Double.parseDouble(betText); //metatropi tou dosmenou bet apo text se actual double

                        new Thread(() -> { //trexei to PlayRequest se background thread oste na min pagosei to UI
                            try {

                                PlayRequest req = new PlayRequest(
                                        player,
                                        g.getGameName(),
                                        betAmount
                                );

                                Object resp = NetworkClient.sendRequest(req); //apostoli toy playrequest ston master

                                if (resp instanceof PlayResponse) {

                                    PlayResponse pr = (PlayResponse) resp;

                                    ((AppCompatActivity) context).runOnUiThread(() -> {

                                        String resultMessage =
                                                pr.getMessage()
                                                        + "\nBalance: "
                                                        + pr.getCurrentBalance();

                                        Toast.makeText(
                                                context,
                                                resultMessage,
                                                Toast.LENGTH_LONG
                                        ).show();
                                    });
                                }

                            } catch (Exception e) {

                                e.printStackTrace();

                                ((AppCompatActivity) context).runOnUiThread(() -> {

                                    Toast.makeText(
                                            context,
                                            "Play failed",
                                            Toast.LENGTH_SHORT
                                    ).show();
                                });
                            }
                        }).start();
                    })
                    .setNegativeButton("CANCEL", null)
                    .show();

        });
    }

    @Override
    public int getItemCount() {
        return games.size();
    }
}
