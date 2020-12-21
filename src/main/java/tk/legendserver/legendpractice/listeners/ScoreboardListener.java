package tk.legendserver.legendpractice.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import tk.legendserver.legendpractice.scoreboards.LobbyScoreboard;

public final class ScoreboardListener implements Listener
{

    // This listener is used to handle scoreboards.+
    // Listens for join, leave, world change, etc.

    // onJoin:
    // Sends the scoreboard according to the level.

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event)
    {
        Player player = event.getPlayer();

        // Send lobby scoreboard
        new LobbyScoreboard(player);

    }

}