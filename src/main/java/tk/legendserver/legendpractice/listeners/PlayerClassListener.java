package tk.legendserver.legendpractice.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import tk.legendserver.legendpractice.LegendPractice;
import tk.legendserver.legendpractice.player.LegendPlayerManager;

public class PlayerClassListener implements Listener
{

    // This listener serves two purposes. Ensure a player is
    // set to use the CORRECT custom LegendPlayer class.
    // And ensure a player is removed from the player manager.

    // onJoin:
    // Registers the player into the player manager.

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event)
    {
        Player player = event.getPlayer();

        event.setJoinMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "+" + ChatColor.GRAY + "]" + " " + ChatColor.GREEN + player.getName());

        LegendPlayerManager pMan = LegendPractice.getInstance().getPlayerManager();
        pMan.registerPlayer(player);
    }

}