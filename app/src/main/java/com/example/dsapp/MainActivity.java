package com.example.dsapp;
import com.example.dsapp.network.NetworkClient;
import protocol.PlayerRequest;
import protocol.SearchGamesRequest;
import protocol.SearchGamesResponse;
import shared.Filters;
import shared.Game;
import shared.Player;

import android.view.View;
import android.widget.Toast;
import java.util.List;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.activity.EdgeToEdge;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private final int DARK_BACKGROUND = 0xFF121212;
    private final int DARK_TEXT = 0xFFFFFFFF;

    private final int LIGHT_BACKGROUND = 0xFFFFFFFF;
    private final int LIGHT_TEXT = 0xFF000000;
    EditText playerIdInput;
    Button searchButton;
    Button changeLight;
    boolean isDarkMode = true;
    ScrollView mainLayout;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this)); //emfanizei games to ena kato ap tallo
        playerIdInput = findViewById(R.id.playerIdInput);
        searchButton = findViewById(R.id.searchButton);
        changeLight = findViewById(R.id.changeLight);
        mainLayout = findViewById(R.id.mainLayout);

        changeLight.setOnClickListener(v -> {

            if (isDarkMode) {
                // Light mode
                mainLayout.setBackgroundColor(LIGHT_BACKGROUND);
                playerIdInput.setTextColor(LIGHT_TEXT);
                playerIdInput.setHintTextColor(0xFF666666);
                changeLight.setText("Dark Mode");

                isDarkMode = false;

            } else {
                // Dark mode
                mainLayout.setBackgroundColor(DARK_BACKGROUND);
                playerIdInput.setTextColor(DARK_TEXT);
                playerIdInput.setHintTextColor(0xFFAAAAAA);
                changeLight.setText("Light Mode");

                isDarkMode = true;
            }
        });

        searchButton.setOnClickListener(v -> {
            String playerId = playerIdInput.getText().toString().trim();

            if (playerId.isEmpty()) {
                Toast.makeText(this, "Give player ID", Toast.LENGTH_SHORT).show();
                return;
            }

            new Thread(() -> {
                try {
                    Player player = new Player(playerId, 0.0);
                    NetworkClient.sendRequest(new PlayerRequest("ADD_PLAYER", player, 0.0));

                    Filters filters = new Filters(player.getPlayerId(), 1, null,null);
                    Object resp = NetworkClient.sendRequest(new SearchGamesRequest(filters));

                    if (resp instanceof SearchGamesResponse) {
                        List<Game> games = ((SearchGamesResponse) resp).getGames();

                        runOnUiThread(() -> {
                            GameAdapter adapter = new GameAdapter(games); //emfanizei ta diathesima games
                            recyclerView.setAdapter(adapter);
                        });

                        StringBuilder sb = new StringBuilder();
                        sb.append("Player: ").append(playerId).append("\n\n");

                        for (Game g : games) {
                            sb.append(g.getGameName())
                                    .append(" | Risk: ").append(g.getRiskLevel())
                                    .append(" | Stars: ").append(g.getStars())
                                    .append(" | Bet: ").append(g.getBetCategory())
                                    .append(" | Jackpot: ").append(g.getJackpot())
                                    .append("\n");
                        }
                    } else {
                        //ebgala kati alla isos xreiastei na balo kati
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        });
    }
}